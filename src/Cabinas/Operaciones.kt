package Cabinas

class Operaciones(var n1: Double, var n2: Double) {

    fun suma() {
        var sum = n1 + n2
        println("El resultado de la suma es ${sum}")

    }

    fun resta() {
        var res = n1 - n2
        println("El resultado de la resta es ${res}")
    }

    fun div(): Double {
        return n1 / n2
    }

    fun raiz(X:Double){
    var r = Math.sqrt(X)
    println("EL resultado de la raiz es ${r}")
    }

    fun cuadrado(C:Double):Double{
        return Math.pow(C,2.5)
    }

}