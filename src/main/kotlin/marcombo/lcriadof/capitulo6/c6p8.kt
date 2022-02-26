/*
El gran libro de Kotlin
(para programadores de back end)

Editor: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)
 */

package marcombo.lcriadof.capitulo6



// c6p8.kt
fun main() {
    val at: Autor = Autor("Luis","Criado","Fernandez")
    println(at.Nombre+" "+at.apellido1+" "+at.apellido2+": "+at.getIniciales())
    at.apellido1="Abad"
    println(at.Nombre+" "+at.apellido1+" "+at.apellido2+": "+at.getIniciales())


}

// c6p8.kt
open class Persona (var Nombre:String,var apellido1:String, var apellido2:String){ //1
    constructor (nom: String, ape1:String): this(nom, ape1,""){ }
    constructor (nom: String): this(nom, "",""){ }
    open fun getIniciales():String{     // 2
        return  apellido1.subSequence(0,1).toString()+
                apellido2.subSequence(0,1).toString()
    }
}// fin de clase Persona


// c6p8.kt
class Autor (nom:String,ape1:String,ape2:String): Persona (nom,ape1,ape2){ // 3
    override fun getIniciales():String{     // 4
        return Nombre.subSequence(0,1).toString()+
                apellido1.subSequence(0,1).toString()+
                apellido2.subSequence(0,1).toString()
    }
}// fin de clase Autor