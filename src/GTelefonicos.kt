class GTelefonicos(numCabinas: Int) {
    private val cabinas: MutableList<Cabina> = MutableList(numCabinas) { Cabina(it + 1) }

    companion object {
        const val TARIFA_LOCAL = 50
        const val TARIFA_LARGA_DISTANCIA = 350
        const val TARIFA_CELULAR = 150
    }

    init {
        require(numCabinas > 0) { "El número de cabinas debe ser mayor que cero." }
    }

    private data class Cabina(val id: Int) {
        var llamadasLocales: Int = 0
        var minutosLocales: Int = 0
        var llamadasLargaDistancia: Int = 0
        var minutosLargaDistancia: Int = 0
        var llamadasCelulares: Int = 0
        var minutosCelulares: Int = 0

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

        fun mostrarInfo(): String {
            val totalLlamadas = llamadasLocales + llamadasLargaDistancia + llamadasCelulares
            val totalMinutos = minutosLocales + minutosLargaDistancia + minutosCelulares
            val totalCosto = calcularCostoTotal()

            return """
                    ╔═════════════════════════════════╗
                                 Cabina $id                     
                    ╚═════════════════════════════════╝
                        Total de llamadas: $totalLlamadas                 
                        Total de minutos: $totalMinutos                  
                        Costo total: $totalCosto pesos               
                    ═══════════════════════════════════
                
            """.trimMargin()
        }

        fun reiniciar() {
            llamadasLocales = 0
            minutosLocales = 0
            llamadasLargaDistancia = 0
            minutosLargaDistancia = 0
            llamadasCelulares = 0
            minutosCelulares = 0
        }

        fun calcularCostoTotal(): Int {
            return (minutosLocales * TARIFA_LOCAL) +
                    (minutosLargaDistancia * TARIFA_LARGA_DISTANCIA) +
                    (minutosCelulares * TARIFA_CELULAR)
        }

        fun obtenerResumen(): Triple<Int, Int, Int> {
            val totalLlamadas = llamadasLocales + llamadasLargaDistancia + llamadasCelulares
            val totalMinutos = minutosLocales + minutosLargaDistancia + minutosCelulares
            val totalCosto = calcularCostoTotal()
            return Triple(totalLlamadas, totalMinutos, totalCosto)
        }
    }

    fun registrarLlamada(cabinaId: Int, tipo: String, minutos: Int) {
        val cabina = cabinas.getOrNull(cabinaId - 1)
            ?: throw IllegalArgumentException("ID de cabina no válido.")
        cabina.registrarLlamada(tipo, minutos)
    }

    fun mostrarInfoCabina(cabinaId: Int): String {
        val cabina = cabinas.getOrNull(cabinaId - 1)
            ?: throw IllegalArgumentException("ID de cabina no válido.")
        return cabina.mostrarInfo()
    }

    fun reiniciarCabina(cabinaId: Int) {
        val cabina = cabinas.getOrNull(cabinaId - 1)
            ?: throw IllegalArgumentException("ID de cabina no válido.")
        cabina.reiniciar()
    }

    fun mostrarConsolidadoTotal(): String {
        var totalLlamadas = 0
        var totalMinutos = 0
        var totalCosto = 0

        // StringBuilder para consolidar la información de todas las cabinas
        val builder = StringBuilder()

        for (cabina in cabinas) {
            val (llamadas, minutos, costo) = cabina.obtenerResumen()
            totalLlamadas += llamadas
            totalMinutos += minutos
            totalCosto += costo

            // Añadir información de cada cabina al builder
            builder.append(cabina.mostrarInfo()).append("\n")
        }

        val costoPromedioPorMinuto = if (totalMinutos > 0) totalCosto / totalMinutos else 0

        // Añadir el resumen total al builder
        builder.append("""
            
                    ╔═════════════════════════════════╗
                            Consolidado Total
                    ╚═════════════════════════════════╝
                        Total de llamadas: $totalLlamadas
                        Total de minutos: $totalMinutos
                        Costo total: $totalCosto pesos
                        Costo promedio por minuto: $costoPromedioPorMinuto pesos/minuto
                 ══════════════════════════════════════════
        """.trimMargin())

        return builder.toString()
    }

    fun agregarCabina() {
        val nuevaCabinaId = cabinas.size + 1
        cabinas.add(Cabina(nuevaCabinaId))
        println("Se ha agregado una nueva cabina con ID: $nuevaCabinaId")
    }
}
