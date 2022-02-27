/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 8: BASES DE DATOS
 */

package marcombo.lcriadof.capitulo8

fun main(){
    var sql= mySql()
    var url:String
    var insert:String
    var crearTabla:String

    url="jdbc:mysql://192.168.0.20:3306"

    sql.conectar(url)
    sql.use("test")
    crearTabla="CREATE TABLE `continentes` ( " +
            "  `id` int(1) NOT NULL AUTO_INCREMENT," +
            "  `continente` text NOT NULL, " +
            "  PRIMARY KEY (`id`));"
    sql.crear(crearTabla)
    sql.campos("continentes")
    println(sql.gCampos())
    sql.desconectar()



    sql.conectar(url)
    sql.use("test")
    insert="INSERT INTO `continentes` (`id`, `continente`) VALUES " +
            "(1, 'Norteamérica'), " +
            "(2, 'Sudamérica'), " +
            "(3, 'Asia'), " +
            "(4, 'Europa'), " +
            "(5, 'África'), " +
            "(6, 'Oceanía'), " +
            "(7, 'Antártida');"

    println("*** campos ***") // es una lista de Map
    sql.campos("continentes")
    sql.campos.forEach {  println("nombre de campo: "+it) // visualizamos
        println( "tipo de campo: "+sql.items.get(it)+"\n" )
    }

    println(sql.escribir(insert))
    println(sql.leer("continentes"))
    sql.desconectar()




}
