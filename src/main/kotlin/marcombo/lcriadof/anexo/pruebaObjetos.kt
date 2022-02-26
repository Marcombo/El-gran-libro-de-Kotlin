/*
El gran libro de Kotlin
(para programadores de back end)

Editor: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)
 */

package marcombo.lcriadof.anexo

object Singleton {
    var contador:Int=0
    init{ println("objeto creado")  }
}

fun main(){

    var o= Singleton
    o.contador=5
    println(o.contador)
    var o2= Singleton
    println(o2.contador)
    o.contador=6
    var o3= Singleton
    println(o3.contador)

}