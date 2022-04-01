/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 9: CADENAS Y PALABRAS.
 */
package marcombo.lcriadof.capitulo10

import java.io.File
import java.text.SimpleDateFormat
import java.util.*

fun main(){

    var cad2:Char='h'

    var cad1:String="hola mundo"
    println(cad1)
    var caracteres_especiales="\u221e \u00AB \u0394 \u215E"
    println(caracteres_especiales)

    val soneto = """
    último terceto del SONETO Si para recobrar lo recobrado
    AUTOR: Francisco Luis Bernárdez
        Porque después de todo he comprendido 
        Que lo que el árbol tiene de florido
        Vive de lo que tiene sepultado.
"""
    println(soneto)
    println(soneto.length)

    // eliminar sangría
    println(soneto.trimIndent())


    // conocer la longitud de un String
    var l:Int=cad1.length
    println(l)
    // Valor máximo de un Int
    println(Int.MAX_VALUE)



    // generamos un string de 21000 Kbytes
    val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
    var currentDate = sdf.format(Date())
    cad1=""
    var i=0
    try {
      for (i in 1..716800){
        cad1=cad1+"A"
      }
    }catch (e: Exception){
        println(e)
        println(i)
    }
    File("/tmp/string.txt").writeText(cad1)
    cad1=""
    File("/tmp/string.txt").forEachLine { cad1=cad1+it }
    var cad5:String=cad1+cad1+cad1+cad1+cad1+"***************"
    var cad10=cad5+cad5
    File("/tmp/string10.txt").writeText(cad10)
    println(cad10)

    var cad150=cad10+cad10+cad10
    File("/tmp/string150.txt").writeText(cad150)
    println(" tiempo: "+currentDate)
    currentDate = sdf.format(Date())
    println(" tiempo: "+currentDate)


}