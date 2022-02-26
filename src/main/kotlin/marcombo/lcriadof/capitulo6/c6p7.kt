/*
El gran libro de Kotlin
(para programadores de back end)

Editor: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)
 */

package marcombo.lcriadof.capitulo6

// c6p7.kt   --- prefijos
enum class prefijoSI(val nombre:String, val potenciaDeDiez:Int, val valor: Double) { // 1
    yotta( "yotta",24,1000000000000000000000000.0),
    zetta( "zetta",21,1000000000000000000000.0),
    exa( "exa",18,1000000000000000000.0),
    peta( "peta",15,1000000000000000.0),
    tera ( "tera",12,1000000000000.0),
    giga ( "giga",9,1000000000.0),
    mega ("mega", 6,1000000.0),
    kilo ("kilo", 3,1000.0), // 2
    hecto ( "hecto",2,100.0),
    deca ( "deca",1,10.0),
    unidad ( "sin prefijo",0,1.0),
    deci ("deci", -1,0.1),
    centi ( "centi",-2,0.01),
    mili ( "mili",-3,0.001),
    micro ( "micro",-6,0.000001),
    nano ("nano",-9,0.000000001),
    pico ("pico",-12,0.000000000001) // 3
}

// c6p7.kt   -- conversor entre prefijos
class conversorPrefijoSI(var valor:Double,var prefijoValor: prefijoSI){  // 4

    fun getValor(nuevoPrefijoValor: prefijoSI):Double{ // 5
        var nuevaPotencia:Int=nuevoPrefijoValor.potenciaDeDiez // 6
        var antiguaPotencia:Int=prefijoValor.potenciaDeDiez  // 7
        var nuevoValor:Double=0.0
          if (nuevaPotencia>antiguaPotencia){ // 8   si pasamos a mas grande divido
            nuevoValor=valor/diezElevadoA(nuevaPotencia-antiguaPotencia) // 9
          }
          if (nuevaPotencia<antiguaPotencia){ // 10 si pasamos a mas pequeño multiplico
            nuevoValor=valor*diezElevadoA(antiguaPotencia-nuevaPotencia) // 11

          }
        return nuevoValor
    }

    // una vez que calculemos la diferencia entre potencia origen y destino
    // calculamos el valor de divior o numerador segun el caso
    fun diezElevadoA(potencia:Int):Double { // 12
        var salida:Double=1.0
        if (potencia>0){
            for (x in 1..potencia){
                salida =salida*10.0
            }
        }
        return salida
    }


}


// c6p7.kt   -- programa principal para probar la conversiónentre prefijos del SI
fun main() {

    // supongamos que partimos de hectómetros
    var num0:Double=153.0

    // UNIDAD: metro,  MAGNITUD: longitug
    var num= conversorPrefijoSI(num0, prefijoSI.hecto)

    println("<<<<  "+num0.toString()+" hectómetros" )
    println("son "+ num.getValor(prefijoSI.deca)+" decametros" )
    println("son "+ num.getValor(prefijoSI.kilo)+" kilometros" )

    // UNIDAD: segundo,  MAGNITUD: tiempo
    num0=25.0
    num= conversorPrefijoSI(num0, prefijoSI.unidad)
    println("<<<<  "+num0.toString()+" segundos" )
    println("son "+ num.getValor(prefijoSI.mili)+" milisegundos" )
    println("son "+ num.getValor(prefijoSI.micro)+" microsegundos" )

    /*

    Observe que en el SI, por delante de kilo y por debajo de mili, los saltos son siempre de tres ordenes de magnitud, es decir, multiplicando por 1000 o dividiendo por 1000 según nos desplacemos
    En informática la medid que se convino fue 1024 para definir un kilobyte pues es 2elevado10

    No te olvides:
1 Byte = 8 Bit.
1 Kilobyte = 1.024 Bytes.
1 Megabyte = 1.048.576 Bytes.
1 Gigabyte = 1.073.741.824 Bytes.
1 Terabyte = 1.099.511.627.776 Bytes.

iriamos multiplicando por 1024, en lugar de por 1000
     */
}