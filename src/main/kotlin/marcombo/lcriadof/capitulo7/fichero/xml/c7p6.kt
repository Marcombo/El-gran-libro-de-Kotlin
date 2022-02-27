/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 7: FICHEROS
 */

package marcombo.lcriadof.capitulo7.fichero.xml

import marcombo.lcriadof.capitulo6.ficheros
import marcombo.lcriadof.capitulo7.fichero.recursos
import marcombo.lcriadof.capitulo7.fichero.txt.fichTexto
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.io.File
import java.io.StringReader
import java.net.URL


fun main(){
    val directorioRaiz:String="/xml/"
    val url:String= recursos::class.java.getResource(directorioRaiz).path // 1
    println("url: $url")


    // este codigo es para procesar ficheros XML descargados desde github
    val fuente = URL("https://raw.githubusercontent.com/OpenExoplanetCatalogue/" +
            "open_exoplanet_catalogue/master/systems_kepler/KOI-0316.xml")  // 2
    val destino = File(url, "KOI-0316.xml") // 3
    destino.writeBytes(fuente.readBytes()) // 4
    // fin del proceso de descarga

    val ficheroXsd=url+"oec.xsd"   // 5
    val ficheroXml=url+"KOI-0316.xml" // 6, pruebe también con "Alpha Centauri.xml" y con "KOI-0316.xml"
    val fxml=fichXML(ficheroXml,ficheroXsd,"planet",7,true) // 4
    fxml.usar()
    fxml.leer()
    println(fxml.contenido)
}



// clase para gestionar ficheros de properties
class fichXML(pathXml:String, pathXsd:String, var finTag:String, var dimension:Int=7, var incluirAtributosYNombresRepetidos:Boolean=false): ficheros {
    var url:String=pathXml
    var url2:String=pathXsd
    var contenido:String=""
    var fichero: File = File(url)
    var ficheroXsd: File = File(url2)

    val aPropiedades= Array<MutableMap<String, String>>(dimension,{i->mutableMapOf() })
    //val p = Properties()
    val oParsear=ParsearXMLxsd
    var isUsable:Boolean=false


    override fun usar(){
        try {
            if (fichero.exists() and fichero.isFile and
                    ficheroXsd.exists() and ficheroXsd.isFile and
                    oParsear.isBienFormado(url,url2) ) {
                isUsable=true
            }
        }
        catch (e: Exception) {
            println(e)
        }

    }


/// por aqui
/*
   var propiedades: MutableMap<String, String> = mutableMapOf() // inicializamos un Map mutable
    var conjuntoMutable = mutableSetOf< MutableMap<String, String> >() // inicializamos un conjunto mutable

 */
    override fun leer():String{
        try {
            var f= fichTexto(url)
            f.usar()
            f.leer()
            val factory = XmlPullParserFactory.newInstance()
            factory.isNamespaceAware = true
            val xpp = factory.newPullParser()
            xpp.setInput(StringReader(f.contenido))  // flujo que alimenta el parser
            println(f.contenido)
            var eventType = xpp.eventType
            var bandera:Boolean=false
            var elementoArray=0
            var c:Int=0
            var c2:Int=0


            try {
                var clave:String=""
                var clave0:String=""
                var newclave:String=""
                var valor:String=""
                while (eventType != XmlPullParser.END_DOCUMENT) {
                    if (eventType == XmlPullParser.START_DOCUMENT) {
                        //println("Inicio del documento")
                    } else if (eventType == XmlPullParser.START_TAG) {

                        clave=xpp.name
                        if (xpp.name==finTag){
                            bandera=true
                            aPropiedades[elementoArray].put(xpp.name,elementoArray.toString())
                            println("Inicio TAG: " + xpp.name)
                            println("bandera $bandera" )
                       }
                       if (xpp.attributeCount>0 && incluirAtributosYNombresRepetidos && bandera) {
                            c=0
                            c2=0
                            while (c!=xpp.attributeCount){
                               // println("    atributo: " + xpp.getAttributeName(c))
                               // println("    atributo valor: " + xpp.getAttributeValue(c))
                                clave0=xpp.getAttributeName(c)
                                newclave=clave0
                                while (aPropiedades[elementoArray].contains(newclave) ){
                                    newclave=clave0+c2.toString()
                                    c2++
                                }
                                aPropiedades[elementoArray].put(newclave,xpp.getAttributeValue(c))
                                c++
                            }
                       }





                    } else if (eventType == XmlPullParser.END_TAG) {

                        if (xpp.name==finTag){
                             bandera=false
                             elementoArray++
                            println("elementoArray $elementoArray" )
                            println("Fin TAG: " + xpp.name)
                            println("bandera $bandera" )
                        }
                    } else if (eventType == XmlPullParser.TEXT) {
                        valor=xpp.text

                        if (bandera){
                            if (valor.trim()!="" ){
                                println("clave $clave, valor $valor,   bandera $bandera,    elementoArray $elementoArray" )
                                c=0
                                var newclave=clave
                                while (aPropiedades[elementoArray].contains(newclave) && incluirAtributosYNombresRepetidos){ // si la clave  existe se busca nueva
                                    newclave=clave+c.toString()
                                    c++
                                }
                                aPropiedades[elementoArray].put(newclave,valor)
                                println("newclave $newclave, valor $valor,  elementoArray $elementoArray" )

                            }
                        }
                    }
                    eventType = xpp.next()
                }
                println("Fin del documento")
            } catch (e: Exception) {
                println("XML mal formado")
            }

            contenido=aPropiedades.joinToString()

        }catch (e: Exception){
            println(e)
        }
        return contenido
    }

    override fun <T>agregar(vararg cadena:T):Boolean{ //  no permitimos añadir
          return false
    }



    override fun borrarFichero():Boolean{
        var bandera:Boolean=false
        try {
            if (File(url).exists()) {
                File(url).delete()
                bandera=true
            }
        }
        catch (e: Exception) {
            bandera=false
        }
        return bandera
    }

    override fun borrarTodoElContenido():Boolean{
        var bandera:Boolean=false
        try {
            if (fichero.exists() and fichero.isFile) {
                fichero.writeText("")
                bandera=true
            }

        }
        catch (e: Exception) {
            println(e)
            bandera=false
        }
        return bandera
    }



}