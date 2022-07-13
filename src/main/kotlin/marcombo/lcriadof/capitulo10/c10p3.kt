package marcombo.lcriadof.capitulo10
/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 9: CADENAS.
 */

fun main() {
// Concatenación de cadenas

// datos de entrada
    var nombre:String="Pepe"
    val estatura:Double=1.65  // en metros
    val peso:Double=71.0 // en kilogramos

// variables
    var mensaje:String
    val imc:Double=peso/(estatura*estatura)

// primera forma de concatenación
mensaje="El ICM de "+nombre+" es: "+imc
println(mensaje)

// segunda forma de concatenación con identificadores simples
mensaje="El ICM de $nombre es: $imc"
println(mensaje)
// segunda forma de concatenación con expresiones
mensaje="El ICM de ${nombre.uppercase()} es: $imc"
println(mensaje)




// segunda forma de concatenación con expresiones
    //   una plantilla de cadena también puede contener lógica
mensaje = "El ICM de $nombre es: $imc ${if(imc > 25) " (sobrepeso)" else " (peso normal)"}"
println(mensaje)

    //   una plantilla de cadena también puede contener lógica
mensaje = "El ICM de $nombre es: $imc ${if (imc < 18.5) " (bajo peso)" else
    if (imc>18.5 && imc<24.9) " (peso normal)" else if (imc>25.0 && imc<29.9) " (sobrepeso)" else " (obesidad)"}"
println(mensaje)



// tercera forma de concatenación
    mensaje=String.format("El ICM de %s es: %.4f ",nombre,imc)
    println(mensaje)



/*
    val str1 = String.format("%d", 404) // Integer value
    val str2 = String.format("%s", "Mehmet") // String value
    val str3 = String.format("%f", 404.00) // Float value
    val str4 = String.format("%x", 404) // Hexadecimal value
    val str5 = String.format("%c", 'c') // Char value
    println(str1)
    println(str2)
    println(str3)
    println(str4)
    println(str5)



 */



}