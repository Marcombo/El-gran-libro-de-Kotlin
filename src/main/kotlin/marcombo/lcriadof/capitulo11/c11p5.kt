package marcombo.lcriadof.capitulo11

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

// EJEMPLO de EMPEORAMIENTO DE RENDIMIENTO con hilos

fun checkNoSpaces(s: String) = ' ' !in s && '\t' !in s

fun main(){
    var first = true
    val sc = Scanner(File("/tmp/chm13v2.0.fa/chm13v2.0.fa"))
    var lin_adenina=0.0;var lin_guanina=0.0; var lin_citosina=0.0;var lin_timina=0.0
    var titulo=""
    var cormosoma=0;
    var d_adenina=0.0;var d_guanina=0.0; var d_citosina=0.0;var d_timina=0.0
    var adenina=0.0;var guanina=0.0; var citosina=0.0;var timina=0.0



    var line:String=""

    val nucleotidoA:hiloNucleotido=hiloNucleotido('A')
    val nucleotidoG:hiloNucleotido=hiloNucleotido('G')
    val nucleotidoT:hiloNucleotido=hiloNucleotido('T')
    val nucleotidoC:hiloNucleotido=hiloNucleotido('C')

    nucleotidoA.start()
    nucleotidoG.start()
    nucleotidoT.start()
    nucleotidoC.start()

    var inicio = Instant.now() // [1]
    println("comienzo: "+inicio)


    while (sc.hasNextLine()) {
        line = sc.nextLine()

        if (line[0] == '>') {
            if (cormosoma>0){
                println(" -> adenina: $adenina, guanina: $guanina, citosina: $citosina, timina: $timina")
                d_adenina=d_adenina+adenina
                d_guanina=d_guanina+guanina
                d_citosina=d_citosina+citosina
                d_timina=d_timina+timina
                adenina=0.0; guanina=0.0; citosina=0.0; timina=0.0
            }

            if (!first) println()
            titulo=line.substring(1)

            println("${line.substring(1)}: ")
            if (first) first = false

            cormosoma++
        }

        else if (first) {
            println("Error : File does not begin with '>'")
            break
        }
        else if (checkNoSpaces(line)){

            adenina=adenina+nucleotidoA.getNucleotidosContados(line)
            guanina=guanina+nucleotidoG.getNucleotidosContados(line)
            citosina=citosina+nucleotidoC.getNucleotidosContados(line)
            timina=timina+nucleotidoT.getNucleotidosContados(line)


        }
        else {
            println("\nError : Sequence contains space(s)")
            break
        }

    }
    sc.close()
    nucleotidoA.join()
    nucleotidoG.join()
    nucleotidoC.join()
    nucleotidoT.join()
    d_adenina=d_adenina+adenina
    d_guanina=d_guanina+guanina
    d_citosina=d_citosina+citosina
    d_timina=d_timina+timina


    println("Totales -> d_adenina: $d_adenina, d_guanina: $d_guanina, d_citosina: $d_citosina, d_timina: $d_timina")
    var total=d_adenina+d_guanina+d_citosina+d_timina
    println("Totales de nucleotidos: "+total)

    var fin = Instant.now() // [2]
    println("fin: "+fin)
    var tiempoEmpleado = Duration.between(inicio, fin).toMillis()
    println("tiempo empleado: "+tiempoEmpleado+" milisegundos")
    println("tiempo empleado: "+tiempoEmpleado/1000+" segundos")



}




 class hiloNucleotido(var tipo:Char) : Thread() {
        var contador=0.0

        fun getNucleotidosContados(lin:String):Double{
            contador = repeticiones(lin,tipo.uppercase().toString() ) + repeticiones(lin, tipo.lowercase().toString() ) + 0.0
            return contador
        }

        @Synchronized // ejemplo de no hace cuando no hace falta
        private fun repeticiones(texto:String,encontrar:String):Int{
            var contador=0
            var posicion=0
            var ciclo=0
            posicion=texto.indexOf(encontrar,ciclo)
            while (posicion>-1){
                if (posicion>-1){ // posición encontrada
                    ciclo=posicion
                    contador++
                }
                ciclo++
                posicion=texto.indexOf(encontrar,ciclo)
            }
            return contador
        }

 }





