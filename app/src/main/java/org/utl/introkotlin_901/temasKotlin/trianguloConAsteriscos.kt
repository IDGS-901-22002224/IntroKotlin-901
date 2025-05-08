package org.utl.introkotlin_901.temasKotlin

// utilizando el do while caprutAR UN NUMERO ASTERISCOS REFENRETE al numero que elijamos

import java.util.Scanner


fun main() {
    val scanner = Scanner(System.`in`)
    var number: Int

    do {
        println("INGRESA UN NUMERO POSITIVO (INGRESA 0 PARA SALIR):")

        var inputIsValid: Boolean
        do {
            inputIsValid = scanner.hasNextInt()
            if (!inputIsValid) {
                println("NUMERO INCORRECTO, INGRESA UN NUMERO VALIDO:")
                scanner.next()
            }
        } while (!inputIsValid)

        number = scanner.nextInt()

        when {
            number > 0 -> {

                var i = 1
                do {
                    var j = 1
                    do {
                        print("*")
                        j++
                    } while (j <= i)
                    println()
                    i++
                } while (i <= number)
            }
            number < 0 -> {
                println("POR FAVOR INGRESA UN NUMERO POSITIVO.")
            }

        }

    } while (number != 0)

    println("SALIENDO!.")
    scanner.close()
}