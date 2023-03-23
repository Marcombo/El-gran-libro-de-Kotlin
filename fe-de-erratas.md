Fe de erratas
A pesar de los múltiples procesos de revisión y corrección a los que el libro ha sido sometido, hemos detectado las siguientes erratas en la primera edición:


Donde dice "...Lance primero esta consulta (para ver el total de lenguajes de programación que tiene la DBpedia).."
Hay una consulta que no es correcta, en su lugar utilice la siguiente:

  PREFIX dbpedia-owl: <http://dbpedia.org/ontology/>
  PREFIX esdbpr: <http://es.dbpedia.org/resource/> 
       PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
  SELECT COUNT(*)
  WHERE{
    ?lenguaje  rdf:type   dbpedia-owl:ProgrammingLanguage .
  }
