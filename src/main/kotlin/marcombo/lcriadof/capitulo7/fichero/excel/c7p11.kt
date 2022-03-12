/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 7: FICHEROS
 */

package marcombo.lcriadof.capitulo7.fichero.excel

import marcombo.lcriadof.capitulo7.fichero.recursos
import org.apache.poi.hssf.usermodel.HSSFRow
import org.apache.poi.hssf.usermodel.HSSFSheet
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import java.io.File
import java.io.FileInputStream

fun main(){
    var url= recursos::class.java.getResource("/excelcsv/").path

    // este fichero es una muestra de
    //  https://datos.crtm.es/documents/crtm::edm2018viajes/about
    var entrada= File(url+"EDM2018VIAJESmuestra.xls")
    if (entrada.exists()) { // [1]
        val wb = HSSFWorkbook(FileInputStream(entrada.getAbsolutePath())) // [2]
        val sheet: HSSFSheet = wb.getSheetAt(0) // [3]
        val filas: Int = sheet.getLastRowNum() // [4]
        for (i in 1..filas) {
            val datosFila: HSSFRow = sheet.getRow(i) // [5]
            println("campo1: "+datosFila.getCell(0)+", campo2: "+datosFila.getCell(1)+", campo3: "+datosFila.getCell(2)) // [6]
        } // fin de for
    } // fin de if
}

