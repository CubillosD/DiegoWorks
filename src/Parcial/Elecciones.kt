package Parcial
class Elecciones(val candidatos: List<Candidato>) {

    fun votar(candidato: Candidato, medio: String) {
        when (medio.lowercase()) {
            "internet" -> candidato.votosInternet++
            "radio" -> candidato.votosRadio++
            "televisión", "tv" -> candidato.votosTV++
            else -> println("Medio de comunicación no válido")
        }
    }

    fun vaciarUrnas() {
        for (candidato in candidatos) {
            candidato.votosInternet = 0
            candidato.votosRadio = 0
            candidato.votosTV = 0
        }
    }

    fun totalVotos(): Int {
        return candidatos.sumOf { it.totalVotos() }
    }

    fun porcentajeVotos(candidato: Candidato): Double {
        val totalVotos = totalVotos()
        return if (totalVotos > 0) {
            (candidato.totalVotos().toDouble() / totalVotos) * 100
        } else {
            0.0
        }
    }

    fun costoPromedioCampaña(): String {
        return if (candidatos.isNotEmpty()) {
            val promedio = candidatos.sumOf { it.calcularCostoCampaña() } / candidatos.size.toDouble()
            String.format("%.2f", promedio)
        } else {
            "0.00"
        }
    }

    fun candidatoGanador(): Candidato? {
        return candidatos.maxByOrNull { it.totalVotos() }
    }
}
