/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 7: FICHEROS
 */

package marcombo.lcriadof.capitulo7.fichero.json
import org.json.JSONObject


// crear un JSON desde código kotlin
fun main() {
    val fJson = JSONObject() // [1]

    // [2]
    fJson.put("objeto", "exoplaneta")
    fJson.put("nombre", "Proxima Centauri b")
    fJson.put("masa",0.003691) // respecto la Tierra
    fJson.put("año descubrimiento", 2016)
    fJson.put("estrella sobre la que orbita", "Proxima Centauri")
    fJson.put("distancia", 4.246) // en años luz


    val jsonPrettyPrintString = fJson.toString(2) // [3]
    println(jsonPrettyPrintString);


    // [4] acceso a elemntos de JSON
    println("El "+fJson.get("objeto")+" ["+fJson.get("nombre")+"] se encuentra a una distancia de "+fJson.get("distancia")+" años luz.")



}