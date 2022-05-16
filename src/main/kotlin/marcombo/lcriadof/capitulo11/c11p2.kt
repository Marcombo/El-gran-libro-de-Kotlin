package marcombo.lcriadof.capitulo11

import kotlin.concurrent.*

/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 11: CONCURRENCIA
 */

fun main() {
    val hilo1=Thread(Runnable {
        for (i in 1..1000){
            println("hilo 1, contando... voy por $i ------------------------------------------")
            if (i==600){
                println("*************************************************************hilo 1 DURMIENDO")
                Thread.sleep(1000) // [1] paramos el hilo principal 1 segundos
                println("*************************************************************hilo 1 DESPIERTO")
            }
        }
        println("hilo 1 TERMINADO")
    })

    val hilo2=Thread(Runnable {
        for (i in 1..1000){
            println("hilo 2, contando... voy por $i")
        }
        println("hilo 2 TERMINADO")

    })


    hilo1.start()
    hilo2.start()


    hilo1.join() // esperamos finalización de los hilos
    hilo2.join()


    println("Fin del programa ")

}