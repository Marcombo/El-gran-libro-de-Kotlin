package marcombo.lcriadof.capitulo11

import kotlinx.coroutines.*
import kotlin.concurrent.thread

/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 11: CONCURRENCIA
 */


fun main() {
    println("Técnica de monitor \n")

    val h1 = hiloGestionadoPorMonitor() // bloque [1]
    val h2 = hiloGestionadoPorMonitor()
    val h3 = hiloGestionadoPorMonitor()

    h1.start() // bloque [2]
    h2.start()
    h3.start()

    h1.join() // bloque [3]
    h2.join()
    h3.join()

    println("Valor final del object: " + Contador.count) // [4]
}




class hiloGestionadoPorMonitor() : Thread() { // [5]

    override fun run() { // [6]
        println("$name: Esperando permiso de acceso al recurso compartido")
        val rnd=(2..9).random() // [7]
        incrementar(rnd) // [8]
        println("$name: liberado: permitido")
    }


    @Synchronized // [9]
    fun incrementar(rnd:Int){ // [10]
        println("$name: Permiso concedido, con num aleatorio $rnd")
        for (i in 0..rnd) { // [11]
            Contador.count++ // [12]
        }
        println(name + ": Valor del object:" + Contador.count)
    }


}
