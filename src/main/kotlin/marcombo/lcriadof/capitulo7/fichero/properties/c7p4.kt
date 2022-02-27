/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 7: FICHEROS
 */

package marcombo.lcriadof.capitulo7.fichero.properties

import java.io.FileOutputStream
import java.util.*

fun main(){


    try {
        val directorioRaiz:String="/tmp/kotlin/"

        val prop = Properties()
        val f= FileOutputStream(directorioRaiz+"oracleBITver2.properties")

        prop.put("instancia.ip","192.168.1.101")
        prop.store(f,"config acceso a BBDD")


    }catch (e: Exception) {
        println(e)
    }

}
