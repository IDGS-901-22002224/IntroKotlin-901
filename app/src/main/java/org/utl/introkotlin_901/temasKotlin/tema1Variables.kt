package org.utl.introkotlin_901.temasKotlin

fun main(){
    println("Hola mundo")

    val nombre = "Ronald"
    var apellido: String = "Cardiel"


    println(nombre + " " + apellido)
    println("Hola $nombre $apellido")

    var num1 = 10
    println("La suma de $num1 + 2 es ${num1 + 2}")

    num1 = num1 + 3
    num1 +=4
    num1++
    println(num1)

    var sueldo:Float=12.25f
    val sueldo2:Double=20.5
    val mayorEdad:Boolean=true
    val estadoCivil:Char='S'
}