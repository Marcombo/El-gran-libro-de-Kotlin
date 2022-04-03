package marcombo.lcriadof.capitulo10
/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 9: CADENAS Y PALABRAS.
 */

fun main() {
// subcadenas

    var texto = "X basta cada día si cada día logramos ese X. Jules Payot"



    var posicion=0
    var ciclo=0
    var cadenaBuscar="X" // pruebe con "día"
    posicion=texto.indexOf(cadenaBuscar,ciclo)
    println("Localizar la subcadena [$cadenaBuscar] en la cadena [$texto]")
    while (posicion>-1){
        if (posicion>-1){
            println("  posición encontrada en: "+posicion)
            ciclo=posicion
        }
        ciclo++
        posicion=texto.indexOf(cadenaBuscar,ciclo)
    }
    println("----------")


    cadenaBuscar="X"
    var cadenaModificada="poco"
    println("Reemplazamos la subcadena [$cadenaBuscar] por la subcadena [$cadenaModificada] sobre la cadena [$texto]")
    val textoModificado = texto.replace(cadenaBuscar, cadenaModificada)
    println("obtenemos: "+textoModificado)
    println("----------")









   // comparaciones
    println("comparaciones de cadenas")
    var t1 = "comprobamos si son iguales"
    var t2 = t1
    var t3 = t1.uppercase();
    println(t3)

    if ( t1.equals(t2) ) {
        println("son iguales")
    }else{
        println("no son iguales")
    }


    if  (t1.compareTo(t2)==0){
        println("son iguales")
    }else{
        println("no son iguales")
    }


    if  (t1.compareTo(t3)==0){
        println("son iguales")
    }else{
        println("no son iguales")
    }

    if  (t1.compareTo(t3, true)==0){  // por defecto es false
        println("son iguales")
    }else{
        println("no son iguales")
    }
    println("----------")


    // métodos para localizar la parte inicial o final de una cadena
    if (textoModificado.startsWith("poco")){
        println("Empieza por [poco]")
    }
    if (textoModificado.endsWith("Jules Payot")){
        println("Empieza por [Jules Payot]")
    }

    // metodo de filtrado

    println(textoModificado.filter{ it -> it.isLetter()})
    println(textoModificado.filter{ it -> it.isLowerCase()})
    println(textoModificado.filter{ it -> it.isUpperCase()})

    val list: MutableList<Int> = (1..10).toMutableList()
    val filteredList: List<Int> = list.filter { it % 2 == 0 }
    println(filteredList)


}