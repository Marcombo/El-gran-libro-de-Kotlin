/*
El gran libro de Kotlin
(para programadores de back end)

Editor: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)
 */

package marcombo.lcriadof.capitulo4

import java.io.File
// ejemplo inspirado en
//   https://jamie.mccrindle.org/posts/exploring-kotlin-standard-library-part-2/
fun main() {
    try {
     if (File("/tmp/kotlin/f6.txt").exists()) {  // [1]
         File("/tmp/kotlin/f6.txt").delete()     // [2]
     }
     File("/tmp/kotlin/f3.txt").copyTo(File("/tmp/kotlin/f6.txt"))
    }
    catch (e: Exception) {
        println(e)
    }
}