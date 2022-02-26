/*
El gran libro de Kotlin
(para programadores de back end)

Editor: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)
 */

package marcombo.lcriadof.capitulo5

fun main(){
    // programa c5p6.kt, función varargs
    fun suma(vararg numerosEntrada:Int):Int{   // 1
        var acumunlador:Int=0                  // 2
        for (i in numerosEntrada){             // 3
            acumunlador= i + acumunlador       // 4
        }
        return acumunlador
    }

    println( "La suma es "+suma(2,4,6,20) )   // 5
}