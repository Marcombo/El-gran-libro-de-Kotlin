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


// especificaciones del formato FASTA (.fa)
// https://es.wikipedia.org/wiki/Formato_FASTA

// código fuente extraido de https://rosettacode.org/wiki/FASTA_format#Kotlin
fun checkNoSpaces(s: String) = ' ' !in s && '\t' !in s

fun main(args: Array<String>) {
    var first = true
    val sc = Scanner(File("/tmp/chm13v2.0.fa/chm13v2.0.fa"))
    var limitar=0
    var titulo=""
    var cormosoma=0;
    var d_adenina=0.0;var d_guanina=0.0; var d_citosina=0.0;var d_timina=0.0
    var adenina=0.0;var guanina=0.0; var citosina=0.0;var timina=0.0
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

            println("${line.substring(1)}: \n")
            if (first) first = false


            cormosoma++
        }

        else if (first) {
            println("Error : File does not begin with '>'")
            break
        }
        else if (checkNoSpaces(line)){
            adenina=adenina+repeticiones(line,"a")
            guanina=guanina+repeticiones(line,"g")
            citosina=citosina+repeticiones(line,"c")
            timina=timina+repeticiones(line,"t")
           // print(line)  // cada línea tiene 80 caracteres

        }
        else {
            println("\nError : Sequence contains space(s)")
            break
        }
/*
        limitar++
        if (limitar>100000){
            break;
        }


 */
    }
    sc.close()
    println("Totales -> d_adenina: $d_adenina, d_guanina: $d_guanina, d_citosina: $d_citosina, d_timina: $d_timina")
    var total=d_adenina+d_guanina+d_citosina+d_timina
    println("Totales de nucleotidos: "+total)


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


