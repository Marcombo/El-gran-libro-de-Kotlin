/*
El gran libro de Kotlin
(para programadores de back end)

Editor: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 7: FICHEROS
 */

package marcombo.lcriadof.capitulo7.fichero.owl

import marcombo.lcriadof.capitulo7.fichero.recursos
import org.apache.jena.ontology.OntModel
import org.apache.jena.ontology.OntModelSpec
import org.apache.jena.rdf.model.ModelFactory
import org.apache.jena.vocabulary.XSD
import java.io.File


// c7p8.kt - poblar una ontología en OWL
// ejemplo extraido de https://rekkeb.wordpress.com/2010/05/10/gestiona-ontologias-con-jena/

fun main(){
    val model: OntModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM) // [1]
    val NS = "atrevete.kotlin.animales"  // [2]
    model.setNsPrefix(NS, "http://www.owl-ontologies.com/OntologyAnimals.owl")

    // [3]
    val animales = model.createClass("$NS:Animales")
    val vertebrados = model.createClass("$NS:Vertebrados")
    val invertebrados = model.createClass("$NS:Invertebrados")
    vertebrados.setDisjointWith(invertebrados)
    animales.addSubClass(vertebrados)
    animales.addSubClass(invertebrados)

    // [4]
    val peso = model.createDatatypeProperty("$NS:Peso")
    peso.addDomain(animales) //Clase a la que pertenece
    peso.addRange(XSD.xint) //Tipo de la propiedad
    peso.convertToFunctionalProperty() //Para que solo acepte un valor.

    // [5]
    val leon = model.createIndividual("$NS:Leon", vertebrados)
    leon.setPropertyValue(peso, model.createTypedLiteral(250))
    val leopardo = model.createIndividual("$NS:Leopardo", vertebrados)
    leopardo.setPropertyValue(peso, model.createTypedLiteral(200))
    val pulpo = model.createIndividual("$NS:Pulpo", invertebrados)
    pulpo.setPropertyValue(peso, model.createTypedLiteral(10))
    val sepia = model.createIndividual("$NS:Sepia", invertebrados)
    sepia.setPropertyValue(peso, model.createTypedLiteral(1))

    // [6]
    var url2= recursos::class.java.getResource("/owl/").path  // [7]
    println(url2)
    var salida=File(url2+"animales.owl")
    model.write(salida.outputStream()) // [8]


    println("url: $url2")

}