package marcombo.lcriadof.capitulo11
/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 11: CONCURRENCIA
 */


import java.io.File
import java.time.Duration
import java.time.Instant
import java.util.*
import java.util.concurrent.SynchronousQueue
import kotlin.concurrent.thread

fun main(){
    var first = true
    var titulo=""
    var cromosoma=0;
    var d_adenina=0.0;var d_guanina=0.0; var d_citosina=0.0;var d_timina=0.0
    var adenina=0.0;var guanina=0.0; var citosina=0.0;var timina=0.0



    val colaNucleotidos = SynchronousQueue<String>()  // [1]

    val productorNucleotidos = thread(start = false) { // [2]
        File("/tmp/chm13v2.0.fa/chm13v2.0.fa").forEachLine { line -> // [3]

            if (line[0] == '>') { // [4]
                if (cromosoma>0){
                    println(" -> adenina: $adenina, guanina: $guanina, citosina: $citosina, timina: $timina")
                    d_adenina=d_adenina+adenina
                    d_guanina=d_guanina+guanina
                    d_citosina=d_citosina+citosina
                    d_timina=d_timina+timina
                    adenina=0.0; guanina=0.0; citosina=0.0; timina=0.0
                }

                if (!first)
                    println()

                titulo=line.substring(1)
                println("${line.substring(1)}: ")



                if (first) first = false

                cromosoma++
            }else{  colaNucleotidos.put(line)  }  // [5]

        } // fin de forEachLine
        colaNucleotidos.put("fin")  // [6]  señal de finalización para un hilo consumidor
    }


    class consumidorNucleotidos() : Thread() { // [6]
        // bloque [7]
        val nucleotidoA:hiloNucleotido=hiloNucleotido('A')
        val nucleotidoG:hiloNucleotido=hiloNucleotido('G')
        val nucleotidoT:hiloNucleotido=hiloNucleotido('T')
        val nucleotidoC:hiloNucleotido=hiloNucleotido('C')
        // fin del bloque [7]

        override fun run() {  // [8]
            // bloque [9]
            var consumirLinea:String=""
            var hijosTerminaron=0
            nucleotidoA.start()
            nucleotidoG.start()
            nucleotidoT.start()
            nucleotidoC.start()
            // fin del bloque [9]

            while (true) { // [10]
                // bloque [11]
                if (!consumirLinea.equals("fin")){
                    consumirLinea = colaNucleotidos.take().toString().trim() // [12]
                } else if ( (consumirLinea.equals("fin") && hijosTerminaron==0) ){
                   break
                }
                // fin del bloque [11]

                if (checkNoSpaces(consumirLinea)) { // [12]
                    hijosTerminaron=1
                    adenina=adenina+nucleotidoA.getNucleotidosContados(consumirLinea)
                    guanina=guanina+nucleotidoG.getNucleotidosContados(consumirLinea)
                    citosina=citosina+nucleotidoC.getNucleotidosContados(consumirLinea)
                    timina=timina+nucleotidoT.getNucleotidosContados(consumirLinea)
                    hijosTerminaron=0
                }
             }

             println("${Thread.currentThread().name}: terminado run()") // [13]
        }
    } // fin de clase consumidorNucleotidos





    var inicio = Instant.now()
    println("comienzo: "+inicio)

    productorNucleotidos.start()


    val hilo1=consumidorNucleotidos()
    hilo1.start()

    productorNucleotidos.join()
    hilo1.join()


    println("Fin del programa ")
    println("Totales -> d_adenina: $d_adenina, d_guanina: $d_guanina, d_citosina: $d_citosina, d_timina: $d_timina")
    var total=d_adenina+d_guanina+d_citosina+d_timina
    println("Totales de nucleotidos: "+total)


    var fin = Instant.now()
    println("fin: "+fin)
    var tiempoEmpleado = Duration.between(inicio, fin).toMillis()
    println("tiempo empleado: "+tiempoEmpleado+" milisegundos")
    println("tiempo empleado: "+tiempoEmpleado/1000+" segundos")



}