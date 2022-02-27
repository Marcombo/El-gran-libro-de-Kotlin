/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 6: CLASES
 */

package marcombo.lcriadof.capitulo6

// alias de una clase
typealias inicializarVal = RetrasarInicializacionParametrosVal


fun main() {
    println("Valor para inicializar: ")
    val num = readLine()?.toInt() as Int  // 3

    var o=inicializarVal(num) // 4
    println("[numero] es "+o.numero) // 5
    o.numero=num*2 // 6
    println("[numero] es "+o.numero) // 7
    println("[cte1] es "+o.cte1+" (inicializada tardiamente con lazy)") // 8

}