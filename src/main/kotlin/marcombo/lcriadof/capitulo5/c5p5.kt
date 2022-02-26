/*
El gran libro de Kotlin
(para programadores de back end)

Editor: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)
 */

package marcombo.lcriadof.capitulo5

fun main(){
    // programa c5p5.kt, función con parámetro por defecto
    fun cuadrado(x:Int=2):Int{   // 1
        return x*x
    }
    var num:Int=9
    var calculo:Int
    println( "el cuadrado de "+num+" es "+cuadrado(num) )
    println( "el cuadrado del valor por defecto es "+cuadrado() )
}