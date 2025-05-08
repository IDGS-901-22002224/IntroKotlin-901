package org.utl.introkotlin_901.temasKotlin

//For
fun main(){
    for(numero in 1..5){
    println(numero)
    }

    val nombres = listOf("Ronald", "Mario", "Veronica", "Pedro")
    for(nombre in nombres){
        println(nombre)
    }


//while do-while

    var x = 0
    while(x<5){
        println(x)
        x++
    }

    do{
        println(x)
        x++
    }while(x<5)

}