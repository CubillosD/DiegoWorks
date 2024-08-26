// GTelefonicos.kt

class GTelefonicos(val numCabinas: Int) {
    // Lista de cabinas inicializada con la cantidad de cabinas especificada
    private val cabinas: MutableList<Cabina> = MutableList(numCabinas) { Cabina(it + 1) }

    companion object {
        const val TARIFA_LOCAL = 50
        const val TARIFA_LARGA_DISTANCIA = 350
        const val TARIFA_CELULAR = 150
    }

    init {
        require(numCabinas > 0) { "El número de cabinas debe ser mayor que cero." }
    }

    // Clase interna para representar cada cabina
    private data class Cabina(val id: Int) {
        var llamadasLocales: Int = 0
        var minutosLocales: Int = 0
        var llamadasLargaDistancia: Int = 0
        var minutosLargaDistancia: Int = 0
        var llamadasCelulares: Int = 0
        var minutosCelulares: Int = 0

        // Método para registrar una llamada en la cabina
        fun registrarLlamada(tipo: String, minutos: Int) {
            require(minutos > 0) { "La duración de la llamada debe ser mayor que cero." }

            when (tipo.lowercase()) {
                "local" -> {
                    llamadasLocales++
                    minutosLocales += minutos
                }
                "larga distancia" -> {
                    llamadasLargaDistancia++
                    minutosLargaDistancia += minutos
                }
                "celular" -> {
                    llamadasCelulares++
                    minutosCelulares += minutos
                }
                else -> throw IllegalArgumentException("Tipo de llamada no válido.")
            }
        }

        // Método para mostrar la información de la cabina
        fun mostrarInfo(): String {
            val totalLlamadas = llamadasLocales + llamadasLargaDistancia + llamadasCelulares
            val totalMinutos = minutosLocales + minutosLargaDistancia + minutosCelulares
            val totalCosto = calcularCostoTotal()

            return """
                |Cabina $id:
                |Total de llamadas: $totalLlamadas
                |Total de minutos: $totalMinutos
                |Costo total: $totalCosto pesos
            """.trimMargin()
        }

        // Método para reiniciar los contadores de la cabina
        fun reiniciar() {
            llamadasLocales = 0
            minutosLocales = 0
            llamadasLargaDistancia = 0
            minutosLargaDistancia = 0
            llamadasCelulares = 0
            minutosCelulares = 0
        }

        // Método para calcular el costo total de las llamadas en la cabina
        fun calcularCostoTotal(): Int {
            return (minutosLocales * TARIFA_LOCAL) +
                    (minutosLargaDistancia * TARIFA_LARGA_DISTANCIA) +
                    (minutosCelulares * TARIFA_CELULAR)
        }

        // Método para obtener un resumen de las estadísticas de la cabina
        fun obtenerResumen(): Triple<Int, Int, Int> {
            val totalLlamadas = llamadasLocales + llamadasLargaDistancia + llamadasCelulares
            val totalMinutos = minutosLocales + minutosLargaDistancia + minutosCelulares
            val totalCosto = calcularCostoTotal()
            return Triple(totalLlamadas, totalMinutos, totalCosto)
        }
    }

    // Método para registrar una llamada en una cabina específica
    fun registrarLlamada(cabinaId: Int, tipo: String, minutos: Int) {
        val cabina = cabinas.getOrNull(cabinaId - 1)
            ?: throw IllegalArgumentException("ID de cabina no válido.")
        cabina.registrarLlamada(tipo, minutos)
    }

    // Método para mostrar la información de una cabina específica
    fun mostrarInfoCabina(cabinaId: Int): String {
        val cabina = cabinas.getOrNull(cabinaId - 1)
            ?: throw IllegalArgumentException("ID de cabina no válido.")
        return cabina.mostrarInfo()
    }

    // Método para reiniciar una cabina específica
    fun reiniciarCabina(cabinaId: Int) {
        val cabina = cabinas.getOrNull(cabinaId - 1)
            ?: throw IllegalArgumentException("ID de cabina no válido.")
        cabina.reiniciar()
    }

    // Método para mostrar el consolidado total de todas las cabinas
    fun mostrarConsolidadoTotal(): String {
        var totalLlamadas = 0
        var totalMinutos = 0
        var totalCosto = 0

        for (cabina in cabinas) {
            val (llamadas, minutos, costo) = cabina.obtenerResumen()
            totalLlamadas += llamadas
            totalMinutos += minutos
            totalCosto += costo
        }

        val costoPromedioPorMinuto = if (totalMinutos > 0) totalCosto / totalMinutos else 0

        return """
            |Consolidado Total:
            |Total de llamadas: $totalLlamadas
            |Total de minutos: $totalMinutos
            |Costo total: $totalCosto pesos
            |Costo promedio por minuto: $costoPromedioPorMinuto pesos/minuto
        """.trimMargin()
    }
}
