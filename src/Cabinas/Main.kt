package Cabinas

import kotlin.random.Random

fun main() {
    val control = GTelefonicos(1) // Ejemplo con 1 cabina inicial
    var opcion: Int

    do {
        println(
            """
            ╔══════════════════════════════════════════════════╗
            ║      Menú de Control de Gastos Telefónicos       ║
            ╠══════════════════════════════════════════════════╣
            ║ 1. Registrar Llamada                             ║
            ║ 2. Mostrar Información de Cabina                 ║
            ║ 3. Mostrar Consolidado Total                     ║
            ║ 4. Reiniciar Cabina                              ║
            ║ 5. Agregar Cabina                                ║
            ║ 6. Salir                                         ║
            ╚══════════════════════════════════════════════════╝
        """.trimMargin()
        )

        opcion = readLine()?.toIntOrNull() ?: 0

        when (opcion) {
            1 -> {
                println("Ingrese el ID de la cabina:")
                val cabinaId = readLine()?.toIntOrNull() ?: continue
                println("Ingrese el tipo de llamada (celular, local, larga distancia):")
                val tipo = readLine()?.lowercase() ?: continue

                // Generar duración aleatoria de la llamada
                val minutos = Random.nextInt(1, 61) // Duración entre 1 y 60 minutos

                try {
                    control.registrarLlamada(cabinaId, tipo, minutos)
                    println("Llamada registrada exitosamente con duración de $minutos minutos.")
                } catch (e: IllegalArgumentException) {
                    println("Error: ${e.message}")
                }
            }
            2 -> {
                println("Ingrese el ID de la cabina:")
                val cabinaId = readLine()?.toIntOrNull() ?: continue

                try {
                    println(control.mostrarInfoCabina(cabinaId))
                } catch (e: IllegalArgumentException) {
                    println("Error: ${e.message}")
                }
            }
            3 -> {
                println(control.mostrarConsolidadoTotal())
            }
            4 -> {
                println("Ingrese el ID de la cabina:")
                val cabinaId = readLine()?.toIntOrNull() ?: continue

                try {
                    control.reiniciarCabina(cabinaId)
                    println("Cabina reiniciada exitosamente.")
                } catch (e: IllegalArgumentException) {
                    println("Error: ${e.message}")
                }
            }
            5 -> {
                control.agregarCabina()
                println("Nueva cabina agregada exitosamente.")
            }
            6 -> println("PROGRAMA FINALIZADO...")
            else -> println("Opción no válida. Por favor, intente de nuevo.")
        }
    } while (opcion != 6)
}
