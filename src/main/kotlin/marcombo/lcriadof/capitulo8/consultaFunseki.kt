/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 8: BASES DE DATOS
 */

package marcombo.lcriadof.capitulo8

import org.apache.jena.query.QueryExecution
import org.apache.jena.query.ResultSetFormatter

fun main(){
    val consulta="PREFIX table: <http://www.daml.org/2003/01/periodictable/PeriodicTable#> " +
            "SELECT ?name ?symbol ?number " +
            "WHERE {"+
            "    ?element table:name ?name."+
            "    ?element table:symbol ?symbol."+
            "    ?element table:atomicNumber ?number.}"
    val qexec: QueryExecution = QueryExecution.service("http://192.168.0.20:8080/test/sparql").query(consulta).build()
    val results = qexec.execSelect()
    ResultSetFormatter.out(System.out, results)
    qexec.close()
}