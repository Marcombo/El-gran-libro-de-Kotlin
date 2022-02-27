/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 8: BASES DE DATOS
 */

package marcombo.lcriadof.capitulo8

import org.apache.commons.beanutils.ResultSetIterator
import org.apache.jena.query.QueryFactory
import org.apache.jena.query.ResultSet
import org.apache.jena.query.ResultSetFormatter
import org.apache.jena.rdfconnection.RDFConnectionFuseki
import org.apache.jena.sparql.resultset.ResultsFormat

// ejemplo extraido de
//   https://github.com/apache/jena/tree/main/jena-examples/src/main/java/rdfconnection/examples

fun main(){
   val builder = RDFConnectionFuseki.create()
              .destination("http://192.168.0.20:8080/test/sparql") // [1]

   val consulta="PREFIX table: <http://www.daml.org/2003/01/periodictable/PeriodicTable#> " +
               "SELECT ?name ?symbol ?number " +
               "WHERE {"+
               "    ?element table:name ?name."+
               "    ?element table:symbol ?symbol."+
               "    ?element table:atomicNumber ?number.}" // [2]

   val query = QueryFactory.create(consulta) // [3]
   println("consulta: "+query.toString()) // [4]

   builder.build().use { conn -> conn.queryResultSet(query) // [5]
        { qresults: ResultSet? -> ResultSetFormatter.out(qresults) } }


}