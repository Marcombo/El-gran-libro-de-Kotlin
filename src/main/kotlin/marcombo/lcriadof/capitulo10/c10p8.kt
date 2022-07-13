package marcombo.lcriadof.capitulo10


import kotlinx.serialization.builtins.serializer

/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 10: CADENAS.
 */

fun main() {

    val cadenas = arrayOf("Lunes", "Martes", "Miercoles","Jueves","Viernes","Sábado","Domingo")

    //  Map donde la clave y valor son Strings
    var f5: MutableMap<String, String> = mutableMapOf() // [1] inicializamos una variable MutableMap
    var y=0
    for (y in 0..cadenas.size-1){
        f5.put((y+1).toString(),cadenas[y]) // [2]
    }
    println( f5.toString() ) // [3]
}