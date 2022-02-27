/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 9: NÚMEROS.
 */

package marcombo.lcriadof.capitulo9
// rango de numeros
fun main() {
    println("tipo,   tamaño,        rango ")
    println("Byte,   "+Byte.SIZE_BITS+" bits, "+Byte.MIN_VALUE+" .. "+Byte.MAX_VALUE) // 1
    println("Short, "+Short.SIZE_BITS+" bits, "+Short.MIN_VALUE+" .. "+Short.MAX_VALUE)
    println("Int,   "+Int.SIZE_BITS+" bits, "+Int.MIN_VALUE+" .. "+Int.MAX_VALUE)
    println("Long,  "+Long.SIZE_BITS+" bits, "+Long.MIN_VALUE+" .. "+Long.MAX_VALUE)
    println("Float, "+Float.SIZE_BITS+" bits, "+Float.MIN_VALUE+" .. "+Float.MAX_VALUE)
    println("Double,"+Double.SIZE_BITS+" bits, "+Double.MIN_VALUE+" .. "+Double.MAX_VALUE)

}