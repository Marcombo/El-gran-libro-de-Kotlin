/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 4: POCO CÓDIGO Y GRANDES RESULTADOS
 */

package marcombo.lcriadof.capitulo4

import java.io.File
// c4p7.kt: copiar un fichero en otro
//   orden copy
fun main( args: Array<String>  ) {                    // 1
    val origen:String="/tmp/kotlin/"+args[0]  // 2
    val destino:String="/tmp/kotlin/"+args[1]  // 3
    if (File(destino).exists()) {                     // 4
        File(destino).delete()                        // 5
    }

    try {
        File(origen).copyTo(File(destino))
        println("Se ha copiado $origen en $destino")
    } catch (e: Exception) {
        println(e)
    }
}