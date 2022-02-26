/*
El gran libro de Kotlin
(para programadores de back end)

Editor: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)
 */

package marcombo.lcriadof.capitulo4

import java.io.File

// programa p2.kt: guarda un fichero de texto
fun main() {
  File("/tmp/kotlin/f2.txt").writeText("¡Hola Mundo!")
}
