/*
El gran libro de Kotlin
(para programadores de back end)

Editor: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)
 */

package marcombo.lcriadof.capitulo6

// c6p11.kt: clases anidadas con Inner
class OuterSeries2 {
    private val elementos: Int = 15

    inner class InnerFibonacci2 { // 3
        fun serie():String{
            val n = elementos // 4
            var t1 = 0; var t2 = 1; var sum=0
            var salida:String=""
            for (i in 1..n-1) {
                salida=salida+"$t1, "
                sum = t1 + t2
                t1 = t2
                t2 = sum
            }
            return salida
        }
    } // fin de clase anidada interna
} // fin de clase contenedora

fun main(){
    val outer = OuterSeries2() // 1
    println("Usando instancia del contenedor: ${outer.InnerFibonacci2().serie()}") // 2

    val inner = OuterSeries2().InnerFibonacci2() // 3
    println("Usando instancia clase interior: ${inner.serie()}") // 4
}

