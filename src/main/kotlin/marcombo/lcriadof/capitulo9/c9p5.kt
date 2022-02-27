/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 9: NÚMEROS.
 */

package marcombo.lcriadof.capitulo9


// regla de cramer
class cramer(val A: Array<IntArray>, var b: Array<IntArray>) { //1

    var detA:Int=0
    init{
        detA=Determinante.resolver(A) // 2
    }

    private fun getMatrizIncognita(numIncognita: Int):Array<IntArray> { //3
        val orden=A.size  // orden de la matriz de coeficientes
        var matrizIncognita: Array<IntArray> = Array(orden) { IntArray(orden) }  // inicializamos
        matrizIncognita=copy(A) // clonamos la matriz de coeficientes
        for (columna in b.indices) {
            matrizIncognita[columna][numIncognita] = b[columna][0]
        }
        return matrizIncognita
    }

    private fun copy(matriz: Array<IntArray>): Array<IntArray> { // 4
        val orden=A.size  // orden de la matriz de coeficientes
        var matriz: Array<IntArray> = Array(orden) { IntArray(orden) }  // inicializamos
        for (y in matriz.indices) {
            for (x in matriz.indices) {
                matriz[y][x] = A[y][x]
            }
        }
        return matriz
    }

    fun resolver(incognita: Int): Int = if (detA==0 ){ // 5
        println("El deteminante de los coeficientes es cero, luego no se puede resolver")
        0
    }
    else { Determinante.resolver(getMatrizIncognita(incognita))/detA } //6

}  // fin de la regla de cramer


fun main(){


    var A: Array<IntArray> = arrayOf(
            intArrayOf(1, -3),
            intArrayOf(1, 5) )

    var b: Array<IntArray> = arrayOf(
            intArrayOf(2),
            intArrayOf(10))

    var sistemaLineal=cramer(A,b)

    println( sistemaLineal.resolver(0) )
    println( sistemaLineal.resolver(1) )

    println()

     A = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(2, 1) )

     b = arrayOf(
            intArrayOf(1),
            intArrayOf(0))

    var sistemaLineal2=cramer(A,b)

    println( sistemaLineal2.resolver(0) )
    println( sistemaLineal2.resolver(1) )

    println()
    println()


    A = arrayOf(
            intArrayOf(1, 1, -1),
            intArrayOf(3, 1, -1),
            intArrayOf(4, -2, 1) )

    b= arrayOf(
            intArrayOf(0),
            intArrayOf(2),
            intArrayOf(3))

    var sistemaLineal3=cramer(A,b)

    println( sistemaLineal3.resolver(0) )
    println( sistemaLineal3.resolver(1) )
    println( sistemaLineal3.resolver(2) )
    println()



    var A3: Array<IntArray> = arrayOf(
            intArrayOf(4, -1, -1, 1),
            intArrayOf(1, 5, 1, -1),
            intArrayOf(-1, 1, 10, -4),
            intArrayOf(1, -2, 8, 20) )

    var b3: Array<IntArray> = arrayOf(
            intArrayOf(3),
            intArrayOf(6),
            intArrayOf(6),
            intArrayOf(27))
    var sistemaLineal4=cramer(A3,b3)

    println( sistemaLineal4.resolver(0) )
    println( sistemaLineal4.resolver(1) )
    println( sistemaLineal4.resolver(2) )
    println( sistemaLineal4.resolver(3) )
    println()

}