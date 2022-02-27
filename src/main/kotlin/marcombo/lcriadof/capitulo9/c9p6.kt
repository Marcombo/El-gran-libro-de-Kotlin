/*
El gran libro de Kotlin
(para programadores de back end)

Editorial: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)

CAPÍTULO 9: NÚMEROS.
 */

package marcombo.lcriadof.capitulo9
// metodo Gauss Jordan


class gaussJordan(val A: Array<DoubleArray>, var b: Array<DoubleArray>) { //1
    var Aplus= Array(A.size) { DoubleArray(A.size+1) } //2
    var K:Int=0 //3    multiplicaror entre la fila pivote y la fila para eliminar ingognita

    init{  // 4
        rellenarMatrizAmpliada()
    }

    private fun rellenarMatrizAmpliada() {
        for (y in A.indices) {
            for (x in A.indices) {
                Aplus[y][x] = A[y][x] // copiamos elemento de la matriz de coeficientea a la ampliada
            }
        }
        for (c in b.indices) {
            Aplus[c][A.size] = b[c][0]  // copiamos elemento de la matriz de terminos independientes a la ampliada
        }
        print("El sistema a resolver es\n")
        Aplus.forEach { println(it.joinToString()) }  // 8 ver como queda la matriz
    }


   private fun normalizar(fila:Int) { // 5
      val normalizarCon=Aplus[fila][fila]  // 6
      for (x in Aplus[0].indices) {
          Aplus[fila][x] = Aplus[fila][x]/normalizarCon  //7
          //println("Aplus[$fila][$x]="+Aplus[fila][x])
      }
      // Aplus.forEach { println(it.joinToString()) }  // ver como queda la matriz
   }


   private fun ceros(fila:Int,pivotesobre:Int) { // 8
       var k = 0.0
       //println("fila= $fila, Aplus.size=" +Aplus.size)
       for (y in Aplus.indices) { // 9
          if (y!=pivotesobre) { // 10
              //print("y=$y;   fila=$fila  \n")
              k = Aplus[y][pivotesobre] * Aplus[pivotesobre][pivotesobre] // 11
              //println("Aplus[$y][$pivotesobre]=" + Aplus[y][pivotesobre])
              //println("Aplus[$pivotesobre][$pivotesobre]=" + Aplus[pivotesobre][pivotesobre])
              //println("k=$k")
              for (x in Aplus[0].indices) {
                  Aplus[y][x] = Aplus[y][x] - (k * Aplus[pivotesobre][x]) // 12
                  // println("Aplus[$y][$x]="+Aplus[y][x])
                  // println("Aplus[$sobre][$x]="+Aplus[sobre][x])
              } // fin de for interno
          } // fin de if
       } // fin de for externo
       // Aplus.forEach { println(it.joinToString()) }  // ver como queda la matriz
   }
//  http://acodigo.blogspot.com/2014/03/gauss-jordan.html

   fun resolver(){
      for (n in Aplus.indices){ // 13
          normalizar(n)
          ceros(n+1,n)
      }
      println("Solución:")
      Aplus.forEach { println(it.joinToString()) }  // ver como queda la matriz
      for (x in Aplus.indices) {
         println("X$x="+Aplus[x][Aplus.size])
      }
      println("----------")
   }

}  // fin metodo Gauss Jordan


fun main() {

    var A: Array<DoubleArray> = arrayOf(
            doubleArrayOf(-6.0, 4.0, -15.0),
            doubleArrayOf(10.0, 5.0,  -3.0),
            doubleArrayOf(2.0, 13.0, -7.0) )

    var b: Array<DoubleArray> = arrayOf(
            doubleArrayOf(10.0),
            doubleArrayOf(20.0),
            doubleArrayOf(50.0))

    var gaussJordan=gaussJordan(A,b)
    gaussJordan.resolver()



    var A2 = arrayOf(
            doubleArrayOf(3.0, -0.1, -0.2),
            doubleArrayOf(0.1, 7.0, -0.3),
            doubleArrayOf(0.3, -0.2, 10.0) )

    var b2= arrayOf(
            doubleArrayOf(7.85),
            doubleArrayOf(-19.3),
            doubleArrayOf(71.4))

    var gaussJordan2=gaussJordan(A2,b2)
    gaussJordan2.resolver()




    var A3: Array<DoubleArray> = arrayOf(
            doubleArrayOf(4.0, -1.0, -1.0, 1.0),
            doubleArrayOf(1.0, 5.0, 1.0, -1.0),
            doubleArrayOf(-1.0, 1.0, 10.0, -4.0),
            doubleArrayOf(1.0, -2.0, 8.0, 20.0) )

    var b3: Array<DoubleArray> = arrayOf(
            doubleArrayOf(3.0),
            doubleArrayOf(6.0),
            doubleArrayOf(6.0),
            doubleArrayOf(27.0))


    var gaussJordan3=gaussJordan(A3,b3)
    gaussJordan3.resolver()


}
