package marcombo.lcriadof.capitulo11
import kotlinx.coroutines.*
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

    val semaphore = Semaphore(1) // declaramos el semáforo


    val calculo =async() {  // la corrutina devuelve un valor

        println(Thread.currentThread().name.toString())
        println("Comenzando la ejecución")
        println("Esperando permiso de acceso al recurso compartido")
        val rnd=(2..5).random()
        semaphore.acquire() // [9] tenemos permiso al acceder al semaforo

        // [10]  este bloque incrementa el recurso compartido un numero de veces aleatorio en cada ejecución, una vez que ningún otro proceso puede usarlo
        println("Permiso concedido")
        for (i in 0..rnd) {
            Contador.count++
        }
        println("Valor del object:" + Contador.count)
        // fin de [10]

        semaphore.release() // [11] devolvemos el semaforo
        println("liberado: permitido")
        Contador.count // valor que devuelve la corrutina
    }






    println("El hilo principal continua")
    println("Valor final del object (hilo principal): " + calculo.await()) // con await() recuperamos el valor de la corrutina precisamente cuando esta termina
    println("Valor final del object (hilo principal): " + Contador.count)
}



