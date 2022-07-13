package marcombo.lcriadof.capitulo10

import kotlinx.serialization.builtins.serializer

/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 9: CADENAS.
 */

fun main() {
    // arrays de Strings

    // 1 dimensión
    val cadenas = arrayOf("Lunes", "Martes", "Miercoles","Jueves")
    cadenas.forEach { println(it) } // visualizar la matriz
    println()

    var cadenas2= Array<String>(4,{i->""})

    /*
    // opción tradicional
    for (i in 0..cadenas2.size-1){
        cadenas2[i]=cadenas[i].uppercase()
    }
    */

    var x=0
    cadenas.forEach { i -> cadenas2[x]=i.uppercase() // [1]
                            x++ }

    cadenas2.forEach { println(it) } // [2] visualizar la matriz




    // array de 2 domensiones, de 5x5 elementos
    var E3 = Array(5) { Array<String>(5,{i->"prueba"})} // [1]
    E3.forEach { println(it.joinToString()) } // [2] visualizar la matriz





}