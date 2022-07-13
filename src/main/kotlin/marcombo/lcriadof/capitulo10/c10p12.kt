package marcombo.lcriadof.capitulo10
/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 10: CADENAS.
 */
import java.math.BigInteger
import java.security.MessageDigest

fun hash(algoritmo:String,logcaracteres:Int,entrada:String): String {
    val funhash = MessageDigest.getInstance(algoritmo)  // [1]
    val num = BigInteger(1, funhash.digest(entrada.toByteArray()))  // [2]
    return num.toString(16).padStart(logcaracteres, '0')  // [3]
}





fun main() {

    println(" ->Ejemplo con MD5")
    println(hash("MD5",32,"Generando un MD5 de un texto")) //5df9f63916ebf8528697b629022993e8
    println(hash("MD5",32,"Generando un MDS de un texto")) //e14a3ff5b5e67ede599cac94358e1028
    println(hash("MD5",32,""))             //d41d8cd98f00b204e9800998ecf8427e

    println("\n ->Ejemplo con SHA3-256")
    println(hash("SHA3-256",64,"Generando un SHA de un texto")) //aaaddcb5b8f29fbb07b98f2a54289c866f26105d1446ff742c9f904e85b04e74
    println(hash("SHA3-256",64,"Generando un 5HA de un texto")) //574e72d925a56f96e590f808f8e71b0e2471f7a2cf2ad758a30a2948d547356a
    println(hash("SHA3-256",64,""))             //a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a

}