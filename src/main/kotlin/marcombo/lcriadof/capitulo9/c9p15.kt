/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 9: NÚMEROS.
 */

package marcombo.lcriadof.capitulo9

import com.github.psambit9791.jdsp.transform.DiscreteFourier
import com.github.psambit9791.jdsp.transform.InverseDiscreteFourier
import com.github.psambit9791.jdsp.io.Csv

// https://psambit9791.github.io/jDSP/

fun main(){

    val signal= DoubleArray(9, { i -> i+1.0 })  // 1
    println("Señal original")
    println(signal.joinToString())

    val fft = DiscreteFourier(signal) // 2
    fft.dft() // 3
    val out = fft.returnFull(false) // 3 Full Complex

    println()
    println("procesamos la señal original con la FFT")
    // El resultado FFT tiene números complejos
    for (i in 0..out.size-1){ // 4
        for (j in 0..1){
            print("\t"+out[i][j])
            if (j==1){
                print("i")
            }
        }
        println()
    }


    println()
    println("Recuperamos la señal original con la transformada inversa IFFT")
    val transformer = InverseDiscreteFourier(out,false) // 5
    transformer.idft() // 6
    val out2 = transformer.absoluteSignal // 7
    println(out2.joinToString()) // 8



    // redondeamos los números
    for (i in 0..out2.size-1){ // 9
        out2[i] = (Math.round(out2[i] * 100) / 100).toDouble()
    }
    println()
    println("Recuperamos la señal original con la transformada inversa IFFT (redondeado)")
    println(out2.joinToString()) // 10


}