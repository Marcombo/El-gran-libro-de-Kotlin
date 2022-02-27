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

fun main(){
    var listaEstudiantes= arrayOf(Estudiante("Paco", 5)
        ,Estudiante("Luis", 5),Estudiante("Marta", 7)) // [1]
    //println(listaEstudiantes.joinToString())

    //val json = Gson().toJson(listaEstudiantes) // Json sin tabular directo en una linea
    val gson = GsonBuilder().setPrettyPrinting().create() // [2] definimos una estructura de JSON tabulado
    val json = gson.toJson(listaEstudiantes) // [3] Creamos JSON
    println(json.toString()) // [4] mostramos por pantalla el JSON resultnte
    File("/tmp/kotlin/f4.json").writeText(json) // [5] Guardamos el JSON en un fichro local

    // lectura
    val listaEstudiantesEntrada: Array<Estudiante> = gson.fromJson(json, object : TypeToken<Array<Estudiante?>?>() {}.getType()) // [6]
    listaEstudiantesEntrada.forEach(  { it: Estudiante? -> println(it?.nombre+" tiene una nota de "+it?.nota) }) // [7]
}

data class Estudiante (
        var nombre: String? = null,
        var nota: Int? = null) {
}

