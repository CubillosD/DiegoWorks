import java.util.Scanner

fun main() {
    val coleccion = mutableListOf<MedioDigital>()
    val scanner = Scanner(System.`in`)

    while (true) {
        mostrarMenuPrincipal()

        when (scanner.nextInt()) {
            1 -> agregarMedio(coleccion, scanner)
            2 -> mostrarColeccion(coleccion)
            3 -> mostrarInformacionMedio(coleccion, scanner)
            4 -> eliminarMedio(coleccion, scanner)
            5 -> {
                println("\n--- Finalizando aplicación... X_X ---")
                break
            }
            else -> println("\nOpción no válida, por favor intente nuevamente.")
        }
    }
}

fun mostrarMenuPrincipal() {
    println("╔═════════════════════════════════╗")
    println("║         MENU PRINCIPAL          ║")
    println("╠═════════════════════════════════╣")
    println("║ 1. Agregar Medio                ║")
    println("║ 2. Mostrar Coleccion            ║")
    println("║ 3. Mostrar Informacion del Medio║")
    println("║ 4. Eliminar Medio               ║")
    println("║ 5. Salir                        ║")
    println("╚═════════════════════════════════╝")
    print("Seleccione una opción: ")
}

fun agregarMedio(coleccion: MutableList<MedioDigital>, scanner: Scanner) {
    println("\n╔═════════════════════════════════╗")
    println("║ SELECCIONE EL MEDIO A AGREGAR   ║")
    println("╠═════════════════════════════════╣")
    println("║ 1. Libro Electronico            ║")
    println("║ 2. Audiolibro                   ║")
    println("╚═════════════════════════════════╝")
    print("Opción: ")

    when (scanner.nextInt()) {
        1 -> {
            scanner.nextLine()
            print("Titulo: ")
            val titulo = scanner.nextLine()
            print("Autor: ")
            val autor = scanner.nextLine()
            print("Año de Publicacion: ")
            val añoPublicacion = scanner.nextInt()
            scanner.nextLine()
            print("Número de Páginas: ")
            val numeroPaginas = scanner.nextInt()

            coleccion.add(LibroElectronico(titulo, autor, añoPublicacion, numeroPaginas))
            println("\n--- Libro Electronico agregado exitosamente. ---")
        }
        2 -> {
            scanner.nextLine()
            print("Título: ")
            val titulo = scanner.nextLine()
            print("Autor: ")
            val autor = scanner.nextLine()
            print("Año de Publicacion: ")
            val añoPublicacion = scanner.nextInt()
            scanner.nextLine()
            print("Narrador: ")
            val narrador = scanner.nextLine()

            coleccion.add(Audiolibro(titulo, autor, añoPublicacion, narrador))
            println("\n--- Audiolibro agregado exitosamente. ---")
        }
        else -> {
            println("\nOpcion no válida.")
        }
    }

    println()
    print("Oprima Enter para volver al menu principal...")
    scanner.nextLine() // Esperar la entrada del usuario
}

fun mostrarColeccion(coleccion: List<MedioDigital>) {
    println("\n╔═════════════════════════════════╗")
    println("║       COLECCION DE MEDIOS       ║")
    println("╚═════════════════════════════════╝")
    println()

    val librosElectronicos = coleccion.filterIsInstance<LibroElectronico>()
    val audiolibros = coleccion.filterIsInstance<Audiolibro>()

    if (librosElectronicos.isEmpty() && audiolibros.isEmpty()) {
        println("La colección está vacía.")
    } else {
        if (librosElectronicos.isNotEmpty()) {
            println("Libros Electrónicos:")
            librosElectronicos.forEachIndexed { index, medio ->
                println("${index + 1}. ${medio.titulo} (Autor: ${medio.autor})")
                println()
            }
        }

        if (audiolibros.isNotEmpty()) {
            println("Audiolibros:")
            audiolibros.forEachIndexed { index, medio ->
                println("${index + 1}. ${medio.titulo} (Autor: ${medio.autor})")
                println()
            }
        }
    }
}

fun mostrarInformacionMedio(coleccion: List<MedioDigital>, scanner: Scanner) {
    if (coleccion.isEmpty()) {
        println("La colección está vacía.")
        return
    }

    println("\n╔═════════════════════════════════╗")
    println("║      SELECCIONE EL MEDIO        ║   ")
    println("╚═════════════════════════════════╝")

    coleccion.forEachIndexed { index, medio ->
        println("${index + 1}. ${medio.titulo} (Autor: ${medio.autor})")
        println()
    }

    print("Ingrese el número del medio que desea ver: ")
    val indice = scanner.nextInt()

    if (indice in 1..coleccion.size) {
        println()
        coleccion[indice - 1].mostrarInformacion()
    } else {
        println("Número no válido.")
    }
}

fun eliminarMedio(coleccion: MutableList<MedioDigital>, scanner: Scanner) {
    if (coleccion.isEmpty()) {
        println("La colección está vacía.")
        return
    }

    println("\n╔═════════════════════════════════╗")
    println("║        ELIMINAR UN MEDIO        ║")
    println("╚═════════════════════════════════╝")
    coleccion.forEachIndexed { index, medio ->
        println("${index + 1}. ${medio.titulo} (Autor: ${medio.autor})")
        println("")
    }

    print("Ingrese el número del medio que desea eliminar: ")
    val indice = scanner.nextInt()

    if (indice in 1..coleccion.size) {
        coleccion.removeAt(indice - 1)
        println("\n--- Medio eliminado exitosamente. ---")
    } else {
        println("Número no válido.")
    }
}




