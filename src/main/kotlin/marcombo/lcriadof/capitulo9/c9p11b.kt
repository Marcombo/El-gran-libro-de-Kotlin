/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 9: NÚMEROS.
 */

package marcombo.lcriadof.capitulo9

//  https://github.com/psambit9791/jDSP
import com.github.psambit9791.jdsp.misc.Plotting
import com.github.psambit9791.jdsp.signal.Generate


fun main() {
    val Fs = 100 // 1
    val f1 = 10  // 2
    val gp2 = Generate(1, 2, Fs)  // 3  punto de tiempo de inicio, frecuencia de muestreo
    val sennal2: DoubleArray = gp2.generateCosineWave(f1) // 4
    val ejeX2 = gp2.timeArray // 5
    val fig2 = Plotting(600, 300, "seno", "tiempo", "señal") // 6
    fig2.initialisePlot() // 7
    fig2.addSignal("sin(x)", ejeX2, sennal2, false) // 8
    fig2.plot() // 9
    fig2.saveAsPNG("seno.png") // 10
}
