/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 5: FUNCIONES
 */

package marcombo.lcriadof.capitulo5

// c5p13.kt  algunos ejemplos de funciones lambda
fun main() {
    val sum = {a: Int , b: Int -> a + b}   //1
    val sumProgAritmetica = {a1:Int, an: Int , n: Int -> (a1+an)*(n/2)}  //2
    val siguienteProgAritmetica = {aj:Int, ak: Int -> (ak-aj)+(ak)}   //3
    println(sum(3,4))                       //4
    println(sumProgAritmetica(1,100,100))   //5
    println(siguienteProgAritmetica(7,21))  // 6
}

