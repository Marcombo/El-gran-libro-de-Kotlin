/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 9: NÚMEROS.
 */

package marcombo.lcriadof.capitulo9

import com.github.psambit9791.jdsp.misc.Plotting
import com.github.psambit9791.jdsp.misc.UtilMethods
import com.github.psambit9791.jdsp.signal.Generate
import com.github.psambit9791.jdsp.transform.DiscreteFourier
import kotlin.math.PI
import com.github.psambit9791.jdsp.transform.InverseDiscreteFourier

// transformada de Fourier
// tabla de transformadas https://es.wikipedia.org/wiki/Transformada_de_Fourier
// https://psambit9791.github.io/jDSP/

fun main() {
    val Fs = 100
    val f1 = 10
    var outputFileName = ""

    // generamos señal coseno
    val gp = Generate(0, 2*f1, Fs)
    val coseno: DoubleArray = gp.generateCosineWave(f1)
    val ejeX = gp.timeArray
    val fig = Plotting(600, 300, "coseno", "tiempo", "señal")
    fig.initialisePlot()
    fig.addSignal("cos(x)", ejeX, coseno, false)
    fig.plot()
    outputFileName = "coseno.png"
    fig.saveAsPNG(outputFileName)

    // transformada de Fourier
    val fft = DiscreteFourier(coseno)
    fft.dft();
    val onlyPositive = false
    var sennal1fft: DoubleArray = fft.returnAbsolute(onlyPositive) //Full  Absolute

    // eje de abscisas de frecuencias (eje horizontal) para su representación gráfica
    val start = -f1
    val stop = f1
    val samples = sennal1fft.size
    val includeEnd = true
    val frecuencias = UtilMethods.linspace(start, stop, samples, includeEnd)

    // dibujamos la FFT de la señal de entrada
    val fig3 = Plotting(600, 300, "transformada de Fourier del coseno", "frecuencia", "señal")
    fig3.initialisePlot()
    fig3.addSignal("F(cos(x))", frecuencias, sennal1fft, false)
    fig3.plot()
    outputFileName = "FFTcoseno.png"
    fig3.saveAsPNG(outputFileName)

}