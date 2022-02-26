/*
El gran libro de Kotlin
(para programadores de back end)

Editor: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)
 */

package marcombo.lcriadof.capitulo4

import java.io.File
// programa c4p5.kt: contar lineas de un fichero de texto y lo muestra por pantalla
fun main() {
    var contar=0
    try {
        File("/tmp/kotlin/f3.txt").forEachLine { contar++ }  // [1]
        println("El fichero tiene $contar líneas")                    // [2]
    } catch (e: Exception) {
        println(e)
    }
}