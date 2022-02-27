/*
El gran libro de Kotlin
(para programadores de back end)

Editor: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 7: FICHEROS
 */

package marcombo.lcriadof.capitulo7.fichero.xml// example from https://bezkoder.com/kotlin-xml-json/

import marcombo.lcriadof.capitulo7.fichero.recursos
import org.json.XML
import java.io.File

// convertir XML en JSON, puede ver la salida en el directorio del proyecto  target\classes\xml
fun main() {
    var url= recursos::class.java.getResource("/xml/").path
    var entrada= File(url+"Alpha Centauri.xml").readText()
    val json = XML.toJSONObject(entrada) // [1]
    File(url+"Alpha Centauri.json").writeText(json.toString(3)) //[2]
}

