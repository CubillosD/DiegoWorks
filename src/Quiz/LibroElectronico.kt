class LibroElectronico(
    titulo: String,
    autor: String,
    añoPublicacion: Int,
    val numeroPaginas: Int
) : MedioDigital(titulo, autor, añoPublicacion) {

    override fun mostrarInformacion() {
        println("╔═══════════════════════════════")
        println("║ Libro Electrónico:")
        println("║ Título: $titulo")
        println("║ Autor: $autor")
        println("║ Año de Publicación: $añoPublicacion")
        println("║ Número de Páginas: $numeroPaginas")
        println("╚═══════════════════════════════")
    }
}

class Audiolibro(
    titulo: String,
    autor: String,
    añoPublicacion: Int,
    val narrador: String
) : MedioDigital(titulo, autor, añoPublicacion) {

    override fun mostrarInformacion() {
        println("╔═════════════════════════════════")
        println("║ Audiolibro:")
        println("║ Título: $titulo")
        println("║ Autor: $autor")
        println("║ Año de Publicación: $añoPublicacion")
        println("║ Narrador: $narrador")
        println("╚══════════════════════════════════")
    }
}