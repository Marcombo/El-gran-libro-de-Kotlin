package marcombo.lcriadof.capitulo11
import kotlinx.coroutines.*

/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 11: CONCURRENCIA
 */

fun main()=runBlocking() {

    val totalTime = async {
        val t0 = System.currentTimeMillis()
        (1..5).forEach {
            delay(300)
            println("¡Palabra $it encontrada!")
        }
        System.currentTimeMillis() - t0

    }

    println("Tiempo empleado: ${totalTime.await()}")
}