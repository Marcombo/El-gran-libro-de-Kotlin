/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 6: CLASES
 */

package marcombo.lcriadof.capitulo6

// ejemplo extraido de https://kotlinlang.org/docs/reference/enum-classes.html
// c6p5.kt
enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

enum class Direction {
    NORTH, SOUTH, WEST, EAST
}


fun main() {
   val col= Color.BLUE
    println(col.rgb)

   val dir= Direction.NORTH
    println(dir.name)
}