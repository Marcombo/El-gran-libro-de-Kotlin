/*
El gran libro de Kotlin
(para programadores de back end)

Editor: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 7: FICHEROS
 */

package marcombo.lcriadof.capitulo7.fichero.txt

import marcombo.lcriadof.capitulo6.ficheros
import marcombo.lcriadof.capitulo7.fichero.recursos
import java.io.File

fun main(){
    val directorioRaiz:String="/txt/"
    val url:String= recursos::class.java.getResource(directorioRaiz).path //1
    println("url: $url")

    var f=fichTexto(url+"f6.txt") // 2
    f.usar()
    println("abrimos: "+f.usar())
    println("leemos: "+f.leer())

    println(f.contenido)

    println("Escribimos: "+f.agregar("101"))
    println("Escribimos: "+f.agregar(102))
    println("\nleemos: \n"+f.leer())
    f.borrarTodoElContenido()
    println("\nleemos: \n "+f.leer())

    for (x in 1..25){
        f.agregar(x)
    }
    println("\nleemos: \n"+f.leer())

    //f.borrarFichero()

}


// clase para gestionar ficheros de texto
class fichTexto(path:String): ficheros {
   var url:String=path
   var contenido:String=""
   var fichero:File=File( url )
   var isUsable:Boolean=false

    override fun usar(){
       try {
          // println("url: $url")
            if (fichero.exists() and fichero.isFile) { // 1
                isUsable=true // 2
            }
        }
        catch (e: Exception) {
            println(e)
        }
     }



    override fun leer():String{
      contenido = ""
      if (isUsable) {
          try {
              File(url).forEachLine { contenido = contenido + it + "\n" }  //  4
          } catch (e: Exception) {
              println(e)
          }
      }
      return contenido
    }

    override fun <T>agregar(vararg cadena:T):Boolean{ //  5
        var bandera:Boolean=false
        var c:String=""
        if (isUsable) {
            try {
                cadena.iterator().forEach { c = c + it.toString() }
                fichero.appendText(c.toString() + "\n") // 6
                bandera = true
            } catch (e: Exception) {
                bandera = false
            }
        }
        return bandera
    }



    override fun borrarFichero():Boolean{
        var bandera:Boolean=false
        if (isUsable) {
            try {
                if (File(url).exists()) {  // 7
                    File(url).delete()  // 8
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
                if (fichero.exists() and fichero.isFile) {  // 9
                    fichero.writeText("")  // 10
                    bandera = true
                }

            } catch (e: Exception) {
                println(e)
                bandera = false
            }
        }
        return bandera
    }


}