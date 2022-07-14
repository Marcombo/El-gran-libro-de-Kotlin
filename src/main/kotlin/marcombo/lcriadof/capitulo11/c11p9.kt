package marcombo.lcriadof.capitulo11

// dice que es un demonio, le he puesto yo el nombre, extraido de
//    https://github.com/kazukousen/kotlin-daemon-example/blob/master/src/main/kotlin/com/github/kazukousen/kt_example/Hoge.kt
//    yo veo este demonio en el hilo principal, no sirve
import java.io.File
import java.lang.Runtime
import java.lang.Thread
import java.lang.Thread.sleep
import java.time.ZonedDateTime

object demonio {
    fun run() {
        Misc.print("Hello, World!")
    }

}

object Misc {
    fun print(s: String) {
        println("[${ZonedDateTime.now()}] ${s}")
    }

    fun printErr(s: String) {
        println("[${ZonedDateTime.now()}] ${s}")
    }
}

class ShutdownThread : Thread() {
    override fun run() {
        Misc.print("get HUP signal.")
        Misc.print("Shutdown.")
    }
}

fun main() {

    Runtime.getRuntime().addShutdownHook(ShutdownThread())  // ejecuta un Thread antes de que la JVM finalice.

    while(true) {
        demonio.run()
        Thread.sleep(5000L)
    }
}