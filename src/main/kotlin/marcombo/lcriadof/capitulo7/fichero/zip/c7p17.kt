/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 7: FICHEROS
 */
package marcombo.lcriadof.capitulo7.fichero.zip

import marcombo.lcriadof.capitulo7.fichero.recursos
import java.io.File
import java.net.URL


fun main(){
    var url= recursos::class.java.getResource("/excelcsv/").path // [1]
    var fout=ficheroZip(url) // [2]

    fout.comprimir("ficherosexcel.zip","municipio_comunidad_madrid.csv","EDM2018VIAJESmuestra.xls") // [3]


    fout.url=recursos::class.java.getResource("/xml/").path // [4]
    fout.comprimir("ejemplosxml.zip") // [5]

    val fuente = URL("https://github.com/OpenExoplanetCatalogue/open_exoplanet_catalogue/archive/refs/heads/master.zip") // [6]
    val directorioBase=recursos::class.java.getResource("/zip/").path // [7]
    val nombreFicheroOut="exoplanetas.zip"
    val destino = File(directorioBase, nombreFicheroOut)
    destino.writeBytes(fuente.readBytes()) // [8]
}
