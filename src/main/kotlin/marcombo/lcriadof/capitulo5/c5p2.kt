/*
El gran libro de Kotlin
(para programadores de back end)

Editor: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)
 */

package marcombo.lcriadof.capitulo5

fun main(){
    // programa c5p2.kt
    fun FraseDelDia(frase:String):Unit{          //1
         val numLetras=frase.length
        println("La frase [$frase] tiene $numLetras letras")
    }
    FraseDelDia("Cada día es una nueva oportunidad para cambiar tu vida")               //2
    FraseDelDia("Pienso, luego existo")                                                 // 3
}