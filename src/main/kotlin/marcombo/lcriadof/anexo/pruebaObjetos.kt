/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

ANEXO
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