/*
El gran libro de Kotlin
(para programadores de back end)

Editor: Marcombo (https://www.marcombo.com/)
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
    var book = Book() // [1] // Creamos un libro epub
    book.metadata.addTitle("fragmento de SEGUNDOS para probar") // [2] Añadimos el título
    book.metadata.addAuthor(Author("Luis Criado", "Autor")) // [3] Añadimos el nombre del autor

     // Set cover image
    book.setCoverImage( Resource(recursos::class.java.getResourceAsStream("/libroSegundos/cover.jpg"), "cover.jpg") );


    book.addSection("Capítulo 1", Resource(recursos::class.java.getResourceAsStream("/libroSegundos/cap1.html"), "capitulo1.html")) // [4] Añadimos el capitulo 1 localizado en \recurces\book1
    book.resources.add(Resource(recursos::class.java.getResourceAsStream("/libroSegundos/page_styles.css"), "book1.css")) // [5] Incorporamos el fichero de estilo CSS
    book.resources.add(Resource(recursos::class.java.getResourceAsStream("/libroSegundos/stylesheet.css"), "book1.css")) // [5] Incorporamos el fichero de estilo CSS

    book.addSection("Capítulo 2", Resource(recursos::class.java.getResourceAsStream("/libroSegundos/cap2.html"), "capitulo2.html")) // [4] Añadimos el capitulo 1 localizado en \recurces\book1

// Add Chapter 37
     book.addSection("Capítulo 37", Resource(recursos::class.java.getResourceAsStream("/libroSegundos/cap37.html"), "capitulo37.html"))
// Add image used by Chapter 37
     book.resources.add(Resource(recursos::class.java.getResourceAsStream("/libroSegundos/image1.jpeg"), "image1.jpeg"))


    val epubWriter = EpubWriter() // [10] creamos el objeto para escribir en disco local
    epubWriter.write(book, FileOutputStream("prueba5.epub")) // [11] escribimos el epub en un fichero
 } catch (e: Exception) {
    e.printStackTrace()
 }
} // fin de main()
