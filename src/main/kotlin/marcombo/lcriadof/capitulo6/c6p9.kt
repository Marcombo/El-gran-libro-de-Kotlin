/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 6: CLASES
 */

package marcombo.lcriadof.capitulo6

interface ficheros { // 1
    fun usar()
    fun leer():String
    fun <T>agregar(vararg cadena:T):Boolean // 2
    fun borrarFichero():Boolean
    fun borrarTodoElContenido():Boolean
}