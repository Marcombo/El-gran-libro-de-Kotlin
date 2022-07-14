package marcombo.lcriadof.capitulo11

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 11: CONCURRENCIA
 */



// comparando hilos y corrutinas
//------------------------------------
// ejemplo de https://refactorizando.com/coroutines-kotlin-vs-java-threads/


fun main() {

    // hilos
    println("Probando con thread")
        repeat(10) {
            Thread(Runnable {
                println(" Número ${it}: ${Thread.currentThread().name}")
            }).start()
        }
        Thread.sleep(100)
    println()

    // corrutinas
    println("Probando con corrutinas")
    repeat(10) {
        GlobalScope.launch {
            println("Antes de parar $it: ${Thread.currentThread().name}")
            delay(10)
            println("Despues de reanudar $it: ${Thread.currentThread().name}")
        }
    }
    Thread.sleep(200)




}