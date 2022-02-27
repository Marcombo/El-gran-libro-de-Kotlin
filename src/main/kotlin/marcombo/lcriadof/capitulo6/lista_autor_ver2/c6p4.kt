/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 6: CLASES
 */

package marcombo.lcriadof.capitulo6.lista_autor_ver2

// c6p4.kt     clase con método sobrescrito
data class ListaAutores(var nombre:String,var apellido1:String, var apellido2:String){
    override fun toString():String{ // 1
        return nombre+" "+apellido1+" "+apellido2
    }
    fun getIniciales():String{     // 2
        return nombre.subSequence(0,1).toString()+
                apellido1.subSequence(0,1).toString()+
                apellido2.subSequence(0,1).toString()
    }
}

fun main() {
    val u1 = ListaAutores("Luis", "Criado","Fernandez")
    val u2 = u1.copy()
    val u3 = u1.copy(nombre="Pepe")

    if (u1.equals(u2) == true)
        println("u1 y u2 son exactamente iguales")
    else
        println("u1 y u2 no son iguales")

    println("u1: "+u1.toString()+" ("+u1.getIniciales()+")")
    println("u2: "+u2.component1()+" "+u2.component2()+" "+u2.component3())     // obtiene la propiedad definida en primer lugar, en este caso "nombre"


    if (u2.equals(u3) == true)
        println("u2 y u3 son exactamente iguales")
    else
        println("u2 y u3 no son iguales")

    println("u3: "+u3.toString()+" ("+u3.getIniciales()+")")

    println("Hashcode de u1: ${u1.hashCode()}")
    println("Hashcode de u2: ${u2.hashCode()}")
    println("Hashcode de u3: ${u3.hashCode()}")

}

