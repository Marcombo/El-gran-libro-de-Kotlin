/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 5: FUNCIONES
 */

package marcombo.lcriadof.capitulo5

fun main(){
    // programa c5p3.kt
    fun cuadrado(x:Int):Int{          //1
        return x*x                    //2
    }
    println( cuadrado(2).toString() )            // 3
    println( cuadrado(3).toString() )            // 4
    println( cuadrado(cuadrado(2)).toString() )  // 5
}