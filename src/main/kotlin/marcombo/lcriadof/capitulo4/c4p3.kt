/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 4: POCO CÓDIGO Y GRANDES RESULTADOS
 */

package marcombo.lcriadof.capitulo4

import java.io.File

// programa p3.kt: escribe un fichero de texto y lo muestra por pantalla
fun main() {
    val directorio:String="/tmp/kotlin/"      // [1]
    val f = File(directorio, "f3.txt")   // [2]
    if (f.exists()){                          // [3]
        f.writeText("")                  // [4]
    }
    var c=0
    for (x in 1..100){                        // [5]
        f.appendText(x.toString()+"\n")  // [6]
        c++
     }
    println(c)

}

