/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 6: CLASES
 */

package marcombo.lcriadof.capitulo6


class prueba { // 1
    companion object {
        var num = 77
    }
    fun siguiente() {
        num++
        println(num)
    }
}


class prueba2 { // 2
    companion object {
        var num = 77
    }
    fun siguiente() {
        num++
        println(num)
    }
}

fun main() {

    println("--- estamos en 1 --")
    prueba().siguiente() // 1
    prueba().siguiente() // 1
    var a=prueba() // 1

    println("--- cambio a 2 --")
    prueba2().siguiente() // 2
    prueba2().siguiente() // 2
    println("--- cambio a 1 --")
    prueba().siguiente() // 1
    a.siguiente() // 1
}