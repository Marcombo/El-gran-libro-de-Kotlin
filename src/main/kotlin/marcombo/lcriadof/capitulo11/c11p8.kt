package marcombo.lcriadof.capitulo11

import kotlinx.coroutines.*

// funciones de suspensión:
//        Una función con el modificador de suspensión puede parar la ejecución del código sin bloquear el hilo actual de ejecución
//        además puede invocar otras funciones de suspensión.
//
//        Una función de suspensión no se puede invocar desde un código regular,
//        sino solo desde otras funciones de suspensión y desde lambdas de suspensión

// runBlocking  es un generador de corrutinas que une el mundo sin corrutinas de un fun main() normal
//    y el código con corrutinas dentro de runBlocking


fun main()= runBlocking() {
    var num=0
    repeat(10) {
        launch {
            num = doWorld(num++)
            println(num)
        }
    }
    println("Hello")



}

suspend fun doWorld(n:Int):Int {
    delay(1000L)
    println("World!")
    return 12+n
}