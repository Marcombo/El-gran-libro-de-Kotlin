/*
El gran libro de Kotlin
(para programadores de back end)

Editor: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)
 */

package marcombo.lcriadof.capitulo4
// c4p9.kt

// esto es un objeto estático puente para permitir que desde kotlin
// se pueda acceder a los recursos del proyecto maven
object recursos { // 1
    fun main() {} // 2
}

// otra forma más
class recurso2




fun main() {
    val fichero="/HolaMundo/hola.html" // 3
    val pathAbsoluto = recurso2::class.java.getResource(fichero).toURI()  // 4

    val fileContent = recurso2::class.java.getResource(fichero).readText()  // 5
    println("\nContenido: \n"+fileContent)

    println("Recurso en: "+pathAbsoluto)
}
