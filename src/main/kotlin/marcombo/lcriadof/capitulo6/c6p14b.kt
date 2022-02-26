/*
El gran libro de Kotlin
(para programadores de back end)

Editor: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)
 */

package marcombo.lcriadof.capitulo6
// c6p14b.kt

sealed class OperacionBasica {
    class sumar(val valor: Int) : OperacionBasica()
    class restar(val valor: Int) : OperacionBasica()
    class multiplicar(val valor: Int) : OperacionBasica()
    class dividir(val valor: Int) : OperacionBasica()
}


fun operar(x: Int, op: OperacionBasica) = when (op) {  // 1
    is OperacionBasica.sumar -> x + op.valor
    is OperacionBasica.restar -> x - op.valor
    is OperacionBasica.multiplicar -> x * op.valor
    is OperacionBasica.dividir -> x / op.valor
}

fun main(){
    println("Piense en un numero: ")
    val num = readLine()?.toInt() as Int  // 1

    println("Súmale 3")
    var e=operar(num,OperacionBasica.sumar(3)) // 2
  //  println(e)

    println("Multiplica el resultado por 2")
    e=operar(e,OperacionBasica.multiplicar(2)) // 3
  //  println(e)

    println("A lo que quedó réstale 8")
    e=operar(e,OperacionBasica.restar(8)) // 4
  //  println(e)

    println("El resultado divídelo entre 2")
    e=operar(e,OperacionBasica.dividir(2)) // 5
  //  println(e)

    println("\nEl numero que pensastes fue el "+(e+1))
}

