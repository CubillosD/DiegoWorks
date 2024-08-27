fun main() {
    val control = GTelefonicos(1) // Ejemplo con 1 cabina inicial se van agregando en el menu de registro
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
                println("Ingrese el tipo de llamada (Celular, local, Larga distancia):")
                val tipo = readLine()?.lowercase() ?: continue
                println("Ingrese la duración de la llamada en minutos:")
                val minutos = readLine()?.toIntOrNull() ?: continue

                try {
                    control.registrarLlamada(cabinaId, tipo, minutos)
                    println("Llamada registrada exitosamente.")
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
                    println("Error debe registrar${e.message}")
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
