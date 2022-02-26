/*
El gran libro de Kotlin
(para programadores de back end)

Editor: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)
 */

package marcombo.lcriadof.capitulo5

fun main(){
    // programa c5p9.kt, función infix  extendida de String
    infix fun String.delString(cadena: String):String { //1
        var s:String=this                               // 2
        s=s.replace(cadena,"")                  // 3
        return s
    }
    var nombre:String="Luis Criado Fernández"     //4
    println(nombre)                               // 5
    nombre=nombre delString "Luis"   // 6
    println(nombre)                  // 7
}