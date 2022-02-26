/*
El gran libro de Kotlin
(para programadores de back end)

Editor: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)
 */

package marcombo.lcriadof.capitulo5

fun main() {
    val cubo:(Int) -> Int = { num:Int -> num*num*num } // 1
    val cubo2:(Int) -> Int = { num -> num*num*num }    // 2
    val cubo3 = { num:Int -> num*num*num }    // 3
//  val cubo4 = { num -> num*num*num  }                // 4
    println(cubo(3))
    println(cubo2(3))
    println(cubo3(3))
}






