/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 9: CADENAS Y PALABRAS.
 */
package marcombo.lcriadof.capitulo10

import java.text.SimpleDateFormat
import java.util.*

fun main(){

var cad1:String="hola mundo"
var cad2:Char='h'

    println("BITs de representación: ")
    println("Char,   "+Char.SIZE_BITS)

    println(cad1.length)
    var l:Int=0
    l=cad1.length

    println(Int.MAX_VALUE)


    val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
    val currentDate = sdf.format(Date())
    println(" C DATE is "+currentDate)

    cad1=""
    var i=0
    try {
      for (i in 1..Int.MAX_VALUE){
        cad1=cad1+"A"
        //println(cad1)
      }
    }catch (e: Exception){
        println(e)
        println(i)
    }


    println(cad1)

    println(" C DATE is "+currentDate)

}