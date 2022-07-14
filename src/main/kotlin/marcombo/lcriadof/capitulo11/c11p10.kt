package marcombo.lcriadof.capitulo11

import kotlinx.coroutines.runBlocking
import java.util.Timer
import kotlin.concurrent.schedule
import kotlin.concurrent.scheduleAtFixedRate

// se suponia que era un demonio, pero no funciona
//   https://jamie.mccrindle.org/posts/exploring-kotlin-standard-library-part-3/

fun main()= runBlocking{
    // create a daemon thread
    val timer = Timer("schedule", true);

    // schedule a single event
    timer.schedule(1000) {
        println("hello world!")
    }
    // schedule at a fixed rate
    val scheduleAtFixedRate = timer.scheduleAtFixedRate(1000, 1000) {
        println("hello world!")

    }

}