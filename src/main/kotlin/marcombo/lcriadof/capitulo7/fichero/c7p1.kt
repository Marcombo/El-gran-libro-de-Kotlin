/*
El gran libro de Kotlin
(para programadores de back end)

Editor: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 7: FICHEROS
 */

package marcombo.lcriadof.capitulo7.fichero// c7p1.kt   gestion de logs
import org.apache.logging.log4j.LogManager


class pruebaLog {
    companion object {
        val logging = LogManager.getLogger() // 1
    }
    fun mostrar(){ // 2
        logging.error("Hola mundo!, nivel: error")
        logging.warn("Hola mundo!, nivel: warn ")
        logging.fatal("Hola mundo!, nivel: fatal ")
        logging.debug("Hola mundo!, nivel: Debug ")
        logging.trace("Hola mundo!, nivel: trace ")
        logging.info("Hola mundo!, nivel: info ")
    }
}

fun main() {
    var prueba = pruebaLog()   // 3
    prueba.mostrar()  // 4
}
