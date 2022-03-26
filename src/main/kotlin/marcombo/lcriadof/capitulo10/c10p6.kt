package marcombo.lcriadof.capitulo10

/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 9: CADENAS Y PALABRAS.
 */

fun main() {
// padding

    val nums = intArrayOf(25, 125, 1966, 2200)
    // visualizar relleno por la izquierda
    nums.toList().forEach { it -> println(it.toString().padStart(6, '0')) }

    val cadenas = arrayOf("Lunes", "Martes", "Miercoles","Jueves")
    cadenas.forEach { println(it) } // visualizar la matriz

    // visualizar relleno por la izquierda
    cadenas.toList().forEach { it -> println(it.toString().padStart(10, '_')) }

    // visualizar relleno por la derecha
    cadenas.toList().forEach { it -> println(it.toString().padEnd(15, '_')) }




    // rellenar por la izquierda y volcarlo en una array String
    val cadenas2= Array<String>(4,{i->""}) // inicializamos un array String con espacios

    var i=0
    nums.toList().forEach { iter -> cadenas2[i]=iter.toString().padStart(6, '0')
                                    i++}

    cadenas2.toList().forEach{ it->println(it) }

}