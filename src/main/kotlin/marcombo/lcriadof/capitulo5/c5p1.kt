/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 5: FUNCIONES
 */

package marcombo.lcriadof.capitulo5

fun main(){
  // programa c5p1.kt
    fun FraseDelDia():Unit{          //1
      val frase:String="Cada día es una nueva oportunidad para cambiar tu vida"
      val numLetras=frase.length
          println("La frase [$frase] tiene $numLetras letras")
    }
    FraseDelDia()               //2
    FraseDelDia()
}