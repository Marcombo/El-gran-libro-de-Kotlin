package marcombo.lcriadof.capitulo10
/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 9: CADENAS Y PALABRAS.
 */

fun main() {

 // Acceso a los caracteres de un String

    // recorrer un String
    var cad1:String="hola mundo"
    for (i in cad1) {
        print(i+"  ")
    }
    println() // forzamos un salto de linea


    // usando una notación más kotlin
    cad1.forEach { caracter -> print(caracter+"  ") }
    println() // forzamos un salto de linea

    // usando una notación más kotlin
    cad1.forEachIndexed  { posicion,caracter -> print("[posicion $posicion: caracter $caracter] ")  }
    println() // forzamos un salto de linea

    // acceder a un elemento determinado del String, hay que considerar que comienza desde el cero
    val posicion:Int=3
    println("posición "+posicion+": "+cad1[posicion])

}