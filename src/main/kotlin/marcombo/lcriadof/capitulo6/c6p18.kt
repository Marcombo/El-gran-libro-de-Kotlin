/*
El gran libro de Kotlin
(para programadores de back end)

Editor: Marcombo (https://www.marcombo.com/)
Autor: Luis Criado Fernández (http://luis.criado.online/)
 */

package marcombo.lcriadof.capitulo6

//public	Visible en todas partes
//internal	Visible en el módulo
//protected	Visible en la clase y subclases
//privated	Visible solo en la clase que lo declara

open class padre(var numero: Int)  {
    public var v1:Int=numero
    internal var v2:Int=5
    protected var v3:Int=5
    private var v4:Int=5

    init{
        v2=v1*5
        v3=v2*2
        v4=v3-4
        println("En padre se define 4 propiedades: v1 (public), v2 (internal), v3 (protected), v4 (private) ")
    }

    open fun proceso(){
        println("La clase padre, ve v1, v2, v3 y v4. Esta es la concatenación= "+this.v1+", "+this.v2+", "+this.v3+", "+this.v4)
    }
}

class hijo(numero: Int) : padre(numero){
   override fun proceso(){
       println("La clase hijo, ve v1, v2 y v3. Esta es la concatenación= "+this.v1+", "+this.v2+", "+this.v3)
   }

}


fun main(){
    var alcance= padre(10)
    alcance.proceso()

    println()
    println("Desde main() a clase padre se ve:")
    println("v1= "+alcance.v1)
    println("v2= "+alcance.v2)
    println()

    var alcanceHijo= hijo(10)
    alcanceHijo.proceso()

}