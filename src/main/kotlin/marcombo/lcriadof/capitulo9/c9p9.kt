/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 9: NÚMEROS.
 */

package marcombo.lcriadof.capitulo9

import java.lang.Math.sqrt
import java.time.Duration
import java.time.Instant


infix fun Double.fmod(other: Double): Number {  // autor Marcin Koziński
    return ((this % other) + other) % other     // https://stackoverflow.com/questions/38052008/how-to-implement-floor-modulo-for-every-number-type-in-kotlin
}


class primo {

    fun fuerzaBruta(num:Double):Boolean{
         return divisorPorTentativa(num)  // 1
    }
    fun raizCuadrada(num:Double):Boolean{
        return divisorPorTentativa(num,true)  // 2
    }

    private fun divisorPorTentativa(numero:Double,raizCuadrada:Boolean=false):Boolean{ // 3
        var num:Double=sqrt(numero) // 4
        var primo:Boolean=true  // 5
        var rango=(3..(numero-1).toInt()).step(2) // 6;   me quedo solo con los impares
        var modulo:Double=0.0 // 7

        // si es raiz cuadrada limitamos el rango
        if (raizCuadrada){ // 8
            rango=(3..(num-1).toInt()).step(2)
        }

        // comprobamos si tiene divisibilidad par
        modulo = (numero fmod 2.0) as Double  // 9;   calculamos el módulo
        if (modulo == 0.0) {  // 10
            primo = false
         } else {
          // comprobamos si es divisible por algún impar
            for (i in rango) {
                modulo = (numero fmod i.toDouble()) as Double  // 11
                if (modulo == 0.0) {
                    primo = false
                    break // 12
                }
            } // fin de for
        }
       return primo
    } // fin de divisorPorTentativa

} // fin de clase



fun main() {
    val p = primo()
    println("Introduzca un numero para verificar si es primo: ")
    // 1409305684859.0; 1996277.0p; 1159523.0p; 2314729095871.0; 25413798.0
    val n:Double = readLine()?.toDouble() as Double

    // fuerza bruta
    var inicio = Instant.now()
    println("comienzo: "+inicio)
    println( "¿Es primo el número $n:? "+p.fuerzaBruta(n) )
    var fin = Instant.now()
    println("fin: "+fin)
    var tiempoEmpleado = Duration.between(inicio, fin).toMillis()
    println("tiempo empleado: "+tiempoEmpleado+" milisegundos")
    println ("\n\n")


    // raiz cuadrada
    inicio = Instant.now()
    println("comienzo: "+inicio)
    println("raiz cuadrada de $n es "+sqrt(n))
    println( "¿Es primo el número $n?: "+p.raizCuadrada(n) )
    fin = Instant.now()
    println("fin: "+fin)
    tiempoEmpleado = Duration.between(inicio, fin).toMillis()
    println("tiempo empleado: "+tiempoEmpleado+" milisegundos")
    println ("\n\n")

}