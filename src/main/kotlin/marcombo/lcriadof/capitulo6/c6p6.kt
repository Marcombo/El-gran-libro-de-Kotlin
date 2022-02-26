/*
El gran libro de Kotlin
(para programadores de back end)

Editor: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)
 */

package marcombo.lcriadof.capitulo6

// c6p6.kt
enum class Numero(val ValorDeLaconstante: Double) { //1
    pi( 3.1416), // 2
    e(2.7182818284)  // 3
}

fun main() {
    val num_pi= Numero.pi //4
    val num_e= Numero.e
    println(num_pi.ValorDeLaconstante) //5
    println(num_e.ValorDeLaconstante)

    // area del circulo es pi*r^2
    var num: Int
    println("Radio del circulo: ")
    num = readLine()?.toInt() as Int // 6
    var areaCirculo=num*num*num_pi.ValorDeLaconstante // 7
    println("El area de un círculo con radio "+num+" es "+areaCirculo)
}