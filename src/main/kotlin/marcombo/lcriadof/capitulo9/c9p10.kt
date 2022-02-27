/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 9: NÚMEROS.
 */

// para comprobar factorización on line puede probarlo aqui (programado por Darío Alpern)
// https://www.alpertron.com.ar/ECMC.HTM
package marcombo.lcriadof.capitulo9

import java.lang.Math.sqrt
import java.time.Duration
import java.time.Instant


class factorizacion {
    var numfactoresPrimo=0
    var numeroOriginal=0.0
    var factoresPrimos=mutableListOf<Double>()


    fun fuerzaBruta(num:Double){
        numfactoresPrimo=0
        numeroOriginal=num
       // borrarFactores()
        divisorPorTentativa(num)
    }

    private fun resto(dividendo:Double,divisor:Double):Double{
        var cociente:Double=dividendo/divisor
        var resto:Double=dividendo-(divisor*cociente) // formula del resto
        println(" dividendo $dividendo  divisor $divisor")
        println(" cociente $cociente")
        println(" resto $resto")
        return resto
    }

    private fun productoFactores():Double{
        var prod:Double=1.0
        for (h in 0..factoresPrimos.size-1){
            prod *= factoresPrimos.get(h)
        }
        return prod
    }

    private fun visualizarFactores():Double{
        var prod:Double=1.0
        if (factoresPrimos.size>1) {
            for (h in 0..factoresPrimos.size-1) {
                prod *= factoresPrimos.get(h)
                println("factor: " + h + "....... primo número: " + factoresPrimos[h])
            }
        }else{
            println("El numero $numeroOriginal es primo, por lo tanto su unico factor es el mismo")
        }
        return prod
    }

    /*
    private fun borrarFactores(){
        var prod:Double=1.0
        if (factoresPrimos.size>0) {
            for (h in factoresPrimos.size-1 downTo 0 ) { // descendente
                factoresPrimos.removeAt(h)
            }
        }
    }
    */


    private fun divisorPorTentativa(numero:Double){
        var bandera:Boolean=true // determina si el bucle for termina adecuadamente
        var num:Double=sqrt(numero)
        var rango=(3..(numero-1).toInt()).step(2) // me quedo solo con los impares

        var modulo:Double=0.0
        var factorAanalizar:Double=0.0

        // si es par
        modulo = (numero fmod 2.0) as Double  // calculamos el módulo
        if (modulo == 0.0) {  // es un factor primo
            numfactoresPrimo++
            factoresPrimos.add(2.0)
            bandera=false
        }

        // si es impar
        if (bandera){
            for (i in rango) {
                modulo = (numero fmod i.toDouble()) as Double  // calculamos el módulo
                if (modulo == 0.0) {  // es un factor primo
                    numfactoresPrimo++
                    factoresPrimos.add( i.toDouble())
                    bandera=false
                    break
                }
            } // fin de for

        }
        if (bandera){ // si ha terminado correctamente
            numfactoresPrimo++
            factoresPrimos.add( numero) // el último factor primo que faltaba
        }

        factorAanalizar=numeroOriginal/productoFactores()

        if ( (productoFactores()==numeroOriginal) ){
            visualizarFactores() // terminamos
        }else{
            divisorPorTentativa(factorAanalizar)
        }
     } // fin de divisorPorTentativa()



} // fin de clase



fun main() {
    val p = factorizacion()
    println("Introduzca un numero a factorizar: ")
    // 1409305684859.0; 1996277.0p; 1159523.0p; 2314729095871.0; 25413798.0, 23140958719585.0, 7290958700917.0
    // 9223372036854778.0
    //  para número mucho mayores de 3 ordenes de magnitud de Long la operación módulo no lo soporta adecuadamente

    val n:Double = readLine()?.toDouble() as Double

    // fuerza bruta
    var inicio = Instant.now()
    println("comienzo: "+inicio)
    println( "Factores del número $n: " )
    p.fuerzaBruta(n)
    var fin = Instant.now()
    println("fin: "+fin)
    var tiempoEmpleado = Duration.between(inicio, fin).toMillis()
    println("tiempo empleado: "+tiempoEmpleado+" milisegundos")
    println ("\n\n")




}