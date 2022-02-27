/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 5: FUNCIONES
 */

package marcombo.lcriadof.capitulo5

fun main(){
    // programa c5p11.kt, función extendida
    fun Int.elevado(potencia:Int):Int {  // 1
        var salida:Int=1
        for (x in 1..potencia){         // 2
            salida =salida*this         // 3
        }
        return salida
    }
    var num:Int=8; var elev:Int=5       // 4
    println( "$num elevado a $elev es: "+num.elevado(elev) )  // 5
    num=3; elev=4
    println( "$num elevado a $elev es: "+num.elevado(elev) )  // 6
}