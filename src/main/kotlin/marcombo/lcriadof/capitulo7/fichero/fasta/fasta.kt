package marcombo.lcriadof.capitulo7.fichero.fasta
/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 7: FICHEROS
 */

import java.util.Scanner
import java.io.File
import java.time.Duration
import java.time.Instant


// especificaciones del formato FASTA (.fa)
// https://es.wikipedia.org/wiki/Formato_FASTA

// código fuente extraido de https://rosettacode.org/wiki/FASTA_format#Kotlin
fun checkNoSpaces(s: String) = ' ' !in s && '\t' !in s

fun main(args: Array<String>) {
    var first = true
    val sc = Scanner(File("/tmp/chm13v2.0.fa/chm13v2.0.fa"))
    var lin_adenina=0.0;var lin_guanina=0.0; var lin_citosina=0.0;var lin_timina=0.0
    var titulo=""
    var cormosoma=0;
    var d_adenina=0.0;var d_guanina=0.0; var d_citosina=0.0;var d_timina=0.0
    var adenina=0.0;var guanina=0.0; var citosina=0.0;var timina=0.0

    var lineas=0.0

    var inicio = Instant.now() // marcamos el momento inicial
    println("comienzo: "+inicio)


    while (sc.hasNextLine()) {
        val line = sc.nextLine()

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
            lin_adenina=repeticiones(line,"a")+repeticiones(line,"A")+0.0
            adenina=adenina+lin_adenina
            lin_guanina=repeticiones(line,"g")+repeticiones(line,"G")+0.0
            guanina=guanina+lin_guanina
            lin_citosina=repeticiones(line,"c")+repeticiones(line,"C")+0.0
            citosina=citosina+lin_citosina
            lin_timina=repeticiones(line,"t")+repeticiones(line,"T")+0.0
            timina=timina+lin_timina
            lineas++

        }
        else {
            println("\nError : Sequence contains space(s)")
            break
        }

    }
    sc.close()

    // hay que sumar lo último pendiente
    d_adenina=d_adenina+adenina
    d_guanina=d_guanina+guanina
    d_citosina=d_citosina+citosina
    d_timina=d_timina+timina

    println("Lineas leidas de fichero: "+lineas)
    println("Totales -> d_adenina: $d_adenina, d_guanina: $d_guanina, d_citosina: $d_citosina, d_timina: $d_timina")
    var total=d_adenina+d_guanina+d_citosina+d_timina
    println("Totales de bases nitrogenadas: "+total)

    var fin = Instant.now() // marcamos el tiempo final
    println("fin: "+fin)
    var tiempoEmpleado = Duration.between(inicio, fin).toMillis()
    println("tiempo empleado: "+tiempoEmpleado+" milisegundos")
    println("tiempo empleado: "+tiempoEmpleado/1000+" segundos")

}


fun repeticiones(texto:String,encontrar:String):Int{
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


