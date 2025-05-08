package org.utl.introkotlin_901.temasKotlin

// programa que me muestre un menu que me calcule el area de 4 figuras 1 area circulo pentagono cuadrado y triangulo

fun main(){
    while (true) {
        println("SELECCIONE LA FIGURA QUE DESEA CALCULAR EL AREA")
        println("1. Calcular el area de un circulo")
        println("2. Calcular el area de un pentagono")
        println("3. Calcular el area de un cuadrado")
        println("4. Calcular el area de un triangulo")
        println("5. Salir")

        print("Ingrese una opcion: ")
        val opcion = readLine()?.toIntOrNull()

        when (opcion) {
            1 -> {
                println("--Area del Cirsulo--")
                print("Ingrese el radio del circulo: ")
                val radio = readLine()?.toDoubleOrNull()
                if (radio != null && radio >= 0){
                    val area = Math.PI * radio * radio
                    println("El area del circulo es: $area")
                } else {
                    println("El radio debe ser positivo")
                }
            }

            2 -> {
                println("--Area del Pentagono--")
                print("Ingrese el lado del pentagono: ")
                val lado = readLine()?.toDoubleOrNull()
                print("Ingrese la apotema del pentagono: ")
                val apotema = readLine()?.toDoubleOrNull()
                if (lado != null && apotema != null && lado >= 0 && apotema >= 0){
                    val area = (lado * apotema) / 2
                    println("El area del pentagono es: $area")
                } else {
                    println("Los lados y apotema deben ser positivos")
                }
            }
            3 -> {
                println("--Area del Cuadrado--")
                print("Ingrese el lado del cuadrado: ")
                val lado = readLine()?.toDoubleOrNull()
                if (lado != null && lado >= 0){
                    val area = lado * lado
                    println("El area del cuadrado es: $area")
                    } else {
                    println("El lado debe ser positivo")
            }

            }
            4 -> {
                println("--Area del Triangulo--")
                print("Ingrese la base del triangulo: ")
                val base = readLine()?.toDoubleOrNull()
                print("Ingrese la altura del triangulo: ")
                val altura = readLine()?.toDoubleOrNull()
                if (base != null && altura != null && base >= 0 && altura >= 0){
                    val area = (base * altura) / 2
                    println("El area del triangulo es: $area")
                    } else {
                    println("La base y altura deben ser positivos")
                    }
                }
            5 -> {
                println("SALIENDO")
            return
            }
            else -> {
                println("Opcion INCORRECTA!!!")
            }
        }
    }
}