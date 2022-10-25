# El gran libro de Kotlin
(para programadores de back end)

Editor: [Marcombo](https://www.marcombo.com/)
, autor: [Luis Criado Fernández](http://luis.criado.online/)

Véase [licencia del código fuente](LICENSE.txt)

## Descripción

Este es un libro orientado a programadores (de back end) que quieran aprender Kotlin, especialmente si proceden de Java.

Muchos lenguajes utilizan la máquina virtual de Java, la JVM, como son: Scala (2003), Groovy (2003), Fantom (2005), Clojure (2007), Xtend (2011) y kotlin (diseñado en 2011, primera versión estable en 2016). Entonces, ¿por qué razón kotlin puede interesar más que el resto de lenguajes basados en JVM?. Sencillamente por considerarse uno de los lenguajes emergentes más prometedores, quizás tras el respaldo del mundo Android, pues en 2017, kotlin fue adoptado por Google como lenguaje oficial para Android, al mismo nivel que Java.  Por si esto fuera poco, kotlin continúa conquistando fronteras y en 2020 sorprendió con KMM (Kotlin Multiplatform Mobile) un SDK que permite utilizar el mismo código de lógica empresarial, tanto en aplicaciones iOS como Android.

Sin embargo, kotlin no es sólo un lenguaje para implementar apps, pues es un lenguaje de propósito general; que engancha. Cuanto más se usa, más se desea programar con él y descubrir más bondades del lenguaje. 

Este libro es una guía para explorar y descubrir las posibilidades de kotlin para programación back end.

El LIBRO INCORPORA LA EXPLICACIÓN DE TODO EL CÓDIGO FUENTE <br>

[Indice](indice.md) de contenido del libro



## Dependencias:


#### Ficheros:
- [log4j](https://github.com/apache/logging-log4j2/tree/master/log4j-api) - libreria Java para la gestión de ficheros logs.
- [epublib](https://github.com/psiegman/epublib) - libreria Java para la lectura, escritura de archivos epub.
- [json](https://mvnrepository.com/artifact/org.json/json/1.2.60),[gson](https://mvnrepository.com/artifact/com.google.code.gson/gson) - librerias Java para la lectura, escritura de archivos json.
- [csv](https://mvnrepository.com/artifact/com.opencsv/opencsv) - libreria Java para la lectura, escritura de archivos csv.
- [rdf y owl](https://jena.apache.org/index.html) - Libreria Java para crear aplicaciones de Web Semántica y Linked Data. 
  [Ejemplos](https://github.com/castagna/jena-examples/tree/master/src/main/java/org/apache/jena/examples)

#### Bases de Datos:
##### Relacionales:
- [sqlite](https://mvnrepository.com/artifact/org.xerial/sqlite-jdbc) - Driver Java para SQLite.
- [MySql](https://mvnrepository.com/artifact/mysql/mysql-connector-java) - Driver Java para MySql.
- [Oracle](https://mvnrepository.com/artifact/com.oracle.database.jdbc/ojdbc8) - Driver Java para Oracle.

##### NoSQL
- [redis](https://mvnrepository.com/artifact/redis.clients/jedis) - Driver Java para redis.
- [mongoDB](https://mvnrepository.com/artifact/org.mongodb/mongo-java-driver) -  Driver Java para MongoDB.
- [jena-fuseki](https://mvnrepository.com/artifact/org.apache.jena/jena-fuseki-server)  - Driver Java para Fuseki.
- [AllegroGraph](https://mvnrepository.com/artifact/com.franz/agraph-java-client) - Driver Java para AllegroGraph.

#### Misceláneo:
- [jdsp](https://github.com/psambit9791/jDSP) - libreria Java para el procesado de señales digitales



## Herramienta utilizada para verificar hash
[den4b](http://www.den4b.com/)

## Máquina virtual:
descargar máquina virtual:  
[PRIMERA ALTERNATIVA](https://drive.google.com/file/d/1-BIkKU7vMwF3mX4UWgIzu4HaW-a-KjPq/view?usp=sharing), 

Kubuntu20.04_AtreveteConKotlin.ova (size: 5,62 GB)

    CRC32: 1f9fa2c1
    MD5: 16c5bf607d353d6ee89475ff8d76664a
    SHA1: 12ab7e7847c6df26ead3b7a63bec01a2333442c7
    SHA256: 152fd1022d1931d3a2ab8620f423303d0b52c638960de8e3d9497131209614da
    SHA512: 1f81ea21bcc1cc89bd315b73e218e71a74d9ef4821143f6e44b1c3f7229f13810711f30da7e67982f7d2e513638f6a2ed6801f403a90338adba360ea17967355

## Docker con Tomcat 9 y aplicación war "ktor-cap12":
docker push lcriadof/ktor-cap12:v1

[ir a docker hub]([https://drive.google.com/file/d/1mh1OXmO0LWq2aAprGYsbQQscIT4TricW/view?usp=sharing](https://hub.docker.com/r/lcriadof/ktor-cap12) 


