package marcombo.lcriadof.capitulo11

import kotlinx.coroutines.*

/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 11: CONCURRENCIA
 */


fun main() {

    // corrutinas
    println("Probando con corrutinas:  runBlocking() con launch()\n")


    runBlocking()  {
        println("mensaja 1")
        launch() {
            println("\nparar")
            delay(10) // da igual el tiempo que ponga, la corrutina siempre termina y despues termina el prog principal
            println("\nreanudar")
        }
        launch() {
            var a = 0
            for (i in 1..10000) {
                print("$i, ")
            }
        }
        println("mensaje 2")
    }
    println("programa terminado")
}
