package marcombo.lcriadof.capitulo11

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.UNLIMITED
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

//import kotlinx.coroutines.channels.Channel.Factory.UNLIMITED
import java.io.File
import java.time.Duration
import java.time.Instant
import java.util.*

/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 11: CONCURRENCIA
 */


// con dos corrutina usando un buffer en combinacion con un cerrojo y una pila, logro unos 36 segundos

fun main() {

    var first = true
    var titulo=""
    var cromosoma=0;
    var totalAGTC: Double =0.0


    //val canal = Channel<String>(UNLIMITED) // buffer del canal ilimitado

    val sizestackFIFO=5000  // tamaño de las pilas
    val sizeCanal=10000  // tamaño del canal






    val canal = Channel<String>(sizeCanal)
    val cerrojo = Mutex()



    var inicio = Instant.now()
    println("comienzo: "+inicio)



    runBlocking() {
        suspend fun contador_total(agtc:Double) {
            totalAGTC = totalAGTC + agtc

        }

        launch(Dispatchers.IO) { // productor requiere tiempo de lectura de fichero
            val sc = Scanner(File("/tmp/chm13v2.0.fa/chm13v2.0.fa"))
            var lineas=0.0
            cerrojo.lock()
            var bandera=true
            while (sc.hasNextLine()) {
                val line = sc.nextLine()
                if (line[0] == '>') {

                    if (!first) println()
                    titulo=line.substring(1)

                    println("${line.substring(1)}: ")
                    if (first) first = false
                    cromosoma++
                }else{

                    lineas++
                    if (bandera){ // [1]
                        if (lineas>sizeCanal.toDouble()){
                            cerrojo.unlock()
                            bandera=false // esto es solo para tener el canal con suficiente buffer antes del consumo
                            println("cerrojo abierto, ya pueden empezar los consumidores")
                        }
                    }

                    canal.send(line)


                }
            } // fin de while
            println("Lineasleidas de fichero: "+lineas)
            canal.send("fin") // añadir por cada consumidor una línea igual
          //  canal.send("fin") // añadir por cada consumidor una línea igual
          //  canal.send("fin") // añadir por cada consumidor una línea igual
          //  canal.send("fin") // añadir por cada consumidor una línea igual
          //  canal.send("fin") // añadir por cada consumidor una línea igual

            sc.close()
            println("[productor] fin ")
        } // fin de productor




        launch(Dispatchers.Default) { // consumidor requiera proceso de CPU
            // variables de trabajo interno
            var cNucleotido=""
            var timinaT=0.0
            var adeninaT=0.0
            var citosinaT=0.0
            var guaninaT=0.0

            var stackFIFO: MutableList<String> = mutableListOf()  // [1]
            var ciclo:Boolean=true
            // fin de definición de variables de trabajo interno

            delay(1000) // [2]
            println("consumidor listo para recibir")

            while (ciclo) {  // [3]

                // bloque [a] recepción de datos
                if (stackFIFO.size==0){ // [4]
                    cerrojo.withLock{ // [5]
                        for (i in 1..sizestackFIFO) {  // [6]
                            if (!canal.isEmpty){ // [7]
                                cNucleotido=canal.receive() // [8]
                                stackFIFO.add(cNucleotido) // [9]
                                if (cNucleotido.equals("fin")){  // [10]
                                    break
                                }
                            } else{ // [10b]
                                break
                            }
                        }
                    }
                }

                // bloque [b] consumo de la pila en modo FIFO
                if (stackFIFO.size>0){ // [11]
                    cNucleotido=stackFIFO.first() // [12]
                    stackFIFO.removeAt(0) // [13]

                    if (!cNucleotido.equals("fin")) { // [14]
                        timinaT = timinaT+nucleotido('T', cNucleotido)
                        adeninaT = adeninaT+nucleotido('A', cNucleotido)
                        citosinaT = citosinaT+ nucleotido('C', cNucleotido)
                        guaninaT = guaninaT+nucleotido('G', cNucleotido)
                    } else { // [15]
                        println("[consumidor] intentando salir")
                        ciclo=false
                        break
                    }
                }

            }
            contador_total(timinaT+adeninaT+citosinaT+guaninaT) // [16]
            println("[consumidor] fin")
        } // fin de consumidor



    } // ------------ fin de runBlocking





    canal.close() // hemos terminado de enviar

    println("Fin del programa ")
    println("Totales de bases nitrogenadas: "+totalAGTC)


    var fin = Instant.now()
    println("fin: "+fin)
    var tiempoEmpleado = Duration.between(inicio, fin).toMillis()
    println("tiempo empleado: "+tiempoEmpleado+" milisegundos")
    println("tiempo empleado: "+tiempoEmpleado/1000+" segundos")

} // fin de main

