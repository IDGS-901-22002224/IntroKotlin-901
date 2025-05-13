package org.utl.introkotlin_901.temasKotlin

import kotlin.math.PI
import java.util.Scanner

// Clase abstracta base para todas las figuras
abstract class FiguraGeometrica {
    abstract fun calcularArea(): Double
}

// Clase para  un Triangulo
class Triangulo(private val base: Double, private val altura: Double) : FiguraGeometrica() {
    override fun calcularArea(): Double {
        if (base <= 0 || altura <= 0) {
            println("Advertencia: La base y la altura del triangulo deben ser valores positivos.")
            return 0.0
        }
        return 0.5 * base * altura
    }
}

// Clase para  un Rectangulo
class Rectangulo(private val base: Double, private val altura: Double) : FiguraGeometrica() {
    override fun calcularArea(): Double {
        if (base <= 0 || altura <= 0) {
            println("Advertencia: La base y la altura del rectangulo deben ser valores positivos.")
            return 0.0
        }
        return base * altura
    }
}

// Clase para un Cuadrado
class Cuadrado(private val lado: Double) : FiguraGeometrica() {
    override fun calcularArea(): Double {
        if (lado <= 0) {
            println("Advertencia: El lado del cuadrado debe ser un valor positivo.")
            return 0.0
        }
        return lado * lado
    }
}

// Clase para  un Circulo
class Circulo(private val radio: Double) : FiguraGeometrica() {
    override fun calcularArea(): Double {
        if (radio <= 0) {
            println("Advertencia: El radio del circulo debe ser un valor positivo.")
            return 0.0
        }
        return PI * radio * radio
    }
}

// Clase para un Pentagono regular
class Pentagono(private val lado: Double, private val apotema: Double) : FiguraGeometrica() {
    override fun calcularArea(): Double {
        if (lado <= 0 || apotema <= 0) {
            println("Advertencia: El lado y la apotema del pentagono deben ser valores positivos.")
            return 0.0
        }
        // Area de un pentagono regular = (Perimetro * Apotema) / 2
        val perimetro = 5 * lado
        return (perimetro * apotema) / 2
    }
}

fun main() {
    val scanner = Scanner(System.`in`)

    var opcion: Int

    do {
        mostrarMenu()
        print("Seleccione una opcion: ")
        opcion = try {
            scanner.nextInt()
        } catch (e: Exception) {
            println("Entrada invalida. Por favor, ingrese un numero.")
            scanner.nextLine()
            0
        }

        when (opcion) {
            1 -> {
                println("\n--- Calcular Area de Triangulo ---")
                print("Ingrese la base: ")
                val base = scanner.nextDouble()
                print("Ingrese la altura: ")
                val altura = scanner.nextDouble()
                val triangulo = Triangulo(base, altura)
                println("El area del triangulo es: ${triangulo.calcularArea()}\n")
            }
            2 -> {
                println("\n--- Calcular Area de Rectangulo ---")
                print("Ingrese la base: ")
                val base = scanner.nextDouble()
                print("Ingrese la altura: ")
                val altura = scanner.nextDouble()
                val rectangulo = Rectangulo(base, altura)
                println("El area del rectangulo es: ${rectangulo.calcularArea()}\n")
            }
            3 -> {
                println("\n--- Calcular Area de Cuadrado ---")
                print("Ingrese el lado: ")
                val lado = scanner.nextDouble()
                val cuadrado = Cuadrado(lado)
                println("El area del cuadrado es: ${cuadrado.calcularArea()}\n")
            }
            4 -> {
                println("\n--- Calcular Area de Circulo ---")
                print("Ingrese el radio: ")
                val radio = scanner.nextDouble()
                val circulo = Circulo(radio)
                println("El area del circulo es: ${circulo.calcularArea()}\n")
            }
            5 -> {
                println("\n--- Calcular Area de Pentagono ---")
                print("Ingrese el lado: ")
                val lado = scanner.nextDouble()
                print("Ingrese la apotema: ")
                val apotema = scanner.nextDouble()
                val pentagono = Pentagono(lado, apotema)
                println("El area del pentagono es: ${pentagono.calcularArea()}\n")
            }
            0 -> println("ADIOS!!!\n")
            else -> println("Opcion invalida. Por favor, ingrese un numero del 0 al 5.\n")
        }

    } while (opcion != 0)

    scanner.close()
}

fun mostrarMenu() {
    println("--- MENU DE CALCULO DE AREAS ---")
    println("1. Triangulo")
    println("2. Rectangulo")
    println("3. Cuadrado")
    println("4. Circulo")
    println("5. Pentagono")
    println("0. Salir")
    println("------------------------------")
}