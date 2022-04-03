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
    var adenina=0;var guanina=0; var citosina=0;var timina=0
    while (sc.hasNextLine()) {
        val line = sc.nextLine()
        if (line[0] == '>') {
            if (!first) println()
            titulo=line.substring(1)

            println("${line.substring(1)}: \n")
            if (first) first = false
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
            print(line)  // cada línea tiene 80 caracteres
            println(" -> adenina: $adenina, guanina: $guanina, citosina: $citosina, timina: $timina")
        }
        else {
            println("\nError : Sequence contains space(s)")
            break
        }

        limitar++
        if (limitar>1000){
            break;
        }

    }
    sc.close()
    //println("\n"+titulo)
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


