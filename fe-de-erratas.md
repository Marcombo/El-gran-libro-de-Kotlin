# Fe de erratas
A pesar de los múltiples procesos de revisión y corrección a los que el libro ha sido sometido, hemos detectado la siguiente errata en la primera edición:

### página 166

    Donde dice "...Lance primero esta consulta (para ver el total de lenguajes de programación que tiene la DBpedia).."
    La consulta está repetida con la siguiente, en realidad debe ejecutar primero la siguiente:

    PREFIX dbpedia-owl: <http://dbpedia.org/ontology/>
    PREFIX esdbpr: <http://es.dbpedia.org/resource/> 
    PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
    SELECT COUNT(*)
    WHERE{
        ?lenguaje  rdf:type   dbpedia-owl:ProgrammingLanguage .
    }

### página 210

La expresión para el cálculo del IMC tiene un error. En lugar de un producto se trata de un cociente.

    IMC = peso (kg)/ [estatura (m)]^2.
