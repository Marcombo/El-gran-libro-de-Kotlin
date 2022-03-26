package marcombo.lcriadof.capitulo10
/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 9: CADENAS Y PALABRAS.
 */

fun main() {
// vacios o/y espacios

    val codigoEscape = "\r" //  (\b, \n, \r, \t, \', \", \\ y \$),
    val espacio = "  "
    val vacio = ""
    println(codigoEscape.isEmpty()) // false
    println(codigoEscape.isBlank()) // true
    println("---separador--")
    println(espacio.isEmpty()) // false
    println(espacio.isBlank()) // true
    println("---separador--")
    println(vacio.isEmpty()) // true
    println(vacio.isBlank()) // true

}