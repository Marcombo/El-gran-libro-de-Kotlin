package marcombo.lcriadof.capitulo11
import kotlinx.coroutines.*

/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 11: CONCURRENCIA

runBlocking() con async
 */

fun main() {

    val t0principal = System.currentTimeMillis()

    runBlocking() {
        val sumaNumero = async {
            var a = 0.0
            for (i in 1..10000000) {
                a = a + i
            }
            a // [1]
        }
        val totalTiempo1 = async {
            val t0 = System.currentTimeMillis()
            (1..5).forEach {
                delay(300)
            }
            System.currentTimeMillis() - t0 // [1]

        }
        println("La suma es: ${sumaNumero.await()}") // [2]
        println("Tiempo en totalTiempo1: ${totalTiempo1.await()}") // [2]
    }

    println("Tiempo total del programa principal: ${System.currentTimeMillis() - t0principal}")
}