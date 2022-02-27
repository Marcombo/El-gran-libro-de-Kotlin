/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 9: NÚMEROS.
 */

package marcombo.lcriadof.capitulo9

// 9.2 Colecciones útiles para números.

fun main(){

    // vector
    val A= IntArray(5, { i -> 0 })   // o tambien    val A= Array<Int>(5,{i->0})
    println("\nA: "+A.joinToString()  )

    A[0]=5 // establecer valor
    println(A.joinToString())

    A.set(1,7) // otra forma de  establecer valor
    println(A.joinToString())

    A[2]=55
    A[3]=20
    A[4]=6
    println(A.joinToString())

    println("La media es "+A.average())
    println("El elemento 3 es "+A.elementAt(2))

    println(A.sortedArray().joinToString())



    // matrices
    val E: Array<IntArray> = Array(5) { IntArray(5) }  // inicializamos una matriz de orden 5
    E.forEach { println(it.joinToString()) } // visualizar la matriz


    val G: Array<IntArray> = Array(5) { IntArray(5, { i -> 37 }) }  // inicializamos una matriz de orden 5 con valor en todos sus elelemntos del 37
    G.forEach { println(it.joinToString()) }


    val H= Array(3) { DoubleArray(7) }
    H.forEach { println(it.joinToString()) }

    println("---- fin de matrices")


// inicializar con valores distintos en cada elemento
    var matriz: Array<IntArray> = arrayOf(
            intArrayOf(2, 4, 6),
            intArrayOf(1, 3, 5),
            intArrayOf(7, 21, 3) )

    println(matriz[0][0]) // acceder a un elemento
    matriz.forEach { println(it.joinToString()) }
    matriz=matriz.reversedArray()
    println()
    matriz.forEach { println(it.joinToString()) }


    // inicializar a ceros matriz rectangular
    var Aplus:Array<IntArray> = Array(3) { IntArray(4) }
    Aplus.forEach { println(it.joinToString()) }


println("*****************")


    // listas
    //    listOf() permite crear una lista inmutable. Podremos tener todos los elementos de un mismo tipo o de diferentes tipos de datos:

    val primos: List<Int> = listOf(2, 3, 5, 7)

    val list = mutableListOf<Int>()
    println("list.isEmpty() is ${list.isEmpty()}") // true

    list.addAll(listOf(1, 2, 3))
    println(list) // [1, 2, 3]



    // una lista mutable con elementos inicializados
    var lista2 = mutableListOf(1,7,3,9,5 )
    println(lista2.sort())


    //  una lista mutable vacía al que iremos incorporando elementos
    var factores=mutableListOf<Double>()
    factores.add( 34.5)
    factores.add( 3.1416)
    println( factores.get(1))

    // conjuntos
    val conjunto: Set<Int> = setOf(2, 3, 5, 7, 7, 9)
    println(conjunto.toString())

    val conjuntoMezclado = setOf(1.4E-8, 3.1416, "Luis", 'L')
    println(conjuntoMezclado.toString())


    println("*****************")


    // Maps
    var posicionesPrimos: Map<Int, Int> = mapOf(
            Pair(0, 1),
            Pair(1, 2),
            Pair(2, 3),
            Pair(3, 5),
            Pair(4, 7),
            Pair(5, 11),
            Pair(6, 13),
            Pair(7, 17),
            Pair(8, 19),
            Pair(9, 23),
            Pair(10, 29),
            Pair(11, 31),
            Pair(12, 37),
            Pair(13, 41),
            Pair(14, 43),
            Pair(15, 47),
     )

    println( posicionesPrimos.getValue(12) )

}
