package marcombo.lcriadof.capitulo11
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.Semaphore // [1]
/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 11: CONCURRENCIA
 */

// c11p3.kt adaptado a corrutinas

fun main()= runBlocking {

    val semaphore = Semaphore(1)


    GlobalScope.launch() {

        println(Thread.currentThread().name.toString())
        println("Comenzando la ejecución")
        println("Esperando permiso de acceso al recurso compartido")
        val rnd=(2..5).random()
        semaphore.acquire() // [9]

        // [10]
        println("Permiso concedido")
        for (i in 0..rnd) {
            Contador.count++
        }
        println("Valor del object:" + Contador.count)
        // fin de [10]

        semaphore.release() // [11]
        println("liberado: permitido")

    }






    println("El hilo principal continua")
    println("Valor final del object (hilo principal): " + Contador.count)

}



