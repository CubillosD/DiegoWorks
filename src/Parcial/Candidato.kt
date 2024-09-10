package Parcial

data class Candidato(
    val nombre: String,
    var votosInternet: Int = 0,
    var votosRadio: Int = 0,
    var votosTV: Int = 0
) {
    fun calcularCostoCampaña(): Int {
        val costoInternet = votosInternet * 700000
        val costoRadio = votosRadio * 200000
        val costoTV = votosTV * 600000
        return costoInternet + costoRadio + costoTV
    }

    fun totalVotos(): Int {
        return votosInternet + votosRadio + votosTV
    }
}
