/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 7: FICHEROS
 */

package marcombo.lcriadof.capitulo7.fichero.xml

import marcombo.lcriadof.capitulo7.fichero.recursos
import org.xml.sax.ErrorHandler
import org.xml.sax.SAXException
import org.xml.sax.SAXParseException
import java.io.File
import kotlin.jvm.JvmStatic
import kotlin.Throws
import java.lang.Exception
import javax.xml.XMLConstants
import javax.xml.transform.stream.StreamSource
import javax.xml.validation.SchemaFactory
// codigo adaptado de https://www.jc-mouse.net/java/validar-documentos-xml-con-esquema-xsd

object ParsearXMLxsd {
    @JvmStatic
    fun isBienFormado(pathCompletoFicheroXML:String,pathCompletoFicheroXSD:String):Boolean {
        var bandera:Boolean=false
        try {
            val factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI) // 1
            val schema = factory.newSchema(File(pathCompletoFicheroXSD))  // 2
            // definiendolo como un recurso interno en el proyecto
            //val schema = factory.newSchema(ParsearXMLxsd::class.java.getResource(pathCompletoFicheroXSD))

            val validatorXML = schema.newValidator() // 3

            validatorXML.errorHandler = object : ErrorHandler {  // 4
                @Throws(SAXException::class)
                override fun warning(exception: SAXParseException) {detallarError(exception) }

                @Throws(SAXException::class)
                override fun error(exception: SAXParseException) { detallarError(exception) }

                @Throws(SAXException::class)
                override fun fatalError(exception: SAXParseException) { detallarError(exception) }

                private fun detallarError(exception: SAXParseException) {
                    println("Linea: "
                            + String.format("%4s|", exception.lineNumber) + exception.message)
                    bandera=false
                }
            }
            // definiendolo como un recurso interno en el proyecto
            //validatorXML.validate(StreamSource(ParsearXMLxsd::class.java.getResourceAsStream(pathCompletoFicheroXML)))
            validatorXML.validate(StreamSource(File(pathCompletoFicheroXML))) // 5

            bandera=true
        } catch (e: Exception) {
            println("Falta algún fichero")
            bandera=false
        }
        return bandera

    }
}

fun main(){

    val directorioRaiz:String="/xml/"
    val url:String= recursos::class.java.getResource(directorioRaiz).path
       println(url)

    val oParsear=ParsearXMLxsd // objeto parseador

    var ficheroXml=url+"B3h_TRF_v1.0.xml"
    var ficheroXsd=url+"B3h_TRF_v1.0.xsd"




    println(oParsear.isBienFormado(ficheroXml,ficheroXsd))

    ficheroXsd=url+"oec.xsd"
    ficheroXml=url+"Alpha Centauri.xml"
    println(oParsear.isBienFormado(ficheroXml,ficheroXsd))

    ficheroXml=url+"KOI-0316.xml"
    println(oParsear.isBienFormado(ficheroXml,ficheroXsd))
}