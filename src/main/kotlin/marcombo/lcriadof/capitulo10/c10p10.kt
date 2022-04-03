package marcombo.lcriadof.capitulo10
/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 9: CADENAS Y PALABRAS.
 */

fun main() {
// quitar espacios en blanco

    var cadena = "    Esto   es una prueba    \t   "
    println("["+cadena+"]")
    println("cadena tiene ${cadena.length} caracteres\n")

    cadena = cadena.trimEnd() // elimina los espacios en blanco finales
    println("["+cadena+"]")
    println("cadena tiene ${cadena.length} caracteres\n")

    cadena = cadena.trimStart() // elimina los espacios en blanco iniciales
    println("["+cadena+"]")
    println("cadena tiene ${cadena.length} caracteres\n")


    var cadena2 = "    Esto   es una prueba    \t   "
    cadena2 = cadena2.trim() // elimina todos los espacios en blanco iniciales y finales
    println("["+cadena+"]")
    println("cadena2 tiene ${cadena2.length} caracteres")


}