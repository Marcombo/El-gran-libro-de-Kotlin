/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 6: CLASES
 */

package marcombo.lcriadof.capitulo6

// inspirado en el ejemplo de:
//          https://www.develou.com/objetos-companeros-en-kotlin/

// Un ortoedro es un prisma rectangular ortogonal, cuyas caras forman entre sí ángulos diedros rectos. A estos prismas rectos, y se los denomina paralelepípedos rectangulares




class ortoedro (val altura: Int, val anchura: Int, val longitud: Int) {
    val volumen = altura * anchura * longitud

    companion object { // [1]
        fun definicion(altura: Int, anchura: Int, longitud: Int): ortoedro = ortoedro(altura, anchura, longitud) // [2]
        fun definicion(size: Int): ortoedro = ortoedro(size, size, size) // [3]
    }
}


class ortoedro2 (altura: Int, anchura: Int, longitud: Int) {
    val volumen = altura * anchura * longitud
    val altura:Int
    val anchura:Int
    val longitud:Int

    init {
        this.altura = altura
        this.anchura = anchura
        this.longitud = longitud
    }
    constructor (altura: Int) : this(altura, altura, altura) {}
}


fun main() {

    // uso de la clase octoedro
    val figura1 = ortoedro.definicion(5, 10, 10)
    val cubo1 = ortoedro.definicion(10)
    println("Volumen figura1: ${figura1.volumen}, Volumen cubo1: ${cubo1.volumen}")
    // otra forma clase octoedro
    println("Volumen figura1: ${ortoedro.definicion(5, 10, 10).volumen}, Volumen cubo1: ${ortoedro.definicion(10).volumen}")

    // uso de la clase octoedro2
    val figura2 = ortoedro2(5, 10, 10)
    val cubo2 = ortoedro2(10)
    println("Volumen figura2: ${figura2.volumen}, Volumen cubo2: ${cubo2.volumen}")
    // otra forma clase octoedro2
    println("Volumen figura1: ${ortoedro2(5, 10, 10).volumen}, Volumen cubo1: ${ortoedro2(10).volumen}")

}