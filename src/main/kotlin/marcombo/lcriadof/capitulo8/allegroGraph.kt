/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 8: BASES DE DATOS
 */

package marcombo.lcriadof.capitulo8

import com.franz.agraph.jena.AGGraphMaker
import com.franz.agraph.jena.AGModel
import com.franz.agraph.jena.AGQueryExecutionFactory
import com.franz.agraph.jena.AGQueryFactory
import com.franz.agraph.repository.AGRepositoryConnection
import com.franz.agraph.repository.AGServer
import org.apache.jena.query.QueryExecution
import java.lang.Exception
import java.util.ArrayList


fun main(){
   val oAllegroGraph:allegroGraph=allegroGraph("http://192.168.0.20","10035",use="admin",pass="secret") // [1]

    val maker = oAllegroGraph.modeloDelRepositorio(false) // [2]
    val consulta="PREFIX table: <http://www.daml.org/2003/01/periodictable/PeriodicTable#> " +
            "SELECT ?name ?symbol ?number " +
            "WHERE {"+
            "    ?element table:name ?name."+
            "    ?element table:symbol ?symbol."+
            "    ?element table:atomicNumber ?number.}" // [3]

    oAllegroGraph.ejecutarSparql(maker,consulta) // [4]
}


class allegroGraph (var servidor:String,var puerto:String, var use:String, var pass:String, var repositorio:String="test",  var catalogo:String="/"){

    var SERVER_URL = servidor+":"+puerto
    var USERNAME = use
    var PASSWORD = pass
    var CATALOG_ID = catalogo
    var REPOSITORY_ID = repositorio


    private fun conectarRepositorio(): AGGraphMaker? {
        val server = AGServer(SERVER_URL, USERNAME, PASSWORD)
        println("Catálogos disponibless: " + server.listCatalogs())

        val catalog = server.getCatalog(CATALOG_ID)
        println("Repositorios disponibles en el catálogo "
                + "[" + catalog.catalogName + "] : "
                + catalog.listRepositories())
        closeAll()

        println("Accediendo al repositorio " + REPOSITORY_ID)
        val myRepository = catalog.createRepository(REPOSITORY_ID)
        println("Inicializando y revisando declaraciones del repositorio " + REPOSITORY_ID)
        myRepository.initialize()
        val conn = myRepository.connection
        closeBeforeExit(conn)
        println("El repositorio " + myRepository.repositoryID
                + " disponible. Actualmente contiene " + conn.size() + " declaraciones.")
        val maker = AGGraphMaker(conn)
        println("Repositorio " + REPOSITORY_ID + " ok")
        return maker
    }


    fun modeloDelRepositorio(close: Boolean): AGModel? {
        val maker = conectarRepositorio()
        val graph = maker!!.graph
        val model = AGModel(graph)
        println("\nModelo del repositorio Ok.")
        if (close) {
            model.close()
            graph.close()
            maker.close()
            return null
        }
        return model
    }

    fun ejecutarSparql(model: AGModel?, consulta:String="SELECT ?name ?symbol ?number  WHERE {?name ?symbol ?number .} LIMIT 10") {
        println("\nResultado de consultas.")
        try {
            val queryString = consulta
            val sparql = AGQueryFactory.create(queryString)
            val qe: QueryExecution = AGQueryExecutionFactory.create(sparql, model)
            try {
                val results = qe.execSelect()
                while (results.hasNext()) {
                    val result = results.next()
                    val name  = result["name"].toString()
                    val symbol  = result["symbol"].toString()
                    val number = result["number"].toString()
                    println(" $name; $symbol ; $number ")
                }
            } finally {
                qe.close()
            }
        } finally {
            model!!.close()
        }
    }

    internal fun closeAll() {
        while (toClose.isEmpty() == false) {
            val conn = toClose[0]
            close(conn)
            while (toClose.remove(conn)) {
            }
        }
    }

    private val toClose: MutableList<AGRepositoryConnection> = ArrayList()

    /**
     * This is just a quick mechanism to make sure all connections get closed.
     */
    internal fun closeBeforeExit(conn: AGRepositoryConnection) {
        toClose.add(conn)
    }

    fun close(conn: AGRepositoryConnection) {
        try {
            conn.close()
        } catch (e: Exception) {
            System.err.println("Error closing repository connection: $e")
            e.printStackTrace()
        }
    }
}