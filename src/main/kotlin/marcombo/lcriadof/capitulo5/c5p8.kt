/*
El gran libro de Kotlin
(para programadores de back end)

Editor: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)
 */

package marcombo.lcriadof.capitulo5

fun main(){
    // programa c5p8.kt, función infix extendida de Int
    infix fun Int.multiplicado(x: Int): Int { return this*x}  //1
    println(7 multiplicado 2)  // 2
    println(7.multiplicado(2)) // 3
}