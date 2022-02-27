/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 9: NÚMEROS.
 */

package marcombo.lcriadof.capitulo9


object Determinante {

    fun verMatriz(matriz: Array<IntArray>) {
        println("Orden: "+matriz.size)
        matriz.forEach { println(it.joinToString()) }
    }
    private fun adjunto(matriz: Array<IntArray>, fila: Int, columna: Int): Int { // 0
        val orden=matriz.size - 1  // 1
        var detAdjunto: Array<IntArray> = Array(orden) { IntArray(orden) }  // 2
        var coordX = 0; var coordY = 0  //  3

        for (x in matriz.indices) {  // 4
            for (y in matriz.indices) {  // 5
                if (x!=fila && y!=columna) {  // 6
                    detAdjunto[coordX][coordY] = matriz[x][y]
                    coordY++
                    if (coordY >= orden) {
                        coordX++
                        coordY = 0
                    }
                }
            }  // fin del bucle de las Y
        } // fin del bucle de las X
        //detAdjunto.forEach { println(it.joinToString()) }

        return Math.pow(-1.0, (fila + columna).toDouble()).toInt() * resolver(detAdjunto) // 7
    } // fin de método adjunto

    fun resolver(matriz: Array<IntArray>): Int {
        var det = 0

        if (matriz.size == 2) { // 8
            return (matriz[0][0]*matriz[1][1])-(matriz[1][0]*matriz[0][1])
        }  else {
            for (j in matriz.indices) {
                det = det + matriz[0][j] * adjunto(matriz, 0, j) // 9
            }
        }
        return det
    }
} // fin del objeto Determinante

fun main() {

    var A: Array<IntArray> = arrayOf(
            intArrayOf(1, 4, -1),
            intArrayOf(-1, 3, 2),
            intArrayOf(2, 2, 0) )
    Determinante.verMatriz(A)
    println("El determinante es: "+Determinante.resolver(A))
    println("-------------")

    var B: Array<IntArray> = arrayOf(
            intArrayOf(3, -2, 5),
            intArrayOf(4, -3, 1),
            intArrayOf(-4, 2, 6) )
    Determinante.verMatriz(B)
    println("El determinante es: "+Determinante.resolver(B))
    println("-------------")


    // Se define el determinante de orden 4
    var matriz: Array<IntArray> = arrayOf(
            intArrayOf(1, -1, 2, 3),
            intArrayOf(2, 1, 0, 1),
            intArrayOf(3, -1, 1, 2),
            intArrayOf(2, -1, 0, 1) )
    Determinante.verMatriz(matriz)
    println("El determinante es: "+Determinante.resolver(matriz))
}