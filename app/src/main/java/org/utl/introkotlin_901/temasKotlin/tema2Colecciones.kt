package org.utl.introkotlin_901.temasKotlin

fun main(){
    /*
    List, MutableList
    Set, MutableSet
    Map, MutableMap
    */

    var readOnlyList: List<String> = listOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes")
    println(readOnlyList)
    println("el primer elemento es ${readOnlyList[0]}")
    println("el primer elemento es ${readOnlyList.first()}")
    println("el numero de dias es ${readOnlyList.count()}")
    println("el numero de dias es ${readOnlyList.size}")
    println("Martesss" in readOnlyList)

    var figuras:MutableList<String> = mutableListOf("circulo", "cuadrado", "triangulo")
    println(figuras)
    figuras.add("pentagono")
    println(figuras)
    figuras.removeAt(0)
    println(figuras)
    figuras.remove("cuadrado")
    println(figuras)

    //----------------------------------------------------------------------------------------------
    val readOnlyFrutas = mapOf("manzana" to 1500, "platano" to 2000, "sandia" to 2500)
    println(readOnlyFrutas)
    println(readOnlyFrutas["manzana"])
    println(readOnlyFrutas.keys)
    println(readOnlyFrutas.values)


}