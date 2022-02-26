/*
El gran libro de Kotlin
(para programadores de back end)

Editor: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)
 */

package marcombo.lcriadof.capitulo6

// c6p13.kt
// ejemplo de objeto

object Matematica { // 1
    val PI  = 3.1415926535  // 2
    val e   = 2.7182818284
    val phi = 1.6180339887

    init{
        print("objeto creado \n") // 3
    }
    fun areaCircunferencia(radio: Int):Int=(PI*radio*radio).toInt() // 4
}

fun main(parametro: Array<String>) {
    print("<<bloque 1\n")
    val constante1 = Matematica // 5
    println("El valor de Pi es "+constante1.PI)  // 6
    println("El valor de Pi es ${constante1.PI}") // 7

    print("<<bloque 2\n")
    val constante2 = Matematica // 8
    println("El valor de Pi es "+constante2.PI)
    println("El valor de Pi es ${constante2.PI}")

    print("<<bloque 3\n")
    println("El valor de Pi es ${Matematica.PI}") // 9
    println("El valor del número e ${Matematica.e}")
    println("El valor del número aureo es ${Matematica.phi}")

    val r=15
    println("El área de una circunferencia con radio "+r+" es "+Matematica.areaCircunferencia(r)) // 10
}