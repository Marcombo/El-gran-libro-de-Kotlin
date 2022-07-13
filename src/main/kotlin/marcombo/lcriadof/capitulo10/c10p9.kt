package marcombo.lcriadof.capitulo10
/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 10: CADENAS.
 */

fun main() {
// separacion de palabras Split
    val word = "Lo más incomprensible del universo es que es comprensible"
    val termino: List<String> = word.split(" ") // [1]
    // val termino = word.split(" ") // [2]

     termino.forEach { it -> println(it) } // [3]
    println()

    println(termino) // [4]
    println(termino[4]) // [5]
}