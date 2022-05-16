package marcombo.lcriadof.capitulo11

import kotlin.concurrent.thread



/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 11: CONCURRENCIA
 */
fun main() {
    // En kotlin hay tres formas de crear hilos


    // bloque [1a]
    object : Thread() {
        override fun run() {
            println("PRIMERA FORMA: mediante herencia. Ejecutando un objeto con el hilo: ${Thread.currentThread().name}")
        }
    }.start()

    // bloque [1b]
    class forma1b() : Thread() {
        override fun run() {
            println("PRIMERA FORMA: mediante herencia. Ejecutando una clase con el hilo: ${Thread.currentThread().name}")
        }
    }
    val f1b = forma1b()
    f1b.start()



    // bloque [2]
    Thread({
        println("SEGUNDA FORMA: usando expresión lambda: ${Thread.currentThread().name}")
    }).start()

    // bloque [2b]
    Thread(Runnable {
        println("SEGUNDA FORMA: mediante Runnable: ${Thread.currentThread().name}")
    }).start()

    // bloque [2c]
    val segundo= Thread(Runnable {
        println("SEGUNDA FORMA: mediante Runnable, asignando a val: ${Thread.currentThread().name}")
    })
    segundo.start()



    // bloque [3a]


    thread(start = true) {
        println("TERCERA FORMA: utilizando soporte Kotlin -> thread(): ${Thread.currentThread().name}")
    }
    // bloque [3b]
    val tercero= thread(start = false) {
        println("TERCERA FORMA: utilizando soporte, asignando a val -> thread(): ${Thread.currentThread().name}")
    }
    tercero.start()



}