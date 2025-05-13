package org.utl.introkotlin_901.temasKotlin

fun saludo(){
    return println("Hola Mundo")
}

fun sum(x: Int, y: Int): Int{
    return x+y

}

fun sum2(X: Int, y: Int): Int = X+y

fun main(){
    saludo()
    println("-------------------------------------------------------------------------------------")
    println(sum(2,3))
    println(sum2(2,3))

}