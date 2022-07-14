package marcombo.lcriadof.capitulo11

import java.util.concurrent.*

/*
fun main() {

    val m = Monitor(3)
    val p = Productor(m, 6, 2000)
    val c = Consumidor(m, 6, 4000)


    p.start()
    c.start()
}


class Monitor(capacidad: Int) {
    private var buff: CharArray? = null
    private var tope = 0
    private var lleno = false
    private var vacio = true

    init {
        buff = CharArray(capacidad)
    }

    @Synchronized
    @Throws(java.lang.Exception::class)
    fun poner(c: Char) {
        // Mientras el buffer este lleno nos blockeamos
        // para que el consumidor de consumir algun caracter
        while (lleno) {
            wait()
        }

        // seccion critica
        buff!![tope++] = c
        vacio = false
        lleno = tope >= buff!!.size
        ObjectSubstitutions.notifyAll()
    }

    @Synchronized
    @Throws(java.lang.Exception::class)
    fun sacar(): Char {
        // Mientras el buffer este vacio nos blockeamos para
        // que el productor pueda de producir un caracter
        while (vacio) {
            wait()
        }

        // seccion critica
        val c = buff!![--tope]
        lleno = false
        vacio = tope == 0
        ObjectSubstitutions.notifyAll()
        return c
    }
}



class Consumidor(private val buff: Monitor, private val n: Int, private val sleep: Int) : Thread() {
    override fun run() {
        try {
            var c: Char
            for (i in 0 until n) {
                c = buff.sacar()
                println("Consumi: $c")
                sleep((Math.random() * sleep).toInt().toLong())
            }
        } catch (ex: java.lang.Exception) {
            ex.printStackTrace()
            throw RuntimeException(ex)
        }
    }
}



class Productor(b: Monitor, n: Int, s: Int) : Thread() {
    private val buff: Monitor
    private val n: Int
    private val sleep: Int

    init {
        // el monitor
        buff = b

        // cuantos caracteres debe producir
        this.n = n

        // cuanto tiempo dormir entre caracter y caracter
        sleep = s
    }

    override fun run() {
        try {
            var c: Char
            for (i in 0 until n) {
                c = ('A'.code + i).toChar()
                buff.poner(c)
                println("Produje: $c")
                sleep((Math.random() * sleep).toInt().toLong())
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
            throw RuntimeException(ex)
        }
    }


}


 */
