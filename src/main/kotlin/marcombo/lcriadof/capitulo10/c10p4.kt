package marcombo.lcriadof.capitulo10
/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 9: CADENAS Y PALABRAS.
 */

fun main() {
// conversores

    // Obtener el código ascii
    println("<<<< codigo ASCII >>>>>")
    // desde un Char
    var cad1:Char='A'
    var valor_ascii=cad1.code
    println("El código ASCII de [$cad1] es $valor_ascii")

    // desde un String
    var cad2:String="Hola Mundo!!!"
    println(cad2[2].toChar().code)
    println("El código ASCII de [$cad2] es letra a letra:")
    cad2.forEach { caracter -> println("   ASCII de [$caracter] es "+caracter.code) }


    println("-----------------" )

    // de Int a ASCII
    println("\nAl reves, desde números a letras" )
    var valorDec=100
    println("El número  [$valorDec] interpretado como ASCII nos da la letra [${valorDec.toChar()}]")

    var listNumeros = listOf(72,111,108,97)
    listNumeros.forEach { digito ->
        println("El número  [$digito] interpretado como ASCII nos da la letra [${digito.toChar()}]")}

    var mensaje:String=""
    listNumeros.forEach { digito -> mensaje=mensaje+digito.toChar() } // en un Char
    println( "Valor recuperado desde el código ASCII en Int a un String: "+mensaje )
    println("-----------------" )



    println("<<<< HEXADECIMAL >>>>>")
    // de Int a hexadecimal
    val num = 4316
    val hex = Integer.toHexString(num)
    println("El número $num en hexadecimal es [$hex]")


    // de Hexadecimal a Int
    val hex2 = "7FFFFFFF"
    val num2: Int = hex2.toInt(16)
    println("El número hexadecimal $hex2 en decimal es [$num2]")

    val hex4 = "7FFFFFFFFFFFFFF"
    val decimal4 = hex4.toLong(16)
    println("El número hexadecimal $hex4 en decimal es [$decimal4]")



    println("<<<< BINARIO >>>>>")
    // de Int a hexadecimal
    val num4 = 4316
    val bin = Integer.toBinaryString(num4)
    println("El número $num en binario es [$bin]")

    // de Binario a Int
    val bin2 = "0100"
    val num3: Int = bin2.toInt(2)
    println("El número binario $bin2 en decimal es [$num3]")

}