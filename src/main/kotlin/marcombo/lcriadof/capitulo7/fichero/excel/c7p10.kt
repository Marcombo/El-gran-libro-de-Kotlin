/*
El gran libro de Kotlin
(para programadores de back end)

Editor: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 7: FICHEROS
 */

package marcombo.lcriadof.capitulo7.fichero.excel

import com.opencsv.CSVReader
import marcombo.lcriadof.capitulo7.fichero.recursos
import java.io.File
import java.io.FileReader

fun main(){

    var url= recursos::class.java.getResource("/excelcsv/").path
    var entrada= File(url+"201612_detalle.csv")
    if (entrada.exists()) { // [1]
        val reader = CSVReader(FileReader(entrada.getAbsolutePath()), ';') // [2]
        val fichcsv: List<Array<String?>> = reader.readAll() // [3]
        reader.close() // [4]

        // puebas
        /*
        println(fichcsv.size)
        println(fichcsv.get(0).size)
        println(fichcsv.get(1).joinToString())
        println(fichcsv.get(1).get(0))
         */

        //[5]
        fichcsv.forEach( { d: Array<String?> -> d.forEach { f: String? -> println(f) }
                      println("----- X ------" ) // nueva linea del CSV
        } )
    }
}