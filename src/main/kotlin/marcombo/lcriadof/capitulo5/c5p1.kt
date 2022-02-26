/*
El gran libro de Kotlin
(para programadores de back end)

Editor: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)
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