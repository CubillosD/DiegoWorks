package Ejercicio
// Clase base Persona
open class Persona(
    val dni: String,
    val nombre: String,
    val apellido: String,
    val fechaNacimiento: String,
    val direccion: String,
    val ciudadProcedencia: String
)

// Clase Paciente que hereda de Persona
class Paciente(
    dni: String,
    nombre: String,
    apellido: String,
    fechaNacimiento: String,
    direccion: String,
    ciudadProcedencia: String,
    val numeroHistoriaClinica: String,
    val sexo: String,
    val grupoSanguineo: String,
    val alergias: List<String>
) : Persona(dni, nombre, apellido, fechaNacimiento, direccion, ciudadProcedencia)

// Clase base Empleado que hereda de Persona
open class Empleado(
    dni: String,
    nombre: String,
    apellido: String,
    fechaNacimiento: String,
    direccion: String,
    ciudadProcedencia: String,
    val codigoEmpleado: String,
    val horasExtras: Int,
    val fechaIngreso: String,
    val area: String,
    val cargo: String
) : Persona(dni, nombre, apellido, fechaNacimiento, direccion, ciudadProcedencia)

// Clase EmpleadoPorPlanilla que hereda de Empleado
open class EmpleadoPorPlanilla(
    dni: String,
    nombre: String,
    apellido: String,
    fechaNacimiento: String,
    direccion: String,
    ciudadProcedencia: String,
    codigoEmpleado: String,
    horasExtras: Int,
    fechaIngreso: String,
    area: String,
    cargo: String,
    val salarioMensual: Double,
    val porcentajeAdicionalHoraExtra: Double
) : Empleado(dni, nombre, apellido, fechaNacimiento, direccion, ciudadProcedencia, codigoEmpleado, horasExtras, fechaIngreso, area, cargo)

// Clase EmpleadoEventual que hereda de Empleado
open class EmpleadoEventual(
    dni: String,
    nombre: String,
    apellido: String,
    fechaNacimiento: String,
    direccion: String,
    ciudadProcedencia: String,
    codigoEmpleado: String,
    horasExtras: Int,
    fechaIngreso: String,
    area: String,
    cargo: String,
    val honorariosPorHora: Double,
    val horasTotales: Int,
    val fechaTerminoContrato: String
) : Empleado(dni, nombre, apellido, fechaNacimiento, direccion, ciudadProcedencia, codigoEmpleado, horasExtras, fechaIngreso, area, cargo)

// Clase Medico que hereda de EmpleadoPorPlanilla
class Medico(
    dni: String,
    nombre: String,
    apellido: String,
    fechaNacimiento: String,
    direccion: String,
    ciudadProcedencia: String,
    codigoEmpleado: String,
    horasExtras: Int,
    fechaIngreso: String,
    area: String,
    cargo: String,
    salarioMensual: Double,
    porcentajeAdicionalHoraExtra: Double,
    val especialidad: String,
    val servicio: String,
    val numeroConsultorio: Int
) : EmpleadoPorPlanilla(dni, nombre, apellido, fechaNacimiento, direccion, ciudadProcedencia, codigoEmpleado, horasExtras, fechaIngreso, area, cargo, salarioMensual, porcentajeAdicionalHoraExtra)

// Clase para registrar las citas médicas
class CitaMedica(
    val paciente: Paciente,
    val medico: Medico,
    val fecha: String,
    val hora: String,
    val servicio: String
)