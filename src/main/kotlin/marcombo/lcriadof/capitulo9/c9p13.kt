/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 9: NÚMEROS.
 */

package marcombo.lcriadof.capitulo9

import com.github.psambit9791.jdsp.misc.Plotting
import com.github.psambit9791.jdsp.transform.DiscreteFourier
import com.github.psambit9791.jdsp.misc.UtilMethods
import com.github.psambit9791.jdsp.signal.Generate


    fun main(args: Array<String>) {
        val Fs = 100
        val gp = Generate(0, 1, Fs)
        val f1 = 5
        //val out = gp.generateSawtooth(f1, 1.0) //Regular Sawtooth
        val out = gp.generateSawtooth(f1, 0.5) //Triangular Sawtooth
        //val out = gp.generateSawtooth(f1, 0.0) //Inverse Sawtooth
        val ejeX = gp.timeArray
        println(out.size) // tiene los puntos definidos en el muestreo
        val fig = Plotting(600, 300, "Sample Figure", "Time", "Signal")
        fig.initialisePlot()

        fig.addSignal("Señal", ejeX, out, false)
        fig.plot()

     }
