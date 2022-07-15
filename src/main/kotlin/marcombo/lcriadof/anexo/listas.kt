/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

ANEXO
*/

package marcombo.lcriadof.anexo

import marcombo.lcriadof.capitulo7.fichero.json.Estudiante

fun main(){
    var mutableList: MutableList<String> = mutableListOf()

    mutableList.none() //Nos devuelve un true si está vacía la lista
    mutableList.firstOrNull() //Nos devolverá el primer campo, y si no hay, un null.
    mutableList.elementAtOrNull(2) //El elemento del índice 2, si no hay, devolverá un null
    mutableList.lastOrNull() //Último valor de la lista o null
    mutableList.add("Alberto")
    mutableList.add("Luis")
    mutableList.add("Amor")
    mutableList.add("Belén")
    mutableList.add("Luis")

    println("Tamaño: "+mutableList.size)

    mutableList.sort()
    println(mutableList)
    mutableList.remove("Luis")
    mutableList.removeAt(0)
    println(mutableList)







    // lista inmutable
    var lista1: List<String> = listOf("lunes", "martes", "miercoles", "jueves",
            "viernes", "sábado", "domingo")
    println("Imprimir la lista completa")
    println(lista1)
    println("Imprimir el primer elemento de la lista")
    println(lista1[0])
    println("Imprimir el primer elemento de la lista")
    println(lista1.first())
    println("Imprimir el último elemento de la lista")
    println(lista1.last())
    println("Imprimir el último elemento de la lista")
    println(lista1[lista1.size-1])
    println("Imprimir la cantidad de elementos de la lista")
    println(lista1.size)
    println("Recorrer la lista completa con un for")
    for(elemento in lista1)
        print("$elemento ")
    println()
    println("Imprimir el elemento y su posición")
    for(posicion in lista1.indices)
        print("[$posicion]${lista1[posicion]} ")




    // listas inmutables   no hay algo del tipo intListOf
    var list = listOf(1,2,5,4,3)
    println( "\nLista actual "+list.joinToString() )
    println( "\nla media es "+list.average() )
    println( "\nOrdenamos "+list.sorted() )
    println("ver elemento 3: "+list[2])

    var list2=list.sorted()
    println("ver elemento 3: "+list2[2])

    // aplicamos patrones de diseño: Pipeline
    println("Pipeline:"+list.map { i-> i * i }.joinToString())


    // listas mutables
    var mutableList2 = mutableListOf(1,7,3,2,5,8 )

    println( "\n\nLista actual "+mutableList2.joinToString() )
    println( mutableList2.binarySearch(7) )
    println( "la media es "+mutableList2.average() )
    mutableList2.sort() // orenamos la lista
    println( "Ordenamos "+mutableList2.joinToString()  )
    println( "Buscamos el 7"+mutableList2.binarySearch(7) )
    println("ver elemento 4 (empezando desde el cero): "+mutableList2[4])

    println( mutableList2.binarySearch(7) )



    // listas con datos de distinto tipo
    val List1 = mutableListOf<Any>()
    List1.add("Electromagnetismo")
    List1.add(Estudiante("Paco", 5))
}