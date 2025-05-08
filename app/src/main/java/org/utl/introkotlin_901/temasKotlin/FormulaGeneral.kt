package org.utl.introkotlin_901.temasKotlin

// formula general

fun main() {
    var correcto: Boolean

    do {
        correcto = true

        println("Ingresa el valor de a:")
        val a = readln().toDouble()
        if (a == 0.0) {
            println("El valor de 'a' no puede ser 0.")
            correcto = false
            continue
        }

        println("Ingresa el valor de b:")
        val b = readln().toDouble()

        println("Ingresa el valor de c:")
        val c = readln().toDouble()

        val resulOperacion = (b * b) - (4 * a * c)

        if (resulOperacion < 0) {
            println("La ecuacion no tiene soluciones reales")
            correcto = false
        } else {
            val resultado1 = (-b + Math.sqrt(resulOperacion)) / (2 * a)
            val resultado2 = (-b - Math.sqrt(resulOperacion)) / (2 * a)

            println("El resultado x1 es: $resultado1")
            println("El resultado x2 es: $resultado2")
        }

    } while (!correcto)
}