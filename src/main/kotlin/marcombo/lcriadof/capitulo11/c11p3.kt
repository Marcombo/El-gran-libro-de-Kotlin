package marcombo.lcriadof.capitulo11
import java.util.concurrent.Semaphore // [1]
/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 11: CONCURRENCIA
 */

fun main() {

        val s = Semaphore(1) // [2]

        val h1 = hiloGestionadoPorSemaforo(s) // [3]
        val h2 = hiloGestionadoPorSemaforo(s)
        val h3 = hiloGestionadoPorSemaforo(s)


        h1.start() // [4]
        h2.start()
        h3.start()

        h1.join() // [5]
        h2.join()
        h3.join()


        println("Valor final del object: " + Contador.count)

}


object Contador {  // [6]
    var count = 0
}


class hiloGestionadoPorSemaforo(var s: Semaphore) : Thread() { // [7]
    override fun run() { // [8]
        println("$name: Comenzando la ejecución")
        println("$name: Esperando permiso de acceso al recurso compartido")
        val rnd=(2..5).random()
        s.acquire() // [9]

        // [10]
        println("$name: Permiso concedido")
        for (i in 0..rnd) {
            Contador.count++
        }
        println(name + ": Valor del object:" + Contador.count)
        // fin de [10]

        s.release() // [11]
        println("$name: liberado: permitido")

    }
}
