/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 8: BASES DE DATOS
 */

package marcombo.lcriadof.capitulo8

//import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.SQLException
//import marcombo.lcriadof.capitulo8.*
//import kotlin.collections.HashMap

fun main(){
    var sql=sqlite()
    var pathLocal:String
    var url:String
    var insert:String

    // escriba la ubicacion en su equipo, el fichero esta en la parte de resources
    pathLocal="D:/Datos/07_IDEA/AtreveteConKotlin/src/main/resources/sqlite/"



// para ejecutar el ejemplo 1
url=pathLocal+"base_7.db"
    println("\n\n---- Lenguajes de programación")
    sql.conectar(url)
    sql.campos("dictionary")
    println(sql.gCampos())
    println(sql.leer("dictionary"))
    sql.desconectar()



// para ejecutar el ejemplo 2 descomente este código
    /*
url=pathLocal+"estrellas.db"
    sql.conectar(url)
    sql.campos("clasificacion_harvard")
    println(sql.gCampos())

    println("lanzando select...")
    println(sql.leer("clasificacion_harvard","Clase=\"B\""))
    println(sql.leer("clasificacion_harvard"))
    sql.desconectar()
     */


}





// clase Sqlite hereda del Interface bbdd
class sqlite(): basedatos() {

    override fun conectar(url:String){
        try {
            conexion = DriverManager.getConnection("jdbc:sqlite:$url") // si no existe la bd la crea
            if (conexion != null) {
                println("Conectado: " + conexion?.metaData)
            } // fin de if
        } catch (ex: SQLException) {
            println("Problemas al acceder a disco")
        }
    }


    override fun campos(tabla:String){
        this.estructura("pragma table_info("+tabla+");","name","type")
    }


    private fun estructura(consulta: String,vararg buscarCampo:String) = try {
         val st = conexion?.prepareStatement(consulta)
         var name:String=""
         var type:String=""
         var resultado: ResultSet? = null

         // si hubiese campos previos de otras tablas las borramos para evitar errores
           deleteCampos()

         resultado = st?.executeQuery() // [1]
         var n=0
         while (resultado?.next()!!) {
             n++
             name = resultado?.getString("name").toString() // [2]
             type=resultado?.getString("type").toString() // [3]

             if (type.contains("INT") || type.contains("NUMERIC") ){ // [4]
                 type="NUM"
             }
             if (type.contains("VARCHAR") || type.contains("TEXT")){ // [5]
                 type="TEX"
             }
             items.set( name,type)  // [6]
             campos.add(name) // [7]
        } /* fin de while */

     } catch (ex: SQLException) {
         println("Problemas al acceder a disco")
     } // fin de metodo


} // fin de clase sqlite

