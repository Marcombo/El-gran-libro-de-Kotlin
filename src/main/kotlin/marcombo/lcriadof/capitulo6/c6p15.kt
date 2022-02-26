/*
El gran libro de Kotlin
(para programadores de back end)

Editor: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)
 */

package marcombo.lcriadof.capitulo6

// inicialización tardia para "var" con lateinit
class RetrasarInicializacionParametros(var cadena2: String)  {
    lateinit var cadena1: String  // 1
    init{
         var cadena2: String=cadena2
    }

    fun obtenerPropiedad(){
        println(cadena1)
    }
    fun obtenerPropiedadCadena1():String{
        return cadena1
    }
}


fun main() {
    var o=RetrasarInicializacionParametros("texto 2")
       o.cadena1="texto 1" // 2
    println("La cadena 1 es "+o.cadena1)
    println("La cadena 1 es "+o.obtenerPropiedadCadena1())
}