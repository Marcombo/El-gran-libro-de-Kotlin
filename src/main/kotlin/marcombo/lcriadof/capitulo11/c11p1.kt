package marcombo.lcriadof.capitulo11
/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 11: CONCURRENCIA
 */

fun main() {
    println("primer mensaje")
    Thread.sleep(5000) // [1]
    println("segundo mensaje")
}