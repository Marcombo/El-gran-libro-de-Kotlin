/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 6: CLASES
 */

package marcombo.lcriadof.capitulo6

import java.math.RoundingMode
import java.text.DecimalFormat


sealed class CteMatematicas {
    class pi() : CteMatematicas(){
        val valor:Double=3.14159265358979323846264338327950288419716939937510582097494459230
    }
    class phi() : CteMatematicas(){
        val valor:Double=1.61803398874989484820458683436563811772030917980576286213544862270
    }
    class e() : CteMatematicas(){
        val valor:Double=2.71828182845904523536028747135266249775724709369995957496696762772
    }
    class G() : CteMatematicas(){
        val valor:Double=6.674E-11
        val unidades:String="N*m2/Kg2"
    }
    class c() : CteMatematicas(){
        val valor:Double= 300000.0
        val unidades:String="km/s"
    }
    class aluz() : CteMatematicas(){
        val valor:Double= 9.46E12
        val unidades:String="km"
    }
}

fun main(){
    val numPi: CteMatematicas.pi = CteMatematicas.pi() // 1
    val numPhi: CteMatematicas.phi = CteMatematicas.phi()
    val numE: CteMatematicas.e = CteMatematicas.e()
    val cteGravitación: CteMatematicas.G = CteMatematicas.G()
    val velocidadLuz: CteMatematicas.c = CteMatematicas.c()
    val YearLuz: CteMatematicas.aluz = CteMatematicas.aluz()

    var df = DecimalFormat("#.######")  // 2
    val df2 = DecimalFormat("###,###")
    var df3 = DecimalFormat("#.##################")
    df.roundingMode = RoundingMode.CEILING
    df2.roundingMode = RoundingMode.CEILING
    df3.roundingMode = RoundingMode.CEILING



    val cte: CteMatematicas = CteMatematicas.aluz() // 3
    val mostrar = when (cte) { // 4
        is CteMatematicas.pi ->
            println("numero e: "+df.format(numPi.valor))
        is CteMatematicas.e ->
            println("numero e: "+df.format(numE.valor))
        is CteMatematicas.phi ->
            println("numero phi: "+df.format(numPhi.valor))
        is CteMatematicas.G ->
            println("Constante de gravitación universal: "+df3.format(cteGravitación.valor)+" "+cteGravitación.unidades)
        is CteMatematicas.c ->
            println("Constante de gravitación universal: "+df2.format(velocidadLuz.valor)+" "+velocidadLuz.unidades)
        is CteMatematicas.aluz -> // 5
            println("Año Luz: "+df2.format(YearLuz.valor)+" "+YearLuz.unidades)
     }
}
