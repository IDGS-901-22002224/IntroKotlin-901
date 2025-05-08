package org.utl.introkotlin_901.temasKotlin

fun main(){
    val d: Int
    val e =  true
    if(e){
        d=1
    }else{
        d=2
    }
    println(d)
    val numero = if(e) 1 else 2
    println(numero)

    //---------------------------------------------------------------------------------------
    println("INGRESE EL SUELDO DEL EMPLEADO: ")
    val sueldo = readln().toDouble()
    if(sueldo>3000){
        println("Paga impuestos")
    }else{
        println("No paga impuestos")

    }

    //when
    val objeto:Any="hola"
    when(objeto){
        "1" -> println("Es un Int")
        "hola" -> println("Es un Saludo")
        is String -> println("Es un String")
        else -> println("No se que es")

    }

    //Range
    1..4//1,2,3,4
    4 downTo  1
    1.. 10 step 2
    'a'..'g'
    'z' downTo 'a' step 2
}