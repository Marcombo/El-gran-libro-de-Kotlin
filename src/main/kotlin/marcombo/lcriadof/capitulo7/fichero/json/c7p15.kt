/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 7: FICHEROS
 */

package marcombo.lcriadof.capitulo7.fichero.json

import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.io.File
import java.net.URL

fun main(){

    // limpiamos el fichero que hay en la Web y lo salvamos a disco local
    val ficheroMunicipiosJSON
    ="https://datos.comunidad.madrid/catalogo/dataset/032474a0-bf11-4465-bb92-392052962866/resource/301aed82-339b-4005-ab20-06db41ee7017/download/municipio_comunidad_madrid.json"
    var fichIn1= URL(ficheroMunicipiosJSON).readText() //[1]
    val fichIn2 = "[\n"+fichIn1.toString().subSequence(14, fichIn1.length-3)+"\n]" // [2]
    File("/tmp/kotlin/municipios.json").writeText(fichIn2.toString(), Charsets.UTF_8) // [3]

    // leemos el fichero del disco local y lo cargamos en memoria
    var contenido:String=""
    try {
        var lines: List<String> = File("/tmp/kotlin/municipios.json").readLines() // [4]
        lines.forEach{it -> contenido=contenido+it   } // [5]
    }catch(e:Exception){
        e.printStackTrace()
    }finally {
        println(contenido) // [6]
        println("--------  JSON leido")
    }

    val gson = GsonBuilder().setPrettyPrinting().create() // [7]

    // lectura del fichero JSON que tenemos en memoria en la variable contenido de tipo String
    val listaMunicipiosEntrada: Array<Municipios> =
        gson.fromJson(contenido, object : TypeToken<Array<Municipios>>() {}.getType()) // [8]

    listaMunicipiosEntrada.forEach({ it: Municipios? -> println(it?.municipio_nombre +
            " tiene una densidad por km2 de "+it?.densidad_por_km2) }) // [9]


}


