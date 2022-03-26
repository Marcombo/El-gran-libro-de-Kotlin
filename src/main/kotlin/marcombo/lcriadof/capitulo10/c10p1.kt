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




    println("BITs de representación de un Char: "+Char.SIZE_BITS)

    // conocer la longitud de un String
    var l:Int=cad1.length
    println(l)

    // Valor máximo de un Int
    println(Int.MAX_VALUE)

    // comprobamos por fuerza bruta que tamaño puede almacenar un String
    //     este código está comentado pues requiere mucho tiempo para
    //     comprobar el numero máximo de caracteres que puede contener
    //     un String
    /*
    val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
    val currentDate = sdf.format(Date())
    println("Inicio del proceso: "+currentDate)
    cad1=""
    var i=0
    try {
      for (i in 1..Int.MAX_VALUE){
        cad1=cad1+"A"
      }
    }catch (e: Exception){
        println(e)
        println(i)
    }

    println(cad1)
    println("Fin del proceso: "+currentDate)
    */




}