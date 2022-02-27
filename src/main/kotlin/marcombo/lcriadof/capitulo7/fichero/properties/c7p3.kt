/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 7: FICHEROS
 */

package marcombo.lcriadof.capitulo7.fichero.properties
import java.io.FileInputStream
import java.util.*

fun main(){


    try {
        val directorioRaiz:String="/tmp/kotlin/"

        val prop = Properties()
        val f=FileInputStream(directorioRaiz+"oracleBITver2.properties")
        prop.load(f)  // cargamos el fichero de propiedades
       
        val ip:String?=prop.getProperty("instancia.ip")
        val puerto:String?=prop.getProperty("instancia.puerto")
        val nombre:String?=prop.getProperty("instancia.nombre")
        val usuario:String?=prop.getProperty("usuario.nombre")
        val clave:String?=prop.getProperty("usuario.clave")

        println("Instancia a BBDD: $nombre    $ip:$puerto")
        println("  usuariao: $usuario clave:$clave")
    }catch (e: Exception) {
        println(e)
    }

}
