import Parcial.Candidato
import Parcial.Elecciones

fun main() {
    val candidato1 = Candidato("Candidato 1")
    val candidato2 = Candidato("Candidato 2")
    val candidato3 = Candidato("Candidato 3")

    val elecciones = Elecciones(listOf(candidato1, candidato2, candidato3))

    while (true) {
        println("╔═══════════════════════════════════╗")
        println("║      ELECCIONES MUNICIPALES       ║")
        println("╠═══════════════════════════════════╣")
        println("║  1. Votar                         ║")
        println("║  2. Mostrar resultados            ║")
        println("║  3. Vaciar urnas                  ║")
        println("║  4. Salir                         ║")
        println("╠═══════════════════════════════════╣")
        println("║      Seleccione una opcion        ║")
        println("╚═══════════════════════════════════╝")

        when (readLine()?.toIntOrNull()) {
            1 -> {
                println("╔═══════════════════════════════════╗")
                println("║        ELIJA UN CANDIDATO         ║")
                println("╠═══════════════════════════════════╣")
                println("║       1. ${candidato1.nombre}              ║")
                println("║       2. ${candidato2.nombre}              ║")
                println("║       3. ${candidato3.nombre}              ║")
                println("╠═══════════════════════════════════╣")
                println("║     Seleccione un candidato       ║")
                println("╚═══════════════════════════════════╝")
                val candidatoSeleccionado = when (readLine()?.toIntOrNull()) {
                    1 -> candidato1
                    2 -> candidato2
                    3 -> candidato3
                    else -> {
                        println("Candidato no válido.")
                        continue
                    }
                }
                println("╔═══════════════════════════════════╗")
                println("║        MEDIO DE INFLUENCIA        ║")
                println("╠═══════════════════════════════════╣")
                println("║          1. Internet              ║")
                println("║          2. Radio                 ║")
                println("║          3. Televisión            ║")
                println("╠═══════════════════════════════════╣")
                println("║        Seleccione un medio        ║")
                println("╚═══════════════════════════════════╝")
                val medioSeleccionado = when (readLine()?.toIntOrNull()) {
                    1 -> "internet"
                    2 -> "radio"
                    3 -> "televisión"
                    else -> {
                        println("Medio no válido.")
                        continue
                    }
                }

                elecciones.votar(candidatoSeleccionado, medioSeleccionado)
                println("Voto registrado para ${candidatoSeleccionado.nombre} por ${medioSeleccionado.capitalize()}.")
            }
            2 -> {
                println("╔═══════════════════════════════════╗")
                println("║             RESULTADOS            ║")
                println("╚═══════════════════════════════════╝")

                fun mostrarResultadosCandidato(candidato: Candidato) {
                    println("╔═══════════════════════════════════╗")
                    println("║     Votos del ${candidato.nombre}         ║")
                    println("╚═══════════════════════════════════╝")
                    println("")
                    println("  Total votos: ${candidato.totalVotos()}")
                    println("  Costo campaña: ${candidato.calcularCostoCampaña()}")
                    println("  Votos influenciados por Internet: ${candidato.votosInternet}")
                    println("  Votos influenciados por Radio: ${candidato.votosRadio}")
                    println("  Votos influenciados por Television: ${candidato.votosTV}")
                    println("  Porcentaje de votos: ${elecciones.porcentajeVotos(candidato)}%")
                    println("╚═══════════════════════════════════╝")
                    println("")
                }

                mostrarResultadosCandidato(candidato1)
                mostrarResultadosCandidato(candidato2)
                mostrarResultadosCandidato(candidato3)

                println("\nTotal de votos: ${elecciones.totalVotos()}")
                println("Costo promedio de campaña: ${elecciones.costoPromedioCampaña()}")

                val ganador = elecciones.candidatoGanador()
                println("Candidato ganador: ${ganador?.nombre ?: "Ninguno"}")
            }
            3 -> {
                elecciones.vaciarUrnas()
                println("Urnas limpiadas.")
            }
            4 -> {
                println("Saliendo...")
                break
            }
            else -> println("Opción no válida.")
        }
    }
}
