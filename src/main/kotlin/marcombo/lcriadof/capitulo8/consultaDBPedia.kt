/*
El gran libro de Kotlin
(para programadores de back end)

Editor: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 8: BASES DE DATOS
 */

package marcombo.lcriadof.capitulo8

import org.apache.jena.query.QueryExecution
import org.apache.jena.query.ResultSetFormatter

fun main(){
    val consulta = "PREFIX dbpedia-owl: <http://dbpedia.org/ontology/> " +  // -- lista lenguajes
            "PREFIX esdbpr: <http://es.dbpedia.org/resource/> " +
            "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
            "   SELECT ?lenguaje " +
            "    WHERE{ " +
            "      ?lenguaje rdf:type dbpedia-owl:ProgrammingLanguage ." +
            "    }" +
            " ORDER BY ASC(?lenguaje)"

    val qexec: QueryExecution = QueryExecution.service("http://dbpedia.org/sparql").query(consulta).build() // [1]
    val results = qexec.execSelect() // [2]
    ResultSetFormatter.out(System.out, results) // [3]
    qexec.close() // [4]
}