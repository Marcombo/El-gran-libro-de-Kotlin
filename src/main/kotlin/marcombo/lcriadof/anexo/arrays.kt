/*
El gran libro de Kotlin
(para programadores de back end)

Editor: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)
 */

package marcombo.lcriadof.anexo


fun main(){

    // ejemplos arrays de una dimensión
    val f= Array<Int>(5,{i->0}) // array de 5 elementos tipo Int inicializado a cero
    println(f.joinToString())

    val f2= IntArray(5,{i->10})
    println(f2.joinToString())

    val f3= Array<String>(5,{i->""})
    println(f3.joinToString())

    val f4= Array<String>(5,{i->"prueba"})
    println(f4.joinToString())

    val f5= Array<MutableMap<String, String>>(3,{i->mutableMapOf() })
    println(f5.joinToString())



    // ejemplos arrays de una bidimensionales
    val E: Array<IntArray> = Array(5) { IntArray(5) }  // inicializamos una matriz de orden 5
    E.forEach { println(it.joinToString()) } // visualizar la matriz

    // array de Strings de 8 columnas * 10 filas
    val E2: Array<Array<String?>> = Array(10) { arrayOfNulls<String>(8) }  // inicializamos una matriz de orden 5
    E2.forEach { println(it.joinToString()) } // visualizar la matriz

    val E3 = Array(5) { Array<String>(5,{i->"prueba"})}
    E3.forEach { println(it.joinToString()) } // visualizar la matriz


    // array 3 filas por 5 columnas con distintos datos
    // ejemplo de https://stackoverflow.com/questions/46410924/kotlin-how-to-create-a-2d-array-of-the-type-string
    val string2DArray: Array<Array<String>> = arrayOf(
            arrayOf("manzana", "pera", "sandia", "mango", "melón"),
            arrayOf("_", "!", ":", "?"),
            arrayOf("1", "2", "3", "4", "5", "10"))
    string2DArray.forEach {
        it.forEach { it -> print("$it, ") }
        println()
    }

  // inicializamos una matriz de orden 5 con valor en todos sus elelemntos del 37
    val G: Array<IntArray> = Array(5) { IntArray(5, { i -> 37 }) }
    G.forEach { println(it.joinToString()) }


    val H= Array(3) { DoubleArray(7) }
    H.forEach { println(it.joinToString()) }


    // inicializar a ceros matriz rectangular
    var Aplus:Array<IntArray> = Array(3) { IntArray(4) }
    Aplus.forEach { println(it.joinToString()) }



    // inicializar con valores enteros distintos en cada elemento
    var matriz: Array<IntArray> = arrayOf(
            intArrayOf(2, 4, 6),
            intArrayOf(1, 3, 5),
            intArrayOf(7, 21, 3) )

    println(matriz[0][0]) // acceder a un elemento
    matriz.forEach { println(it.joinToString()) }
    matriz=matriz.reversedArray()
    println()
    matriz.forEach { println(it.joinToString()) }


   /// array de tres dimensiones

    val x:Array<Array<IntArray>> = Array(2, { Array(3, { IntArray(5,{i->1}) } ) } )
    println( x[0][0][0] )

    println( "x [primera dimensión]: "+x.size)
    println( "x [segunda dimensión]: "+x[0].size)
    println( "x [tercera dimensión]: "+x[0][0].size)

    // recorrer el array cubo
    for (c1 in 0..x.size-1){
        for (c2 in 0..x[0].size-1){
            for (c3 in 0..x[0][0].size-1){
                println("x[$c1][$c2][$c3] = "+ x[c1][c2][c3] )
            }
        }
    }



    val x2 = Array(2,{Array(2) { Array<String>(5,{i->"prueba"})}})
    println( x2[0][1][1] )


    /// array de cuatro dimensiones
    val z:Array<Array<Array<IntArray>>> = Array(2,  { Array(3, { Array(4, { IntArray(5,{i->2}) }   ) }  ) })
    println( z[0][0][0][0] )


    // array con datos de distinto tipo
    val myArray = arrayOf(4, 5, 7, "3", "Chike", false)
}