package marcombo.lcriadof.capitulo11

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
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

fun main() {

    var first = true
    var titulo=""
    var cromosoma=0;
    var lineas=0.0
    var totalAGTC: Double =0.0
   // val canal = Channel<String>(UNLIMITED) // buffer del canal ilimitado
    val canal = Channel<String>(5000)
    val cerrojo = Mutex()



    var inicio = Instant.now()
    println("comienzo: "+inicio)



    runBlocking() {
        suspend fun contador_total(agtc:Double) {
            totalAGTC = totalAGTC + agtc

        }

        launch(Dispatchers.IO) { // productor requiere tiempo de lectura de fichero
            val sc = Scanner(File("/tmp/chm13v2.0.fa/chm13v2.0.fa"))

            while (sc.hasNextLine()) {
                val line = sc.nextLine()
                if (line[0] == '>') {

                    if (!first) println()
                    titulo=line.substring(1)

                    println("${line.substring(1)}: ")
                    if (first) first = false

                    cromosoma++
                }else{
                    canal.send(line)
                    lineas++
                 }
            } // fin de while
            canal.send("fin") // añadir por cada consumidor una línea igual
            canal.send("fin") // añadir por cada consumidor una línea igual

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
            // fin de definición de variables de trabajo interno
            delay(500) // esperamos 0.5 segundo para dar tiempo de llenar el canal
            while (true) {

                cerrojo.withLock{
                    cNucleotido = canal.receive()
                }

                if (!cNucleotido.equals("fin")) {
                    timinaT = timinaT+nucleotido('T', cNucleotido)
                    adeninaT = adeninaT+nucleotido('A', cNucleotido)
                    citosinaT = citosinaT+nucleotido('C', cNucleotido)
                    guaninaT = guaninaT+ nucleotido('G', cNucleotido)
                 } else {
                    break
                }
            }
            println("Totales -> adenina: $adeninaT, guanina: $guaninaT, citosina: $citosinaT, timina: $timinaT")
            contador_total(timinaT+adeninaT+citosinaT+guaninaT)
            println("[consumidor] fin")
        } // fin de consumidor


    } // ------------ fin de runBlocking

    canal.close() // hemos terminado de enviar
    println("Lineas leidas de fichero: "+lineas)
    println("Totales de bases nitrogenadas: "+totalAGTC)


    var fin = Instant.now()
    println("fin: "+fin)
    var tiempoEmpleado = Duration.between(inicio, fin).toMillis()
    println("tiempo empleado: "+tiempoEmpleado+" milisegundos")
    println("tiempo empleado: "+tiempoEmpleado/1000+" segundos")
    println("Fin del programa ")

} // fin de main

