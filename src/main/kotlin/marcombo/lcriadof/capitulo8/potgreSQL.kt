/*
El gran libro de Kotlin
(para programadores de back end)

Editor: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 8: BASES DE DATOS
 */

package marcombo.lcriadof.capitulo8

//import marcombo.lcriadof.capitulo8.basedatos
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement

fun main(){
    var sql= postgreSQL()
    var url:String
    var insert:String

    url="jdbc:postgresql://127.0.0.1:5432/prueba"

    sql.conectar(url)
   // sql.use("publico")
    sql.campos("Público.continente")
}


class postgreSQL (var username:String="postgres", var password:String="Polar30"): basedatos() {


    override fun conectar(url: String) {
        // url tipica: jdbc:mysql://127.0.0.1:3306+zonaHoraria
        // configura la zona horaria en la conexión
        val zonaHoraria = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
        val driver = "org.postgresql.Driver"
        println("url de conexion a postgreSQL: " + url)
        try {
            Class.forName(driver).newInstance()
            conexion = DriverManager.getConnection(url , username, password);
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } catch (ex: Exception) {
            // handle any errors
            ex.printStackTrace()
        }
    }


    fun use(esquema: String) {
        var stmt: Statement? = null
        var resultado: ResultSet? = null
        val consulta=" set search_path="+esquema+";"
        try {
            stmt = conexion!!.createStatement()
            resultado = stmt!!.executeQuery(consulta)
            stmt.execute(consulta)
        } catch (ex: SQLException) {
            ex.printStackTrace()
        }
    }


    override fun campos(tabla: String) {
        this.estructura("SHOW COLUMNS FROM " + tabla + ";")

/*  en potgresSQL es asi
        select column_name, data_type, is_nullable from information_schema.columns where table_name = 'productos';
*/
    }




    private fun estructura(consulta: String) {
        // val st = conn?.prepareStatement(consulta)
        var name: String = ""
        var type: String = ""
        var stmt: Statement? = null

        // si hubiese campos previos de otras tablas las borramos para evitar errores
        deleteCampos()

        var resultado: ResultSet? = null
        try {
            stmt = conexion!!.createStatement()
            if (stmt.execute(consulta)) { // SHOW COLUMNS FROM Continentes FROM test;
                resultado = stmt.resultSet
            }

            var n=0
            while (resultado!!.next()) {
                n++
                name = resultado?.getString("Field").toString()
                type=resultado?.getString("Type").toString()

                if (type.contains("int")  ){
                    type="NUM"
                }
                if (type.contains("text") || type.contains("TEXT")){
                    type="TEX"
                }
                items.set( name,type)
                campos.add(name)
                //println(name+" "+type)

            } /* fin de while */


        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        }

    }// fin de metodo



} // fin de clase
