/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 8: BASES DE DATOS
 */

package marcombo.lcriadof.capitulo8

import com.mongodb.client.MongoClients
import com.mongodb.client.MongoCollection
import org.bson.Document;
fun main() {
    MongoClients.create("mongodb://192.168.0.20:27117").use { mongoClient ->
        val database = mongoClient.getDatabase("test")
        val collection: MongoCollection<Document> = database.getCollection("continentes")
        collection.find().iterator().use { cur ->
            while (cur.hasNext()) {
                val doc: Document = cur.next()

                print("El continente "+doc.get("nombre")+"-> ")
                print("tiene una población de "+doc.get("poblacion")+" millones de habitantes\n")
            }
        }
    }
}
