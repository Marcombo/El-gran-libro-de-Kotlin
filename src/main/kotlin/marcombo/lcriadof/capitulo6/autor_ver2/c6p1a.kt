/*
El gran libro de Kotlin
(para programadores de back end)

Editor: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)
 */

package marcombo.lcriadof.capitulo6.autor_ver2

// c6p1.kt
fun main() {
    val at: Autor = Autor("Luis","Criado","Fernandez")  // 1
    println(at.Nombre+" "+at.apellido1)              // 2
}

// c6p1.kt
class Autor (var Nombre:String , var apellido1:String, var apellido2:String){ // 1
    init{ // bloque que se ejecuta cuando se invoca cualquier construcctor
    }
    constructor (nom: String, ape1:String): this(nom, ape1,""){ }  // 5
    constructor (nom: String): this(nom, "",""){ }           // 6
}// fin de clase