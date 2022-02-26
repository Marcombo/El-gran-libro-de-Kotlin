/*
El gran libro de Kotlin
(para programadores de back end)

Editor: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)
 */

package marcombo.lcriadof.capitulo6

import java.sql.Connection
import java.sql.SQLException


abstract class basedatos() { // 1
    var conexion: Connection?=null
    var campos: MutableList<String> = mutableListOf()
    var items = HashMap<String, String>()


    open fun conectar(url:String){} // 2

    open fun leer(tabla:String,where:String=""){}

    fun escribir(consultaInsert: String):Int { //3
        var r: Int=0
        try {
            var st = conexion?.prepareStatement(consultaInsert)
            r= st?.executeUpdate()!!
        } catch (ex: SQLException) {
            println("Problemas al acceder a disco")
        }
        return r
    }

    fun desconectar() {
        try {
            conexion!!.close()
            println("Conexión cerrada")
        } catch (sqlEx: SQLException) {
        }
    }

} // fin de clase