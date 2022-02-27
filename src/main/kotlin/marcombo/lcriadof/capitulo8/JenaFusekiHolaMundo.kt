/*
El gran libro de Kotlin
(para programadores de back end)

Editor: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 8: BASES DE DATOS
 */

package marcombo.lcriadof.capitulo8

import org.apache.jena.query.QueryFactory
import org.apache.jena.query.ResultSet
import org.apache.jena.query.ResultSetFormatter
import org.apache.jena.rdfconnection.RDFConnectionFuseki

// ejemplo extraido de
//   https://github.com/apache/jena/tree/main/jena-examples/src/main/java/rdfconnection/examples

fun main(){
    val builder = RDFConnectionFuseki.create()
            .destination("http://192.168.0.20:8080/test/sparql")
    val query = QueryFactory.create("SELECT * { BIND('!Hola Mundo¡' as ?text) }")
    builder.build().use { conn -> conn.queryResultSet(query) { qresults: ResultSet? -> ResultSetFormatter.out(qresults) } }
}