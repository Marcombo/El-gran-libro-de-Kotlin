/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 9: NÚMEROS.
 */

package marcombo.lcriadof.capitulo9

import java.text.DecimalFormat
import kotlin.math.absoluteValue

//Método Gauss-Seidel
//     iterativo
class gaussSeidel(val A: Array<DoubleArray>, var b: Array<DoubleArray>, var xinicial: Array<DoubleArray>, val eps:Double)  {


    var epsilon = Array(xinicial.size) { DoubleArray(xinicial.size) }
    var xinicialBak = Array(xinicial.size) { DoubleArray(xinicial.size) }
    init{
        inicializar()
    }

    private fun inicializar() {
        for (c in xinicial.indices) {
                xinicialBak[c][0] = xinicial[c][0]
                epsilon[c][0] = 10.0
        }
    }

    private fun convergencia(n:Int):Double {
        epsilon[n][0]=(xinicial[n][0]-xinicialBak[n][0] )/xinicial[n][0]
      return epsilon[n][0]
    }


    private fun incognita(numx:Int):Double { // 1
        var resultX:Double=0.0
        var t:Double=0.0 // 2

        var f:Int=numx // 3
            for (c in A.indices) {
               if (f!=c){ // 4
                   t=t+(A[f][c]*xinicial[c][0]) // 5
                   //println( "A[$f][$c]= "+A[f][c])
                   //println("xinicial[$c][0]= "+xinicial[c][0])
               }

            }
        resultX=(b[f][0]-t)/A[f][f] // 6
        //println("divido entre A[$f][$f] "+A[f][f])

        xinicialBak[f][0] = xinicial[f][0] // 7
        xinicial[f][0]=resultX // 8
        return resultX
    } // fin de método incognita


    fun resolver():Int {
       val patron = DecimalFormat("##.##")
       var valorIncognita=0.0

       var iteracion=1
       while (epsilon[0][0].absoluteValue>eps){
           println("Iteración: "+iteracion)
           for (i in A.indices){
               valorIncognita=incognita(i)
               println("x$i: "+patron.format(valorIncognita))
               println("valor sin redondear: $valorIncognita,  epsilon: "+convergencia(i))
           }
           println("******************************************")
           iteracion++
       }
       iteracion--
       return iteracion
    }

}

fun main(){
    var A: Array<DoubleArray> = arrayOf(
            doubleArrayOf(3.0, -0.1,  -0.2),
            doubleArrayOf(0.1, 7.0,  -0.3),
            doubleArrayOf(0.3, -0.2, 10.0) )

    var b: Array<DoubleArray> = arrayOf(
            doubleArrayOf(7.85),
            doubleArrayOf(-19.3),
            doubleArrayOf(71.4))

    var x: Array<DoubleArray> = arrayOf(
            doubleArrayOf(0.0),
            doubleArrayOf(0.0),
            doubleArrayOf(0.0))


    var gs=gaussSeidel(A,b,x,eps=0.1)
    println( "\n\nIteraciones utilizadas: "+gs.resolver() )



    // experimento 2
    A = arrayOf(
            doubleArrayOf(3.0, -1.0,  -1.0),
            doubleArrayOf(-1.0, 3.0,  1.0),
            doubleArrayOf(2.0, 1.0, 4.0) )

    b = arrayOf(
            doubleArrayOf(1.0),
            doubleArrayOf(3.0),
            doubleArrayOf(7.0))
    x = arrayOf(
    doubleArrayOf(0.0),
    doubleArrayOf(0.0),
    doubleArrayOf(0.0))

    var gs2=gaussSeidel(A,b,x,eps=0.001)
    println( "\n\nIteraciones utilizadas: "+gs2.resolver() )



    // experimento 3, no es convergente
    A = arrayOf(
            doubleArrayOf(-6.0, 4.0, -15.0),
            doubleArrayOf(10.0, 5.0,  -3.0),
            doubleArrayOf(2.0, 13.0, -7.0) )

    b = arrayOf(
            doubleArrayOf(10.0),
            doubleArrayOf(20.0),
            doubleArrayOf(50.0))
    x = arrayOf(
            doubleArrayOf(0.0),
            doubleArrayOf(0.0),
            doubleArrayOf(0.0))

    var gs3=gaussSeidel(A,b,x,eps=0.001)
    println( "\n\nIteraciones utilizadas: "+gs3.resolver() )

// lo anterior no convergia pero si ordenamos......
    // experimento 4, ahora es convergente

    A = arrayOf(doubleArrayOf(10.0, 5.0,  -3.0),
            doubleArrayOf(2.0, 13.0, -7.0),
            doubleArrayOf(-6.0, 4.0, -15.0) )

    b = arrayOf(
            doubleArrayOf(20.0),
            doubleArrayOf(50.0),
            doubleArrayOf(10.0))
    x = arrayOf(
            doubleArrayOf(0.0),
            doubleArrayOf(0.0),
            doubleArrayOf(0.0))
    var gs4=gaussSeidel(A,b,x,eps=0.01)
    println( "\n\nIteraciones utilizadas: "+gs4.resolver() )



    // experimento 5
    var A2: Array<DoubleArray> = arrayOf(
            doubleArrayOf(4.0, -1.0, -1.0, 1.0),
            doubleArrayOf(1.0, 5.0, 1.0, -1.0),
            doubleArrayOf(-1.0, 1.0, 10.0, -4.0),
            doubleArrayOf(1.0, -2.0, 8.0, 20.0) )

    var b2: Array<DoubleArray> = arrayOf(
            doubleArrayOf(3.0),
            doubleArrayOf(6.0),
            doubleArrayOf(6.0),
            doubleArrayOf(27.0))

    var x2: Array<DoubleArray> = arrayOf(
            doubleArrayOf(0.0),
            doubleArrayOf(0.0),
            doubleArrayOf(0.0),
            doubleArrayOf(0.0))

    println("Matriz de coeficientes (A)")
    A2.forEach { println(it.joinToString()) }  // ver como queda la matriz
    println("Vector de términos independientes (b)")
    b2.forEach { println(it.joinToString()) }  // ver como queda la matriz


    var gs5=gaussSeidel(A2,b2,x2,eps=0.1)
    println( "\n\nIteraciones utilizadas: "+gs5.resolver() )





}