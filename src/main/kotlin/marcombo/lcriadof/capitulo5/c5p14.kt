/*
El gran libro de Kotlin
(para programadores de back end)

Editor: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)
 */

package marcombo.lcriadof.capitulo5

fun operacion(entrada1: Int, entrada2: Int, f: (Int, Int) -> Int) : Int { // 1
    return f(entrada1, entrada2) //2
}

fun suma(sumando1: Int, sumando2: Int) = sumando1 + sumando2 // 3
fun resta(minuendo: Int, sustraendo: Int) = minuendo - sustraendo // 4


fun main() {
    var num1:Int=10
    var num2:Int=3

    var resultado = operacion(num1, num2, ::suma) // 5
       println(""+num1+" + "+num2+" = "+resultado)  // 6
    resultado = operacion(num1, num2, ::resta)
       println(""+num1+" - "+num2+" = "+resultado)

    // otra forma de hacerlo
    num1=23
    num2=7
    println(""+num1+" - "+num2+" = ${operacion(num1, num2, ::resta)}") // 7

}