/*
El gran libro de Kotlin
(para programadores de back end)

Editor: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)
 */

package marcombo.lcriadof.capitulo5

fun main(){
    // programa c5p6b.kt, función varargs
    fun inverso(vararg numerosEntrada:Double):Array<Double>{   // 1
        // println(numerosEntrada.size) // número de parámetros
        var  vectorSalida = Array<Double>(numerosEntrada.size,{i->0.0}) // 2
        var j=0
        for (i in numerosEntrada){ // 3
            vectorSalida[j]=1/i    // 4
            j++ // 5
        }
        return vectorSalida
    }

    println( "El inverso es "+inverso(2.0).joinToString() )
    println( "Los inversos son "+inverso(1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0).joinToString() )
}