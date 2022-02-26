/*
El gran libro de Kotlin
(para programadores de back end)

Editor: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)
 */

package marcombo.lcriadof.capitulo6

// c6p11.kt: clases anidadas con Nested


class OuterSeries { // 1
    private val elementos: Int = 15 // 2

    class InnerFibonacci { // 3
        fun serie():String{ // 4
            val n = 10 // 5
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
    } // fin de clase anidada

    class InnerCuadrado { // 3
        fun serie():String{ // 4
            val n = 10 // 5
            var t1 = 1
            var salida:String=""
            for (i in 1..n-1) {
                 t1 = (i*i)
                salida=salida+"$t1, "
            }
            return salida
        }
    } // fin de clase anidada

} // fin de clase contenedora



fun main(){
    val objeto1 = OuterSeries.InnerFibonacci().serie()
      println(objeto1)
    val objeto2 = OuterSeries.InnerCuadrado().serie()
    println(objeto2)

    // las siguientes definiciones no funcionan pues requieren
    // el modificado   inner en la clase  InnerFibonacci
//    val outer = OuterSeries()
//    println("Usando el objeto exterior: ${outer.InnerFibonacci().serie(15)}")

//    val inner = OuterSeries().InnerFibonacci()
//    println("Usando el objeto interior: ${inner.serie(15)}")


}

