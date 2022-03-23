/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 7: FICHEROS
 */
package marcombo.lcriadof.capitulo7.fichero.zip

import marcombo.lcriadof.capitulo7.fichero.recursos


fun main() {
    var url= recursos::class.java.getResource("/zip/").path
    var fout=ficheroZip(url)
    // fout.listaFicherosComprimidos() // [1]
    fout.descomprimir("TOI-257.xml") // [2]
}

