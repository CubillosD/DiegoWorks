package Ejercicio

fun main() {
    val empleados = mutableListOf<Empleado>()
    val medicos = mutableListOf<Medico>()
    val pacientes = mutableListOf<Paciente>()
    val citasMedicas = mutableListOf<CitaMedica>()

    while (true) {
        println(
            """
            |*************************************
            |           MENÚ PRINCIPAL            
            |*************************************
            | 1. Registrar un Médico
            | 2. Registrar un Paciente
            | 3. Registrar una Cita Médica
            | 4. Listar Médicos por Especialidad
            | 5. Listar Pacientes por Médico
            | 6. Salir
            |*************************************
            | Seleccione una opción:
            """.trimMargin()
        )

        when (readln().toInt()) {
            1 -> registrarMedico(medicos)
            2 -> registrarPaciente(pacientes)
            3 -> registrarCitaMedica(medicos, pacientes, citasMedicas)
            4 -> listarMedicosPorEspecialidad(medicos)
            5 -> listarPacientesPorMedico(citasMedicas)
            6 -> {
                println("\nCodigo Finalizado!")
                break
            }
            else -> println("\n⚠️ Opción no válida. Por favor, intente de nuevo.\n")
        }
    }
}

fun registrarMedico(medicos: MutableList<Medico>) {
    println("\n*** Registro de Médico ***")
    print("🆔 DNI: ")
    val dniMedico = readln()
    print("📝 Nombre: ")
    val nombreMedico = readln()
    print("📝 Apellido: ")
    val apellidoMedico = readln()
    print("📅 Fecha de nacimiento (dd/MM/yyyy): ")
    val fechaNacimientoMedico = readln()
    print("🏠 Dirección: ")
    val direccionMedico = readln()
    print("🏙️ Ciudad de procedencia: ")
    val ciudadProcedenciaMedico = readln()
    print("👨‍💼 Código de Empleado: ")
    val codigoEmpleado = readln()
    print("🕒 Horas extras: ")
    val horasExtras = readln().toInt()
    print("📅 Fecha de ingreso (dd/MM/yyyy): ")
    val fechaIngreso = readln()
    print("🏢 Área: ")
    val area = readln()
    print("📋 Cargo: ")
    val cargo = readln()
    print("💰 Salario mensual: ")
    val salarioMensual = readln().toDouble()
    print("➕ Porcentaje adicional por hora extra: ")
    val porcentajeAdicionalHoraExtra = readln().toDouble()
    print("🩺 Especialidad: ")
    val especialidad = readln()
    print("🛠️ Servicio: ")
    val servicio = readln()
    print("🏥 Número de consultorio: ")
    val numeroConsultorio = readln().toInt()

    val medico = Medico(
        dniMedico, nombreMedico, apellidoMedico, fechaNacimientoMedico, direccionMedico,
        ciudadProcedenciaMedico, codigoEmpleado, horasExtras, fechaIngreso, area, cargo,
        salarioMensual, porcentajeAdicionalHoraExtra, especialidad, servicio, numeroConsultorio
    )
    medicos.add(medico)
    println("\n✅ Médico registrado exitosamente.\n")
}

fun registrarPaciente(pacientes: MutableList<Paciente>) {
    println("\n*** Registro de Paciente ***")
    print("🆔 DNI: ")
    val dniPaciente = readln()
    print("📝 Nombre: ")
    val nombrePaciente = readln()
    print("📝 Apellido: ")
    val apellidoPaciente = readln()
    print("📅 Fecha de nacimiento (dd/MM/yyyy): ")
    val fechaNacimientoPaciente = readln()
    print("🏠 Dirección: ")
    val direccionPaciente = readln()
    print("🏙️ Ciudad de procedencia: ")
    val ciudadProcedenciaPaciente = readln()
    print("📂 Número de historia clínica: ")
    val numeroHistoriaClinica = readln()
    print("🚻 Sexo: ")
    val sexo = readln()
    print("🩸 Grupo sanguíneo: ")
    val grupoSanguineo = readln()
    print("⚠️ Alergias (separadas por comas): ")
    val alergias = readln().split(",").map { it.trim() }

    val paciente = Paciente(
        dniPaciente, nombrePaciente, apellidoPaciente, fechaNacimientoPaciente,
        direccionPaciente, ciudadProcedenciaPaciente, numeroHistoriaClinica, sexo,
        grupoSanguineo, alergias
    )
    pacientes.add(paciente)
    println("\n✅ Paciente registrado exitosamente.\n")
}

fun registrarCitaMedica(
    medicos: List<Medico>,
    pacientes: List<Paciente>,
    citasMedicas: MutableList<CitaMedica>
) {
    println("\n*** Registro de Cita Médica ***")

    if (medicos.isEmpty() || pacientes.isEmpty()) {
        println("⚠️ Debe registrar al menos un médico y un paciente antes de registrar una cita médica.\n")
        return
    }

    print("🆔 DNI del paciente: ")
    val dniPaciente = readln()
    val paciente = pacientes.find { it.dni == dniPaciente }

    if (paciente == null) {
        println("⚠️ Paciente no encontrado. Por favor, registre el paciente primero.\n")
        return
    }

    print("👨‍⚕️ Código del médico: ")
    val codigoMedico = readln()
    val medico = medicos.find { it.codigoEmpleado == codigoMedico }

    if (medico == null) {
        println("⚠️ Médico no encontrado. Por favor, registre el médico primero.\n")
        return
    }

    print("📅 Fecha de la cita (dd/MM/yyyy): ")
    val fechaCita = readln()
    print("⏰ Hora de la cita (HH:mm): ")
    val horaCita = readln()
    print("🛠️ Servicio: ")
    val servicioCita = readln()

    val cita = CitaMedica(paciente, medico, fechaCita, horaCita, servicioCita)
    citasMedicas.add(cita)
    println("\n✅ Cita médica registrada exitosamente.\n")
}

fun listarMedicosPorEspecialidad(medicos: List<Medico>) {
    println("\n*** Listar Médicos por Especialidad ***")
    print("🔍 Ingrese la especialidad a buscar: ")
    val especialidadBuscada = readln()

    val medicosEspecialidad = medicos.filter { it.especialidad.equals(especialidadBuscada, ignoreCase = true) }

    if (medicosEspecialidad.isEmpty()) {
        println("⚠️ No se encontraron médicos con la especialidad '$especialidadBuscada'.\n")
    } else {
        println("🩺 Médicos con especialidad en '$especialidadBuscada':")
        medicosEspecialidad.forEach {
            println("👨‍⚕️ ${it.nombre} ${it.apellido} - Consultorio: ${it.numeroConsultorio}")
        }
        println()
    }
}

fun listarPacientesPorMedico(citasMedicas: List<CitaMedica>) {
    println("\n*** Listar Pacientes por Médico ***")
    print("🔍 Ingrese el código del médico: ")
    val codigoMedicoBuscado = readln()

    val pacientesAtendidos = citasMedicas.filter { it.medico.codigoEmpleado == codigoMedicoBuscado }

    if (pacientesAtendidos.isEmpty()) {
        println("⚠️ No se encontraron pacientes atendidos por el médico con código '$codigoMedicoBuscado'.\n")
    } else {
        println("👨‍⚕️ Pacientes atendidos por el médico con código '$codigoMedicoBuscado':")
        pacientesAtendidos.forEach {
            println("👤 ${it.paciente.nombre} ${it.paciente.apellido}")
        }
        println()
    }
}
