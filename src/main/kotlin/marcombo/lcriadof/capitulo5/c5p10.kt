/*
El gran libro de Kotlin
(para programadores de back end)

Editor: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)
 */

package marcombo.lcriadof.capitulo5

fun main(){
    // programa c5p10.kt, función extendida
    fun String.delSpace():String {               // 1
        var s:String=this                        // 2
        for (x in this){
            s=s.replace("  "," ") // 3
        }
        return s
    }
    var nombre:String="Luis     Criado    Fernández   Abad   "                // 4
    println("La cadena [$nombre] tiene una longitud de "+nombre.length+" caracteres")  // 5
    nombre=nombre.delSpace()                                                           // 6
    println(" y .... aplicando el método delSapce()")
    println("La cadena [$nombre] tiene una longitud de "+nombre.length+" caracteres")  // 7
}