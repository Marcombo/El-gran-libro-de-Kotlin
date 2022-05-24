package marcombo.lcriadof.capitulo11


import java.io.File
import java.util.concurrent.SynchronousQueue
import kotlin.concurrent.thread


fun main(){

    val cola = SynchronousQueue<String>()  //  una cola de sincronización

    val productor = thread(start = false) {
        File("/tmp/kotlin/f6.txt").forEachLine { line -> cola.put(line) }

        cola.put("fin")  // bloque [4]
        cola.put("fin")
        cola.put("fin")
    }

    class consumidor() : Thread() {
        var contador = 0
        override fun run() {
            var consumirLinea:String=""
            while (true) {
                consumirLinea = cola.take().toString().trim()
                if (consumirLinea.equals("fin")){
                    break
                }
                println("${Thread.currentThread().name}: $consumirLinea")
                contador++
            }
            println("${Thread.currentThread().name}: terminado run()")       }
    }

    productor.start()

    val hilo1=consumidor()
    val hilo2=consumidor()
    val hilo3=consumidor()

    hilo1.start()
    hilo2.start()
    hilo3.start()


    hilo1.join()
    hilo2.join()
    hilo3.join()

    productor.join()
    println("total de lineas: "+(hilo1.contador+hilo2.contador+hilo3.contador))
    println("Fin del programa ")

}