/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 9: NÚMEROS.
 */

package marcombo.lcriadof.capitulo9
// ejemplo tomado de http://chuwiki.chuidiang.org/index.php?title=Integral_de_Riemann
// y transformado a kotlin

interface InterfaceFuncion {
    fun getY(x: Double): Double
}
object Riemann {
     fun calculaIntegral(funcion: InterfaceFuncion, a: Double, b: Double, n: Int): Double {
        var resultado:Double = 0.0
        val incremento = (b - a) / n           //3
        var x = a
        for (i in 0 until n) {
            resultado += incremento * funcion.getY(x)  // 4
            x += incremento // 5
        }
        return resultado
    }
}

fun main() {
    val f: InterfaceFuncion = object : InterfaceFuncion {  // 1
        override fun getY(x: Double): Double {  // 2
            return x * x * x  // 3
        }
    }

    // while //incrementamos en ordenes de magnitud de 10 hasta que la diferencia entre la ultima y la siguiente sea muy pequeño, por ejemplo 0,001

    println(Riemann.calculaIntegral(f, 0.0, 3.0, 3))
    println(Riemann.calculaIntegral(f, 0.0, 3.0, 10))
    println(Riemann.calculaIntegral(f, 0.0, 3.0, 100))
    println(Riemann.calculaIntegral(f, 0.0, 3.0, 1000))
    println(Riemann.calculaIntegral(f, 0.0, 3.0, 10000))
    println(Riemann.calculaIntegral(f, 0.0, 3.0, 100000))

}