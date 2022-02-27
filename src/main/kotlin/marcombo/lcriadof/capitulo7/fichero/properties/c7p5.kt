/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 7: FICHEROS
 */

package marcombo.lcriadof.capitulo7.fichero.properties

import marcombo.lcriadof.capitulo6.ficheros
import java.io.File
import java.io.FileOutputStream
import java.io.FileReader
import java.util.*




fun main(){
    val directorioRaiz:String="/tmp/kotlin/"+"oracleBITver2.properties"

    val fp=fichProperties(directorioRaiz)

    fp.usar()
    fp.leer()
    fp.agregar("prueba.prueba","hola mundo")
    fp.leer()
    println(fp.contenido)
    println(fp.get("fichero.out"))

}




// clase para gestionar ficheros de properties
class fichProperties(path:String): ficheros {
    var url:String=path
    var contenido:String=""
    var fichero: File = File(url)
    var propiedades: MutableMap<String, String> = mutableMapOf() // 1
    val p = Properties()
    var isUsable:Boolean=false

    override fun usar(){
        try {
            if (fichero.exists() and fichero.isFile) { // 2
                p.load(FileReader(url)) // 3
                isUsable=true // 4
            }
        }
        catch (e: Exception) {
            println(e)
        }
     }


    override fun leer():String{
       if (isUsable) {
           try {
               val keys: Enumeration<Any> = p.keys() //5
               while (keys.hasMoreElements()) {
                   val key = keys.nextElement()
                   // println(key.toString() + " = " + p.get(key))
                   propiedades.put(key.toString(), p.get(key) as String) // 6
               }
               contenido = propiedades.toString()

           } catch (e: Exception) {
               println(e)
           }
       }
        return contenido
    }

    override fun <T>agregar(vararg cadena:T):Boolean{
        var bandera: Boolean = false
        if (isUsable) {
            try {
                p.put(cadena.get(0), cadena.get(1)) //  7 /
                p.store(FileOutputStream(url), "") // 8
                bandera = true
            } catch (e: Exception) {
                bandera = false
            }
        }
        return bandera
    }



    override fun borrarFichero():Boolean{
        var bandera: Boolean = false
        if (isUsable) {
             try {
                if (File(url).exists()) {
                    File(url).delete()
                    bandera = true
                }
            } catch (e: Exception) {
                bandera = false
            }
        }
        return bandera
    }

    override fun borrarTodoElContenido():Boolean{
        var bandera:Boolean=false
        if (isUsable) {
            try {
                if (fichero.exists() and fichero.isFile) {
                    fichero.writeText("")
                    bandera = true
                }

            } catch (e: Exception) {
                println(e)
                bandera = false
            }
        }
        return bandera
    }


    fun get(nombrePropiedad:String):String{
        if (isUsable) {
            return propiedades.get(nombrePropiedad).toString()
        }else{
            return ""
        }
    }


}