/*
El gran libro de Kotlin
(para programadores de back end)

Editor: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 7: FICHEROS
 */

package marcombo.lcriadof.capitulo7.fichero.rdf

import marcombo.lcriadof.capitulo7.fichero.recursos
import org.apache.jena.rdf.model.Model
import org.apache.jena.rdf.model.ModelFactory
import org.apache.jena.rdf.model.Statement
import org.apache.jena.vocabulary.VCARD
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream


fun main(){
    // parte 1
    // CREAMOS UN MODELO Y LO VOLCAMOS A DISCO
    //******************************************


    val model = ModelFactory.createDefaultModel()  // [1]

    val personURI = "http://www.luis.criado.online"
    val luisCriado = model.createResource(personURI) // [2]

    val nombre:String="Luis"
    luisCriado.addProperty(VCARD.FN, nombre) // [3]

    val nombreComleto:String="luis.criado.fernandez@gmail.com"
    luisCriado.addProperty(VCARD.EMAIL, nombreComleto) // [4]

    val directorioRaiz:String="/rdf/"
    var url:String= recursos::class.java.getResource(directorioRaiz).path  // [5]
    println("url: $url")  // [6]

// --- escribimos
    println("\n\nEscribimos")
    var salida=File(url+"modelo2.rdf")
    model.write(salida.outputStream()) // [7]
    println(model.toString())
    model.write(FileOutputStream(url+"modelo2otraforma.rdf")); // [8]
    println("------------------")


    // parte 2
// ---- IMPORTAMOS MODELOS DE DISCO A MEMORIA: leemos, hacemos el proceso inverso
// ********************************************
    println("\n\nLeemos:")
    val model2 = ModelFactory.createDefaultModel() // [9]
       model2.read(FileInputStream( url+"modelo2.rdf"), ""); // [10]


    var stmt:Statement
    var stmtbak:Statement
    while( true  ) {
        stmt = model2.listStatements().nextStatement() // [11]
        println("sujeto: " + stmt.getSubject().toString()) // [12]
        println("predicado: " + stmt.getPredicate().toString()) //  [13]
        println("objeto: " + stmt.getObject().toString()) // [14]
        stmtbak=stmt
        if (stmt.getSubject().toString().equals( stmtbak.getSubject().toString()) and
                stmt.getPredicate().toString().equals( stmtbak.getPredicate().toString()) and
                stmt.getObject().toString().equals( stmtbak.getObject().toString())  ){
            break
        }
    }
    println("------------------")



    // parte 3
    // unimos dos modelos
    //************************
    val modeloA = ModelFactory.createDefaultModel() // [15]
    val modeloB = ModelFactory.createDefaultModel() // [16]

    // leemos ficheros RDF/XML
    modeloA.read(FileInputStream(url+"modelo1.rdf"), ""); // [17]
    modeloB.read(FileInputStream(url+"modelo2.rdf"), ""); // [18]
    // Unimos dos modelos
    val modeloUnido: Model = modeloA.union(modeloB) // [19]
    modeloUnido.write(FileOutputStream(url+"modeloUnido.rdf"), "RDF/XML-ABBREV"); // [20]
    println("------------------")


}