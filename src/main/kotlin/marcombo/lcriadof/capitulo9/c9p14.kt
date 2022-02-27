/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 9: NÚMEROS.
 */

package marcombo.lcriadof.capitulo9

import com.github.psambit9791.jdsp.misc.Plotting
import com.github.psambit9791.jdsp.signal.Generate
import com.github.psambit9791.jdsp.signal.Convolution

// https://psambit9791.github.io/jDSP/



// generación y representacion de señal senoseidales

fun main() {

    // frecuencia de muestreo de 100Hz y una frecuencia de señal de 10Hz.
    val Fs = 100 // frecuencia de muestreo
    val f1 = 10  // frecuencia de la señal
    var outputFileName=""

    // generamos señal coseno
    val gp = Generate(0, 1, Fs)
    val sennal1: DoubleArray = gp.generateSineWave(f1)
    val ejeX = gp.timeArray

    val fig = Plotting(600, 300, "coseno", "tiempo", "señal")
    fig.initialisePlot()
    fig.addSignal("cos(x)", ejeX, sennal1, false)
    fig.plot()
    outputFileName = "coseno.png"
    fig.saveAsPNG(outputFileName)

    // generamos señal seno
    val gp2 = Generate(1, 0, Fs)
    val sennal2: DoubleArray = gp2.generateCosineWave(f1)
    val ejeX2 = gp2.timeArray

    val fig2 = Plotting(600, 300, "seno", "tiempo", "señal")
    fig2.initialisePlot()
    fig2.addSignal("sin(x)", ejeX2, sennal2, false)
    fig2.plot()
    outputFileName = "seno.png"
    fig2.saveAsPNG(outputFileName)

    // mostramos las dos señales juntas
    val fig3 = Plotting(600, 300, "seno y coseno", "tiempo", "señal")
    fig3.initialisePlot()
    fig3.addSignal("cos(x)", ejeX, sennal1, false)
    fig3.addSignal("sin(x)", ejeX2, sennal2, false)
    fig3.plot()

    // sumamos las dos señales
    val hasta=sennal1.size
    var sennal3= DoubleArray(hasta, { i -> 0.0 })
       for (i in 0..hasta-1){
        sennal3[i]=sennal1[i]+sennal2[i]
        println("sennal1[$i]: "+sennal1[i]+" + sennal2[$i]: "+sennal2[i]+" = sennal3[$i]: "+sennal3[i])
       }
    val fig4 = Plotting(600, 300, "seno + coseno", "tiempo", "señal")
    fig4.initialisePlot()
    fig4.addSignal("cos(x)+sin(x)", ejeX, sennal3, false)
    fig4.plot()



}