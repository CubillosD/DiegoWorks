//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
 //val op = Operaciones(5.0,7.2)
    //op.suma()
    //op.resta()
    //println("El resultado de la division es ${op.div()}")
    //op.raiz(12.3)
    //println("EL cuadrato es ${op.cuadrado(4.0)}")


    // Main.kt


        val control = GTelefonicos(3)  // Ejemplo con 3 cabinas
        var opcion: Int

        do {
            println(
                """
            |=== Menú de Control de Gastos Telefónicos ===
            |1. Registrar Llamada
            |2. Mostrar Información de Cabina
            |3. Mostrar Consolidado Total
            |4. Reiniciar Cabina
            |5. Salir
            |Seleccione una opción:
        """.trimMargin()
            )

            opcion = readLine()?.toIntOrNull() ?: 0

            when (opcion) {
                1 -> {
                    println("Ingrese el ID de la cabina (1 a ${control.numCabinas}):")
                    val cabinaId = readLine()?.toIntOrNull() ?: continue
                    println("Ingrese el tipo de llamada (local, larga distancia, celular):")
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
                    println("Ingrese el ID de la cabina (1 a ${control.numCabinas}):")
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
                    println("Ingrese el ID de la cabina (1 a ${control.numCabinas}):")
                    val cabinaId = readLine()?.toIntOrNull() ?: continue

                    try {
                        control.reiniciarCabina(cabinaId)
                        println("Cabina reiniciada exitosamente.")
                    } catch (e: IllegalArgumentException) {
                        println("Error: ${e.message}")
                    }
                }
                5 -> println("Saliendo del programa...")
                else -> println("Opción no válida. Por favor, intente de nuevo.")
            }
        } while (opcion != 5)
    }



