/*
El gran libro de Kotlin
(para programadores de back end)

Editor: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)
 */

package marcombo.lcriadof.capitulo5

fun main(){
    // programa c5p7.kt, función generica
    fun <T>escribe(entrada:T):Unit{   // 1
        println(entrada)
    }
    escribe(56)  //2
    escribe (5f) //3
    escribe ("Lo más incomprensible del universo es que es comprensible") //4
    escribe(true)  //5
}