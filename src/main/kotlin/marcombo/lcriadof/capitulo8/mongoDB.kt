/*
El gran libro de Kotlin
(para programadores de back end)

Editor: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 8: BASES DE DATOS
 */

package marcombo.lcriadof.capitulo8

/*
docker run --name mongo -p 27117:27017 -d mongo
 */

// ejemplo inspirado en https://zetcode.com/java/mongodb/
// para comprobar resultados nos hemos instalado localmente:
//       DBeaver Enterprise Edition 21.3
//


import com.mongodb.MongoClient
import com.mongodb.MongoCommandException
import com.mongodb.MongoException
import com.mongodb.client.MongoCollection
import org.bson.Document


fun main(){
        var mongoClient: MongoClient? = null
        try {
            mongoClient = MongoClient("192.168.0.20", 27117) //1
            var db = mongoClient.getDatabase("test")  // 2

            try {
                db.createCollection("continentes") // 3  crea una nueva colección
            } catch (e: MongoCommandException) {
                db.getCollection("continentes").drop()
            }
            val docs: ArrayList<Document> = ArrayList<Document>() // 4
            val collectionMongo: MongoCollection<Document> = db.getCollection("continentes") // 5   nos devuelve el objeto de la coleción sobre el que actualizaremos toda la información que deseamos añadir


            val nomContinentes: List<String> = listOf("Norteamérica","Sudamérica","Asia","Europa","África","Oceanía","Antártida")  // 5
            val pobContinentes = listOf(579,422.5,3879,731,922,27,0.001)  // 6

            var d = Document("_id", 0)
            for (i in 0..6){  // 7
                d = Document("_id", i+1)
                d.append("nombre",nomContinentes[i])
                d.append("poblacion",pobContinentes[i]) // en millones
                docs.add(d)
            }

            collectionMongo.insertMany(docs)  // 8
        } catch (e: MongoException) {
            e.printStackTrace()
        } finally {
            mongoClient!!.close() //9
        }
    }

