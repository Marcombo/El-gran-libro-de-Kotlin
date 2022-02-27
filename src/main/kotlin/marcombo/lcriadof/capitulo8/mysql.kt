/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 8: BASES DE DATOS
 */

package marcombo.lcriadof.capitulo8

//import marcombo.lcriadof.capitulo8.basedatos
import java.sql.*


fun main(){
    var sql= mySql()
    var url:String
    var insert:String
    var crearTabla:String

  /*
  docker run -d -p 33060:3306 --name mysql-db -e MYSQL_ROOT_PASSWORD=secret mysql

 // creamos BBDD
   docker exec -it mysql-db mysql -p
   create database test;
   use test
   exit;

   */
    url="jdbc:mysql://192.168.0.20:33060" // en otra máquina de mi red: en un docker


    sql.conectar(url)
    sql.use("test")
    crearTabla="CREATE TABLE `continentes` ( " +
               "  `id` int(1) NOT NULL AUTO_INCREMENT," +
               "  `continente` text NOT NULL, " +
               "  PRIMARY KEY (`id`));"
    sql.crear(crearTabla)
    sql.campos("continentes")
    println(sql.gCampos())
    sql.desconectar()



    sql.conectar(url)
    sql.use("test")
    insert="INSERT INTO `continentes` (`id`, `continente`) VALUES " +
            "(1, 'Norteamérica'), " +
            "(2, 'Sudamérica'), " +
            "(3, 'Asia'), " +
            "(4, 'Europa'), " +
            "(5, 'África'), " +
            "(6, 'Oceanía'), " +
            "(7, 'Antártida');"
    println(sql.escribir(insert))
    println(sql.leer("continentes"))
    sql.desconectar()


  //  sql.campos("paises")
  //  insert="INSERT INTO `paises` (`id_pais`, `id`, `pais`, `ciudad`) VALUES ('2', '4', 'España', 'Málaga');"
  //  println(sql.leer("paises","","ciudad"))  // ¡¡¡no funciona



}


class mySql (var username:String="root", var password:String="secret"): basedatos() {


    override fun conectar(url: String) {
        // url tipica: jdbc:mysql://127.0.0.1:3306+zonaHoraria
        // configura la zona horaria en la conexión
        val zonaHoraria = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
        val driver = "com.mysql.cj.jdbc.Driver"
        println("url de conexion a MySql: " + url)
        try {
            Class.forName(driver).newInstance()
            conexion = DriverManager.getConnection(url + zonaHoraria, username, password);
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
        val campo1="Field"
        try {
            stmt = conexion!!.createStatement()
            resultado = stmt!!.executeQuery("USE test;")
            stmt.execute("USE test;")
        } catch (ex: SQLException) {
            ex.printStackTrace()
        }
    }


    override fun campos(tabla: String) {
        this.estructura("SHOW COLUMNS FROM " + tabla + ";")
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
                resultado = stmt?.resultSet
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
