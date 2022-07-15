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
    println("Probando con corrutinas")



    runBlocking() {

        println("principio 1")

        /*
        GlobalScope.launch() {
            println("\n parar")
            delay(10) // si el retardo es mayor que lo que tiene que hacer el reetos del código entonces la ejecucion se termina sin que acabe GlobalScope.launch()
            println("\n reanudar")
        }
        */



        var a = 0
        for (i in 1..10000) {
            print("$i, ")
        }


        println("final 1")
    }



    println("programa terminado")


}
