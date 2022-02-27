/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 9: NÚMEROS.
 */

package marcombo.lcriadof.capitulo9
// codigo inspirado en Gunhan Sancar
// https://gist.github.com/gunhansancar/d01e572e297444217a3ae5ae6a3c9a4c

import java.time.Duration
import java.time.Instant

object SumarFibonacci {
    tailrec fun recursivo(n: Double, a: Double, b: Double): Double
            = if (n < 1.0) a else recursivo(n - 1.0, b, a + b)

    fun iterativo(n: Double):Double {  /// mal
        var f0: Double = 0.0
        var f1: Double = 1.0
        //println("elemento 0 es $f0")
        //println("elemento 1 es $f1")
        var resultado: Double = 0.0
        for (i in 1..n.toInt()-1) {
            resultado = f0 + f1
            f0 = f1
            f1 = resultado
            // println("elemento "+(i+1)+" es $resultado")
        }
        return resultado
    }
}

fun main(args: Array<String>) {
    println("Fibonacci comparativa (iterativo y recursividad), intoduzca el elemento de la sucesión a calcular: ")
    val n:Double = readLine()?.toDouble() as Double



    var inicio = Instant.now()
    println("comienzo: "+inicio)
    println(SumarFibonacci.iterativo(n))
    var fin = Instant.now()
    println("fin: "+fin)
    var tiempoEmpleado = Duration.between(inicio, fin).toMillis()
    println("tiempo empleado: "+tiempoEmpleado+" milisegundos")
println ("\n\n")

    inicio = Instant.now()
    println("comienzo: "+inicio)
    println(SumarFibonacci.recursivo(n, 0.0,1.0))
    fin = Instant.now()
    println("fin: "+fin)
    tiempoEmpleado = Duration.between(inicio, fin).toMillis()
    println("tiempo empleado: "+tiempoEmpleado+" milisegundos")
    println ("\n\n")


}
