/*
El gran libro de Kotlin
(para programadores de back end)

Editor: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 8: BASES DE DATOS
 */

package marcombo.lcriadof.capitulo8

/*
docker ps
docker ps -a
docker start [id]
 */

// import marcombo.lcriadof.capitulo8.basedatos
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.SQLException
// import java.sql.Statement


fun main() {
    var sql = oracle("test","secret")
    var url: String
    var insert: String
    var crearTabla:String


    url = "jdbc:oracle:thin:@192.168.0.20:15210:xe"  //  this.connectionURL="jdbc:oracle:thin:@"+ipmaquina+":"+puerto+":"+instancia;

    sql.conectar(url)
    crearTabla="CREATE TABLE continentes2 (id NUMBER(1) NOT NULL,continente VARCHAR2(50 BYTE) DEFAULT NULL)"
    sql.crear(crearTabla)
    sql.escribir("COMMIT")
    sql.desconectar()
}



// clase Sqlite hereda del Interface bbdd
class oracle(var userName:String, var passwd:String): basedatos() {
    //var stmt: Statement? = null


    override fun conectar(url:String){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            println("Intentando conectar con " +url+"; user:"+userName+" clave:"+passwd)
            conexion = DriverManager.getConnection(url, userName,passwd);
            stmt=conexion?.createStatement()
            if (conexion != null) {
                println("Conectado: " + conexion?.metaData)
            } // fin de if
        } catch (ex: SQLException) {
            println("Problemas al conectar con la BBDD")
        }
    }



    override fun campos(tabla:String){
        val consulta="SELECT * FROM ALL_TAB_COLUMNS where OWNER='TEST' and TABLE_NAME = UPPER('"+tabla+"')"
        this.estructura(consulta)
     }




    private fun estructura(consulta: String,vararg buscarCampo:String) = try {

        var name:String=""
        var type:String=""
        var resultado: ResultSet? = null

        // si hubiese campos previos de otras tablas las borramos para evitar errores
        deleteCampos()

        //stmt = conexion?.createStatement()
        resultado = stmt?.executeQuery(consulta);

        var n=0
        while (resultado?.next()!!) {
            n++
            name = resultado.getString("column_name")
            type = resultado.getString("data_type")

            if (type.contains("NUMBER") ){
                type="NUM"
            }
            if (type.contains("VARCHAR2") ){
                type="TEX"
            }
            items.set( name,type)
            campos.add(name)
        } /* fin de while */

    } catch (ex: SQLException) {
        println("Problemas al acceder a disco")
    } // fin de metodo



    // nombre_tabla_buscada
}