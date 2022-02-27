/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 8: BASES DE DATOS
 */

package marcombo.lcriadof.capitulo8


fun main() {
    var sql = oracle("test","secret")
    var url: String
    var insert: String
    var crearTabla:String

    url = "jdbc:oracle:thin:@192.168.0.20:15210:xe"  //  this.connectionURL="jdbc:oracle:thin:@"+ipmaquina+":"+puerto+":"+instancia;
    sql.conectar(url)

    // identificamos la estructura de la tabla
    sql.campos("continentes2")
    sql.campos.forEach {  println("nombre de campo: "+it) // visualizamos
        println( "tipo de campo: "+sql.items.get(it)+"\n" )
    }

    // añadimos información a la tabla
    insert="INSERT INTO TEST.CONTINENTES2 (ID, CONTINENTE) VALUES(1, 'Norteamérica')"
    sql.escribir(insert)
    insert="INSERT INTO TEST.CONTINENTES2 (ID, CONTINENTE) VALUES(2, 'Sudamérica')"
    sql.escribir(insert)
    insert="INSERT INTO TEST.CONTINENTES2 (ID, CONTINENTE) VALUES(3, 'Asia')"
    sql.escribir(insert)
    insert="INSERT INTO TEST.CONTINENTES2 (ID, CONTINENTE) VALUES(4, 'Europa')"
    sql.escribir(insert)
    insert="INSERT INTO TEST.CONTINENTES2 (ID, CONTINENTE) VALUES(5, 'África')"
    sql.escribir(insert)
    insert="INSERT INTO TEST.CONTINENTES2 (ID, CONTINENTE) VALUES(6, 'Oceanía')"
    sql.escribir(insert)
    insert="INSERT INTO TEST.CONTINENTES2 (ID, CONTINENTE) VALUES(7, 'Antártida')"
    sql.escribir(insert)
    insert="COMMIT;"
    sql.escribir(insert)



    println(sql.leer("test.continentes2",simboloFinal = ""))

    sql.desconectar()
}