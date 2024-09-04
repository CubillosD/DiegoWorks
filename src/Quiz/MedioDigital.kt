// Definición de clases
open class MedioDigital(
    val titulo: String,
    val autor: String,
    val añoPublicacion: Int
) {
    open fun mostrarInformacion() {
        println("Título: $titulo")
        println("Autor: $autor")
        println("Año de Publicación: $añoPublicacion")
    }
}