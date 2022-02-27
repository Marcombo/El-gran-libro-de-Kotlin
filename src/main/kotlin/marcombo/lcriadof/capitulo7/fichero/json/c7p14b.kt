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


//ejemplo inspirado en un post de (mkyong)  https://mkyong.com/java/how-to-parse-json-with-gson/

fun main() {
    var listaMunicipios = arrayOf(
        Municipios("001", 3.019213174748399, "280014", "Sierra Norte", "Acebeda (La)", "06", 21.86),
        Municipios("002", 225.0, "280029", "Este Metropolitano", "Ajalvir", "03", 19.8)
    ) // [1]


    //val json = Gson().toJson(listaEstudiantes) // Json sin tabular directo en una linea
    val gson = GsonBuilder().setPrettyPrinting().create() // [2]
    val json = gson.toJson(listaMunicipios) // [3]
    println(json.toString()) // [4]
    File("/tmp/kotlin/prueba2.json").writeText(json) // [5]



    // lectura
    val listaMunicipiosEntrada: Array<Municipios> =
        gson.fromJson(json, object : TypeToken<Array<Municipios>>() {}.getType()) // [6]
    listaMunicipiosEntrada.forEach({ it: Municipios? -> println(it?.municipio_nombre + " tiene una densidad por km2 de "+it?.densidad_por_km2) }) // [7]

}

    data class Municipios (
    var municipio_codigo: String? = null,
    var densidad_por_km2: Double? = 0.0,
    var municipio_codigo_ine: String? = null,
    var nuts4_nombre: String? = null,
    var municipio_nombre: String? = null,
    var nuts4_codigo: String? = null,
    var superficie_km2: Double? = 0.0) {
    }
