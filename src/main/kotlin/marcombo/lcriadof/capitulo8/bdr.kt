/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 8: BASES DE DATOS
 */

package marcombo.lcriadof.capitulo8

import java.sql.*


abstract class basedatos { // 1
    var conexion: Connection?=null // 2
    var campos: MutableList<String> = mutableListOf() // 3
    var items = HashMap<String, String>() // 4
    var st:PreparedStatement?=null // 5
    var stmt: Statement?= null // 6

    open fun conectar(url:String){} //7

    open fun campos(tabla: String) { } // 8



    fun desconectar() { // 9
        try {
            conexion!!.close()
            println("Conexión cerrada")
        } catch (sqlEx: SQLException) {
        }
    }
    fun escribir(consultaInsert: String):Int { // 10
        var r: Int=0
        try {
            st = conexion?.prepareStatement(consultaInsert)
            r= st?.executeUpdate()!!
        } catch (ex: SQLException) {
            r=99
        }
        return r
    }
    fun crear(consulta: String) { // 11
        val c:Int= escribir(consulta)
        println("script de creación-> "+consulta)
        if (c==99){
            println("Error al crear la tabla")
        }


    }

    fun leer(tabla: String, where: String="",simboloFinal:String=";"): HashMap<Int, String> { //12
        var leerRegistros = HashMap<Int, String>()
        var i = 0;
        var trabajo: String = "";
        val consulta: String = if (where != "") "select * from " + tabla + " where " + where+simboloFinal else "select * from " + tabla+ simboloFinal
        var resultado: ResultSet? = null
        println("consulta: "+consulta)
        try {
            stmt = conexion!!.createStatement()  // 13
            resultado = stmt?.executeQuery(consulta)  // 14
            while (resultado!!.next()) { // 15
                trabajo = gCampos(resultado, ",") // 16
                leerRegistros.set(i, trabajo) // 17
                i++
            }
        } catch (ex: SQLException) {
            ex.printStackTrace()
        }
        return leerRegistros // 18
    } // fin metodo leer






    fun gCampos(): HashMap<String, String> {
        return items
    }

    protected fun gCampos(resultado: ResultSet?, separador:String):String  {
        var i=0
        var nomCampo=""
        var tipoCampo:String?=""
        var cadena:String="{"
        var lenCampos=campos.size

        while (i < lenCampos){
            nomCampo= campos.get(i)
            tipoCampo=items.get(nomCampo)

            if (tipoCampo.equals("TEX") ){
                cadena=cadena+resultado?.getString(nomCampo)+separador
            }
            if (tipoCampo.equals("NUM") ){
                cadena=cadena+resultado?.getInt(nomCampo)+separador
            }
            i++
        }
        cadena=cadena.substring(0,cadena.length-1)+"}"

        return cadena
    } // fin de metodo gCamposSelect



    protected fun deleteCampos(){
        var hasta:Int=campos.size
        if (hasta>1) {
            for (n in hasta-1 downTo 0){  // muy importante de atras a delante, xq la Lista va acortando sus elementos dinamicamente
                campos.removeAt(n)
            }
           // println("borrado."+campos)
        }

        hasta=items.size
        if (hasta>0) {
            items.clear()
            //println("borrado."+items)
        }

    } // fin del método deleteCampos()

} // fin de clase