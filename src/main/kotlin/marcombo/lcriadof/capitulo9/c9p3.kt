/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 9: NÚMEROS.
 */

package marcombo.lcriadof.capitulo9

class det(val grado:Int) {
    fun resolver( x: Array<IntArray>):Int{
       var solucion:Int=0
        if (grado==2) {
            solucion=resolverOrden2(x)
        } else {
            if (grado==3){
                solucion=resolverOrden3(x)
            } else{
                println("No se puede resolver este determinante")
            }
        }
        return solucion
    }

    private fun resolverOrden2( x: Array<IntArray>):Int{
        return (x[0][0]*x[1][1])-(x[1][0]*x[0][1])    }

    private fun resolverOrden3( x: Array<IntArray>):Int{ // regla de Sarrus para resolver 3x3
        val partePositiva:Int=(x[0][0]*x[1][1]*x[2][2])+  // 1
                            (x[1][0]*x[2][1]*x[0][2])+
                            (x[2][0]*(x[0][1]*x[1][2]))

        val parteNegativa:Int=((-1)*x[2][0]*x[1][1]*x[0][2])-  // 2
                (x[1][0]*x[0][1]*x[2][2])-
                (x[0][0]*x[2][1]*x[1][2])

        return partePositiva+parteNegativa

    }
} // fin clase determinante

fun main(){

    var A: Array<IntArray> = arrayOf(
                    intArrayOf(1, 4, -1),
                    intArrayOf(-1, 3, 2),
                    intArrayOf(2, 2, 0) )

    var detA=det(grado=3)
    println("solución det A "+detA.resolver(A) )


    var B: Array<IntArray> = arrayOf(
        intArrayOf(3, -2, 5),
        intArrayOf(4, -3, 1),
        intArrayOf(-4, 2, 6) )
    var detB=det(grado=3)
    println("solución det B "+detB.resolver(B) )

}