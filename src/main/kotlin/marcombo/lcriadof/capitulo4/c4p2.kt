/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 4: POCO CÓDIGO Y GRANDES RESULTADOS
 */

package marcombo.lcriadof.capitulo4

import java.io.File

// programa p2.kt: guarda un fichero de texto
fun main() {
  File("/tmp/kotlin/f2.txt").writeText("¡Hola Mundo!")
}
