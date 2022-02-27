/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 6: CLASES
 */

package marcombo.lcriadof.capitulo6

// c6p2.kt
fun main() {
    val cadena= StringHex("<-045690aa---- --- 34bbccd46-0708090 -> ")  // 1

    var s="Luis"
   println (s.replace("L", "a"))



    println(cadena.cadenaHexadecimal)  // 2
    cadena.limpiar("-"," ","<",">")
    println(cadena.cadenaHexadecimal)  // 2
    if (cadena.cambiar("bbcc","0099")){ // 3
        println(cadena.cadenaHexadecimal)
    }else{
        println("la modificación no tuvo éxito")
    }
}

// c6p2.kt
class StringHex(var cadenaHexadecimal: String) {            // 1
   fun limpiar(vararg borrar:String){        // 3
        var ciclo:Int=0
        for (i in borrar){             // 4
            del(borrar[ciclo])               // 5
            ciclo++
        }
    }

    fun cambiar(cadenaQuitar: String, cadenaRemplazadora: String): Boolean { // 6
        var bandera: Boolean = false
        if (cadenaHexadecimal.contains(cadenaQuitar)) { // 7
            cadenaHexadecimal = cadenaHexadecimal.replace(cadenaQuitar, cadenaRemplazadora) // 8
            bandera = true
        }
        return bandera
    }

    private fun del(cadenaBorrar:String): Boolean {               // 9
        var s: String = cadenaHexadecimal
        var bandera:Boolean=false
        if (s.contains(cadenaBorrar)){                               // 10
            for (x in cadenaHexadecimal) {                     // 11
                s = s.replace(cadenaBorrar, "")             // 12
            }
            cadenaHexadecimal=s                                      
            bandera=true
        }
        return bandera
    }
} // fin de clase