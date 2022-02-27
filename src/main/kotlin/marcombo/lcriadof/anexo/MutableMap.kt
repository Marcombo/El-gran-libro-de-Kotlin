/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

ANEXO
 */

package marcombo.lcriadof.anexo


// manejo de MutableMap
//  1.-  individual
//  2.-  conjuntos de MutableMap
//  3.-  arrays de MutableMap
fun main() {
    // 1.- manejo de MutableMap individual
    var p1: MutableMap<String, String> = mutableMapOf() // inicializamos una variable MutableMap

    p1.put("nombre", "Luis")
    p1.put("apellido", "Criado")
    p1.put("apellido2", "Fernández")

    println(p1.toString())

    var p2: MutableMap<String, String> = mutableMapOf() // inicializamos una variable MutableMap
    p2.put("nombre", "Luis")
    p2.put("apellido", "Criado")
    p2.put("apellido2", "Abad")

    //  2.-  conjuntos de MutableMap
    val conjunto: Set< MutableMap<String, String>> = setOf(p1,p2)
    println(conjunto.toString())
    println(conjunto.indices)


    // conjunto mutable de  HasMutables
    var conjuntoMutable = mutableSetOf< MutableMap<String, String> >()
    conjuntoMutable.add(p1)
    conjuntoMutable.add(p2)

    println( conjuntoMutable.elementAt(0) )
    println( conjuntoMutable.elementAt(1) )

    println(conjuntoMutable)

    p2.put("nombre", "Pepe")
    p2.put("apellido", "Perez")
    p2.put("apellido2", "Gonzalez")
    conjuntoMutable.add(p2)
    println(conjuntoMutable)


    // 3.-  arrays de MutableMap


    val f3= Array<MutableMap<String, String>>(3,{i->mutableMapOf() })
    println(f3.joinToString())

    f3[0].put("nombre", "Luis")
    f3[0].put("apellido", "Criado")
    f3[0].put("apellido2", "Fernández")

    f3[1].put("nombre", "Luis")
    f3[1].put("apellido", "Criado")
    f3[1].put("apellido2", "Abad")

    f3[2].put("nombre", "Pepe")
    f3[2].put("apellido", "Perez")
    f3[2].put("apellido2", "Gonzalez")
    println(f3.joinToString())
}
