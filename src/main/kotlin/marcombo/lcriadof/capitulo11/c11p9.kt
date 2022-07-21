package marcombo.lcriadof.capitulo11
/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 11: CONCURRENCIA

 */
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    val canal = Channel<String>() // [0]

    launch { // [1]
        canal.send("lote: 83838833-1") // [3]
        canal.send("lote: 93939393-2") // [3]
        println("Terminado el envio corrutina 1")
    }

    launch { // [1]
        canal.send("lote: 93939393-3") // [3]
        println("Terminado el envio  corrutina 2")
    }

    launch { // [2]
        repeat(3) {
            val x = canal.receive() // [4]
            println("recibido: "+x)
        }
    }
}