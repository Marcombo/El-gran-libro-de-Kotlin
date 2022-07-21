package marcombo.lcriadof.capitulo11

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 11: CONCURRENCIA
 */
fun main(){

    runBlocking() { // [0]
        // corrutinas
        println("Probando con corrutinas")
        repeat(10) {
            launch()  { // [1]
                println("Antes de parar $it: ${Thread.currentThread().name}")
                delay(10)
                println("Despues de reanudar $it: ${Thread.currentThread().name}")
            }
        }
        // Thread.sleep(300) // [2]
    }
}

