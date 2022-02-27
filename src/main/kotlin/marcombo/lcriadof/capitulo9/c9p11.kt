/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 9: NÚMEROS.
 */

package marcombo.lcriadof.capitulo9

import kotlin.math.cos


fun Double.potencia(potencia:Int):Double {
    val base=this // 1
    var salida:Double=1.0
    for (x in 1..potencia){ //2
        salida=salida*base  // 3
    }
    return salida
}

fun factorial(num:Long):Long {
    var factorial: Long = 1
    var i:Int=1
    while (i < num+1) {
        factorial= factorial* i.toLong()
        i++
    }
    return factorial
}

tailrec fun fact(num: Long): Long
        = if (num < 2.0) 1 else num*fact(num - 1)


fun coseno(x: Double):Double{
    var c:Double = 0.0
    for(n in 0..15){
        c = c+((-1.0).potencia(n)/factorial((2*n).toLong())*x.potencia(2*n)) // 4
    }
   return c
}

fun coseno2(x: Double):Double{
    var c:Double = 0.0
    for(n in 0..15){
        c = c+((-1.0).potencia(n)/fact((2*n).toLong())*x.potencia(2*n)) //
    }
    return c
}


fun main(){
/*
    // probamos la función potencia
    var c:Double=2.0.potencia(10)
    println(c)
    c=(-1.0).potencia(5)
    println(c)


    // probamos la función factorial
    val f:Long=factorial(10)
    println(f)

 */


    println("\nAproximación de Maclaurin (mediante factorial iterativo):")
    print(" cos(0) ")
    println(coseno(0.0))
    print(" cos(PI/6) ")
    println(coseno(kotlin.math.PI/6))
    print(" cos(PI/4) ")
    println(coseno(kotlin.math.PI/4))
    print(" cos(PI/3) ")
    println(coseno(kotlin.math.PI/3))
    print(" cos(PI) ")
    println(coseno(kotlin.math.PI))


    println("\nAproximación de Maclaurin (mediante factorial recursivo):")
    print(" cos(0) ")
    println(coseno2(0.0))
    print(" cos(PI/6) ")
    println(coseno2(kotlin.math.PI/6))
    print(" cos(PI/4) ")
    println(coseno2(kotlin.math.PI/4))
    print(" cos(PI/3) ")
    println(coseno2(kotlin.math.PI/3))
    print(" cos(PI) ")
    println(coseno2(kotlin.math.PI))






    println("\n\nImplementacion kotlin:")
    print(" cos(0) ")
    println(cos(0.0))
    print(" cos(PI/6) ")
    println(cos(kotlin.math.PI/6))
    print(" cos(PI/4) ")
    println(cos(kotlin.math.PI/4))
    print(" cos(PI/3) ")
    println(cos(kotlin.math.PI/3))
    print(" cos(PI) ")
    println(cos(kotlin.math.PI))




}