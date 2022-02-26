/*
El gran libro de Kotlin
(para programadores de back end)

Editor: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)
 */

package marcombo.lcriadof.capitulo6.lista_autor_ver1
// c6p3.kt   -- manejando los metodos por defecto de una data class
data class ListaAutores(var nombre:String,var apellido1:String, var apellido2:String)

// c6p3.kt
fun main() {
    val u1 = ListaAutores("Luis", "Criado","Fernandez")  // 1
    val u2 = u1.copy()  // 2
    val u3 = u1.copy(nombre="Pepe") // 3

    if (u1.equals(u2) == true)  // 4
        println("u1 y u2 son exactamente iguales")
    else
        println("u1 y u2 no son iguales")

    println("u1: "+u1.toString()) // 5
    println("u2: "+u2.component1()) // 6
    println("u2: "+u2.component2()) // 7
    println("u2: "+u2.component3()) // 8

    if (u2.equals(u3) == true)
        println("u2 y u3 son exactamente iguales")
    else
        println("u2 y u3 no son iguales")

    println("u3: "+u2.component1()+" "+u3.component2()+" "+u3.component3())  // 9

    println("Hashcode de u1: ${u1.hashCode()}")  // 10
    println("Hashcode de u2: ${u2.hashCode()}")  // 11
    println("Hashcode de u3: ${u3.hashCode()}")  // 12

}

