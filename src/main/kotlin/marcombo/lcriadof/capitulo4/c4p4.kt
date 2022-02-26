/*
El gran libro de Kotlin
(para programadores de back end)

Editor: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)
 */

package marcombo.lcriadof.capitulo4

import java.io.File

// programa c4p4.kt: lee un fichero de texto y lo muestra por pantalla
fun main() {


    // primera versión
    val lines = File("/tmp/kotlin/f3.txt").readLines()  // [2] codigo equivalente

    for (item in lines) {
        println("linea: $item")
    }
/*
    // segunda versión
    val lines = File("/tmp/kotlin/f3.txt").readLines()  // [2] codigo equivalente
    lines.forEach { println(it) }

    // tercera versión
    File("/tmp/kotlin/f3.txt").forEachLine { println(it) }  // [1]

    // cuarta versión
    try {
        File("/tmp/kotlin/f3.txt").forEachLine { println(it) }  // [1]
    }catch (e: Exception){
        println(e)
    }
*/


} // fin del programa