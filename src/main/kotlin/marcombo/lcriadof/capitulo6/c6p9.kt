/*
El gran libro de Kotlin
(para programadores de back end)

Editor: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)
 */

package marcombo.lcriadof.capitulo6

interface ficheros { // 1
    fun usar()
    fun leer():String
    fun <T>agregar(vararg cadena:T):Boolean // 2
    fun borrarFichero():Boolean
    fun borrarTodoElContenido():Boolean
}