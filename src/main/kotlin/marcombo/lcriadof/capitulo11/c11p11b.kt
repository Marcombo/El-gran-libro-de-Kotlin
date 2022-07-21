package marcombo.lcriadof.capitulo11

/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 11: CONCURRENCIA
 */
// funciones que se utilizaran desde c11p11.kt y no son de suspensión

fun repetidos(texto:String,encontrar:String):Int{
    var contador=0
    var posicion=0
    var ciclo=0
    posicion=texto.indexOf(encontrar,ciclo)
    while (posicion>-1){
        if (posicion>-1){ // posición encontrada
            ciclo=posicion
            contador++
        }
        ciclo++
        posicion=texto.indexOf(encontrar,ciclo)
    }
    return contador
}

fun nucleotido(tipo:Char,lin:String):Double{
    var contador=0.0
    contador = repetidos(lin,tipo.uppercase().toString() ) + repetidos(lin, tipo.lowercase().toString() ) + 0.0
    if (contador==16569.0){
        println("resultado $contador")
    }
    return contador
}

