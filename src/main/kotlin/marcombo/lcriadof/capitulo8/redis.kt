/*
El gran libro de Kotlin
(para programadores de back end)

Editor: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 8: BASES DE DATOS
 */

package marcombo.lcriadof.capitulo8

/*
docker run --name some-redis -p 6380:6379 -d redis
docker ps
docker ps -a
docker start [id]
 */

import redis.clients.jedis.Jedis
import redis.clients.jedis.JedisPool
import redis.clients.jedis.JedisPoolConfig

fun main(){

    val oJedis = Jedis("192.168.0.20", 6380) // conexión con Redis
   // val oJedis = Jedis("192.168.1.66", 6380) // conexión con Redis

    // añadimos datos
    oJedis.hset("user:lcriadof", "email", "lcriadof@yahoo.es");
    oJedis.hset("user:lcriadof", "name", "Luis");
    oJedis.hset("user:lcriadof", "surname", "Criado Fernández");
    oJedis.hset("user:lcriadof", "twitter", "@lcriadof");

    // HKEYS
    val keys: Set<String> = oJedis.hkeys("user:lcriadof")

    // Mostramos resultados
    for (c in keys) {
        println(c + ": " + oJedis.hget("user:lcriadof", c))
    }

    oJedis.close() // cerramos conexion con Redis

}
