package marcombo.lcriadof.capitulo11

import java.io.File
import java.util.concurrent.SynchronousQueue
import kotlin.concurrent.thread

fun main(){

    val cola = SynchronousQueue<String>()  // [1]

    val productor = thread(start = false) { // [2]
        File("/tmp/kotlin/f6.txt").forEachLine { line -> cola.put(line) }  // [3]
        cola.put("fin")  // [4]  señal de finalización para un hilo consumidor
    }

    class consumidor() : Thread() { // [4]
        var contador = 0  // [5]
        override fun run() {  // [6]
            var consumirLinea:String=""
            while (true) { // [7]
                consumirLinea = cola.take().toString().trim() // [8]
                if (consumirLinea.equals("fin")){ // [9]
                    break // [10]
                }
                println("${Thread.currentThread().name}: $consumirLinea")
                contador++ // [11]
            }
            println("${Thread.currentThread().name}: terminado run()") // [12]
        }
    }

    productor.start() // [13]
    val hilo1=consumidor() // [14]
    hilo1.start() // [15]
    hilo1.join() // [16]
    productor.join() // [17]
    println("total de lineas consumidas: "+(hilo1.contador)) // [18]
    println("Fin del programa ")


}