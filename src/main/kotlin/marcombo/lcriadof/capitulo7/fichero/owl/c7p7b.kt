/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 7: FICHEROS
 */

package marcombo.lcriadof.capitulo7.fichero.owl


import marcombo.lcriadof.capitulo7.fichero.recursos
import org.apache.jena.rdf.model.ModelFactory
import org.apache.jena.rdf.model.StmtIterator
import java.io.FileInputStream


fun main(){

// leeemos un fichero que contiene 10.000 instancias en OWL y las tratamos como tripletas
// *****************************************************************************************
    val modeloOWL = ModelFactory.createDefaultModel() // [1]
    var url= recursos::class.java.getResource("/owl/").path  // [2]
    modeloOWL.read(FileInputStream(url+"val1.owl"), "");
// ---- leemos
    println("\n\nLeemos modelo:")
    val sIter: StmtIterator = modeloOWL.listStatements() // [3]
    var sujeto:String=""
    var sujetoBak:String=""
    var ciclo=0
    for (i in sIter) { // [4]

        sujeto=i.getSubject().toString()
        if (!sujeto.equals(sujetoBak)){ // [5]
            ciclo++
            println("**********************************************")
            println("número de instancia: "+ciclo)
            println("    tripletas que contiene: ")
        }
        println("sujeto: " +i.getSubject().toString() ) // [6]
        println("predicado: " + i.getPredicate().toString()) // [7]
        println("objeto: " +i.getObject().toString() ) // [8]
        println("------------ x -------------")
        sujetoBak=i.getSubject().toString()
    }
    println("------------------")
}