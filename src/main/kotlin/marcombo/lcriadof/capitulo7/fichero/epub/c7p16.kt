/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 7: FICHEROS
 */

package marcombo.lcriadof.capitulo7.fichero.epub

import marcombo.lcriadof.capitulo7.fichero.recursos
import nl.siegmann.epublib.domain.Author
import nl.siegmann.epublib.domain.Book
import nl.siegmann.epublib.domain.Resource
import nl.siegmann.epublib.epub.EpubWriter
import java.io.FileOutputStream

fun main(){
 try {
    var book = Book() // [1]
    book.metadata.addTitle("fragmento de SEGUNDOS para probar") // [2]
    book.metadata.addAuthor(Author("Luis Criado", "Autor")) // [3]

    book.setCoverImage( Resource(recursos::class.java.getResourceAsStream("/libroSegundos/cover.jpg"), "cover.jpg") ); // [4]

    Resource(recursos::class.java.getResourceAsStream("/libroSegundos/titlepage.xhtml"), "titlepage.html") // [5]
    book.addSection("Capítulo 1", Resource(recursos::class.java.getResourceAsStream("/libroSegundos/cap1.html"), "capitulo1.html")) // [6]
    book.resources.add(Resource(recursos::class.java.getResourceAsStream("/libroSegundos/page_styles.css"), "book1.css")) // [7]
    book.resources.add(Resource(recursos::class.java.getResourceAsStream("/libroSegundos/stylesheet.css"), "book1.css")) // [8]

    book.addSection("Capítulo 2", Resource(recursos::class.java.getResourceAsStream("/libroSegundos/cap2.html"), "capitulo2.html")) // [9]

// Add Chapter 37
     book.addSection("Capítulo 37", Resource(recursos::class.java.getResourceAsStream("/libroSegundos/cap37.html"), "capitulo37.html")) // [10]
// Add image used by Chapter 37
     book.resources.add(Resource(recursos::class.java.getResourceAsStream("/libroSegundos/image1.jpeg"), "image1.jpeg")) // [11]


    val epubWriter = EpubWriter() // [12]
    epubWriter.write(book, FileOutputStream(recursos::class.java.getResource("/libroSegundos/").path+"segundos_muestra.epub")) // [13]
 } catch (e: Exception) {
    e.printStackTrace()
 }
} // fin de main()
