package marcombo.lcriadof.capitulo11
/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 11: CONCURRENCIA

 */
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val canal = Channel<String>()

    suspend fun incrementar2() { // [5]
        var lote=0
        Contador.count++
        lote=83838833+Contador.count
        canal.send(lote.toString()) // [3]
    }

    launch { // [1]
        incrementar2()
        incrementar2()
        println("Terminado el envio corrutina 1")
    }

    launch { // [1]
        incrementar2()
        println("Terminado el envio  corrutina 2")
    }

    launch { // [2]
        repeat(3) {
            val x = canal.receive() // [4]
            println("recibido: "+x)
        }
    }



}