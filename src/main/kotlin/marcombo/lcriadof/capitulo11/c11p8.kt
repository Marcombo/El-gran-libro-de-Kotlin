package marcombo.lcriadof.capitulo11

/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 11: CONCURRENCIA

 */
import kotlinx.coroutines.*

// funciones de suspensión:
//        Una función con el modificador de suspensión puede parar la ejecución del código sin bloquear el hilo actual de ejecución
//        además puede invocar otras funciones de suspensión.
//
//        Una función de suspensión no se puede invocar desde un código regular,
//        sino solo desde otras funciones de suspensión (desde lambdas de suspensión) y desde corrutinas


fun main() {
    runBlocking() { // [1]
        launch {
            incrementar() // [2]
            delay(1000L) // [3]
            incrementar() // [2]
        }
        launch {
            incrementar() // [2]
            delay(10) // [3]
            incrementar() // [2]
        }
        launch {
            incrementar() // [2]
            delay(20) // [3]
            incrementar() // [2]
        }
    }
    println("Valor del contador ${Contador.count}") // [4]

}

suspend fun incrementar() { // [5]
    Contador.count++

}