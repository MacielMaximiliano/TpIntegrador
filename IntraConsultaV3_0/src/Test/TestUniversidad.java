package Test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.junit.Test;

import Dominio.*;

//Se deberán generar las siguientes Funcionalidades

public class TestUniversidad {

	@Test
	// universidad agregar materias
	public void AgregarMaterias() {
		// materia id Nombre

		// Preparacion
		Uni uni = new Uni("unlam");
		Materia materia = new Materia("pbi");

		// validacion
		assertTrue(uni.registrarMateria(materia));
		assertNotNull(uni.buscarMateria(materia.getId()));

	}

	@Test
	public void queNoSePuedaAgregarMaterias() {
		// Preparacion
		Uni uni = new Uni("unlam");
		Materia materia = new Materia("pbi");
		uni.registrarMateria(materia);
		Materia materia2 = new Materia("pbi");
		// validacion
		assertFalse(uni.registrarMateria(materia2));
		assertFalse(uni.registrarMateria(materia));
	}

	@Test
	// universidad agregar alumnos
	public void AgregarAlumnos() {
		// Preparacion
		// Alumnos Id, nombre, Apellido , Fecha Nacimiento, fechaIngreso
		String nombre = "maxi";
		String apellido = "Maciel";
		Integer dni = 36183763;
		LocalDate fechaNac = LocalDate.of(1990, 12, 31);
		LocalDate fechaIngreso = LocalDate.of(2022, 4, 20);

		Uni uni = new Uni("unlam");
		Alumno alumno = new Alumno(dni, apellido, nombre, fechaNac, fechaIngreso);

		// validacion
		assertTrue(uni.registrarAlumno(alumno));
		assertNotNull(uni.buscarAlumnoPorDni(alumno.getDni()));
	}

	@Test
	public void queNoSePuedaAgregarAlumnos() {
		// Preparacion
		String nombre = "maxi";
		String apellido = "Maciel";
		Integer dni = 36183763;
		LocalDate fechaNac = LocalDate.of(1990, 12, 31);
		LocalDate fechaIngreso = LocalDate.of(2022, 4, 20);

		Uni uni = new Uni("unlam");
		Alumno alumno = new Alumno(dni, apellido, nombre, fechaNac, fechaIngreso);
		Alumno alumno2 = new Alumno(dni, "asd", "asdas", fechaNac, fechaIngreso);

		

		// validacion
		assertTrue(uni.registrarAlumno(alumno));
		assertFalse(uni.registrarAlumno(alumno));
		assertFalse(uni.registrarAlumno(alumno2));
	}

	@Test
	// universidad crear ciclos lectivos
	public void CrearCicloLectivo() {
		// CicloLectivo . Id, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
		// fechaInicioInscripcion, fechaFinalizacionInscripcion
		// Preparacion
		LocalDate fechaNac = LocalDate.of(1990, 12, 31);
		LocalDate fechaIngreso = LocalDate.of(2022, 12, 31);
		LocalDate fechaInicioCicloLectivo = LocalDate.of(1990, 12, 31);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(1990, 12, 31);
		LocalDate fechaInicioInscripcion = LocalDate.of(1990, 12, 31);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(1990, 12, 31);
		Uni uni = new Uni("unlam");
		Ciclo ciclo = new Ciclo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo, fechaInicioInscripcion,
				fechaFinalizacionInscripcion);

		// validacion
		assertTrue(uni.registrarCicloLect(ciclo));
		assertNotNull(uni.buscarCicloLect(ciclo.getId()));
	}

	@Test
	public void queNoSePuedaAgregarCicloLectivo() {

		// Preparacion

		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 1, 1);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 2, 2);
		LocalDate fechaInicioInscripcion = LocalDate.of(1990, 12, 31);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(1990, 12, 31);
		Uni uni = new Uni("unlam");
		Ciclo ciclo = new Ciclo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo, fechaInicioInscripcion,
				fechaFinalizacionInscripcion);

		LocalDate fechaInicioCicloLectivo2 = LocalDate.of(2023, 2, 1);
		LocalDate fechaFinalizacionCicloLectivo2 = LocalDate.of(2023, 2, 2);
		LocalDate fechaInicioInscripcion2 = LocalDate.of(1990, 12, 31);
		LocalDate fechaFinalizacionInscripcion2 = LocalDate.of(1990, 12, 31);

		Ciclo ciclo2 = new Ciclo(fechaInicioCicloLectivo2, fechaFinalizacionCicloLectivo2, fechaInicioInscripcion2,
				fechaFinalizacionInscripcion2);

		// validacion
		assertTrue(uni.registrarCicloLect(ciclo));
		assertFalse(uni.registrarCicloLect(ciclo));
		assertFalse(uni.registrarCicloLect(ciclo2));

	}

	@Test
//crearDocentes
	public void AgregarProfe() {
		// Preparacion
		String nombre = "maxi";
		String apellido = "Maciel";
		Integer dni = 36183763;
		LocalDate fechaNac = LocalDate.of(1990, 12, 31);
		LocalDate fechaIngreso = LocalDate.of(2022, 4, 20);
		Uni uni = new Uni("unlam");
		Profe profe = new Profe(dni, apellido, nombre, fechaNac, fechaIngreso);

		// validacion
		assertTrue(uni.registrarProfe(profe));
		assertNotNull(uni.buscarProfe(profe.getDni()));
	}

	@Test
	public void queNoSePuedaAgregarUnProfe() {
		// Preparacion
		String nombre = "maxi";
		String apellido = "Maciel";
		Integer dni = 36183763;
		LocalDate fechaNac = LocalDate.of(1990, 12, 31);
		LocalDate fechaIngreso = LocalDate.of(2022, 4, 20);

		Uni uni = new Uni("unlam");
		Profe profe = new Profe(dni, apellido, nombre, fechaNac, fechaIngreso);

		Profe profe2 = new Profe(dni, "adas", "dasdas", fechaNac, fechaIngreso);

		// validacion
		assertTrue(uni.registrarProfe(profe));
		assertFalse(uni.registrarProfe(profe));
		assertFalse(uni.registrarProfe(profe2));

	}

	@Test

	public void AgregarAula() {
		// Aula id, Cantidad De Alumnos
		// Preparacion
		Uni uni = new Uni("unlam");
		Integer cantAlumn = 100;
		Integer NumAula = 10;

		Aula aula = new Aula(NumAula, cantAlumn);

		// validacion
		assertTrue(uni.registrarAula(aula));
		assertNotNull(uni.buscarAula(aula.getNumAula()));
	}

	@Test
	public void queNoSePuedaAgregarAulas() {
		// Preparacion
		Uni uni = new Uni("unlam");
		Integer cantAlumn = 100;
		Integer NumAula = 10;

		Aula aula = new Aula(NumAula, cantAlumn);
		Aula aula2 = new Aula(NumAula, 213);

		// validacion
		assertTrue(uni.registrarAula(aula));
		assertFalse(uni.registrarAula(aula));
		assertFalse(uni.registrarAula(aula2));
	}

	@Test
	// CrearCurso
	public void CrearCurso() {
		// Comisión id, Materia, y cicloLectivo, Turno
		// Preparacion
		Uni uni = new Uni("unlam");
		LocalDate fechaNac = LocalDate.of(1990, 12, 31);
		LocalDate fechaIngreso = LocalDate.of(2022, 12, 31);
		LocalDate fechaInicioCicloLectivo = LocalDate.of(1990, 12, 31);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(1990, 12, 31);
		LocalDate fechaInicioInscripcion = LocalDate.of(1990, 12, 31);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(1990, 12, 31);
		Ciclo ciclo = new Ciclo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo, fechaInicioInscripcion,
				fechaFinalizacionInscripcion);
		Integer cantAlumn = 100;
		Integer NumAula = 10;
		Turno turno = Turno.Mañana;
		Dias dias = Dias.Lun_Mie;

		Ciclo ciclo2 = new Ciclo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo, fechaInicioInscripcion,
				fechaFinalizacionInscripcion);

		Materia materia = new Materia("pbi");
		Materia materia2 = new Materia("pbi");
		Aula aula = new Aula(NumAula, cantAlumn);
		Aula aula2 = new Aula(NumAula, cantAlumn);

		uni.registrarAula(aula);
		uni.registrarMateria(materia);
		uni.registrarMateria(materia2);
		uni.registrarCicloLect(ciclo);

		Curso curso = new Curso(aula, ciclo, materia, turno, dias);
		uni.registrarCurso(curso);
		Curso curso2 = uni.buscarCurso(curso.getId());
		Curso curso3 = new Curso(aula2, ciclo2, materia2, turno, dias);

		// validacion
		assertNotNull(uni.registrarCurso(curso));
		assertEquals(curso, curso2);
		assertFalse(uni.registrarCurso(curso3));

	}

	@Test
	// CrearCurso
	public void queNoSeCrearCurso() {
		// No se Pueden generar 2 Comisiones para la misma materia, el mismo
		// cicloLectivo y el mismo turno
		// Comisión id, Materia, y cicloLectivo, Turno
		// Preparacion
		Uni uni = new Uni("unlam");
		LocalDate fechaNac = LocalDate.of(1990, 12, 31);
		LocalDate fechaIngreso = LocalDate.of(2022, 12, 31);
		LocalDate fechaInicioCicloLectivo = LocalDate.of(1990, 12, 31);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(1990, 12, 31);
		LocalDate fechaInicioInscripcion = LocalDate.of(1990, 12, 31);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(1990, 12, 31);
		Ciclo ciclo = new Ciclo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo, fechaInicioInscripcion,
				fechaFinalizacionInscripcion);
		Integer cantAlumn = 100;
		Integer NumAula = 10;
		Turno turno = Turno.Mañana;
		Dias dias = Dias.Lun_Mie;

		Ciclo ciclo2 = new Ciclo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo, fechaInicioInscripcion,
				fechaFinalizacionInscripcion);

		Materia materia = new Materia("pbi");
		Materia materia2 = new Materia("pbi");
		Materia materia3 = new Materia("pbi");
		Aula aula = new Aula(NumAula, cantAlumn);
		Aula aula2 = new Aula(NumAula, cantAlumn);

		uni.registrarAula(aula);
		uni.registrarMateria(materia);
		uni.registrarCicloLect(ciclo);

		Curso curso = new Curso(aula, ciclo, materia, turno, dias);
		Curso curso2 = new Curso(aula2, ciclo, materia2, turno, dias);
		Curso curso3 = new Curso(aula2, ciclo2, materia2, turno, dias);
		Curso curso4 = new Curso(aula2, ciclo, materia3, turno, dias);

		// validacion
		assertTrue(uni.registrarCurso(curso));
		assertFalse(uni.registrarCurso(curso));
		assertFalse(uni.registrarCurso(curso2));
		assertFalse(uni.registrarCurso(curso3));
		assertFalse(uni.registrarCurso(curso4));
	}

	@Test

	public void AgregarMateriasCorrelatibas() {

		// AsiganarMateriaCorrelativa (código Materia, código DeMateria Correlativa)
		// Preparacion
		Uni uni = new Uni("unlam");

		Materia materia = new Materia("BaseDeDatos");
		Materia materia2 = new Materia("Matematicas");
		Materia materia3 = new Materia("informatica");
		assertTrue(uni.registrarMateria(materia));
		assertTrue(uni.registrarMateria(materia2));
		assertTrue(uni.registrarMateria(materia3));

		assertTrue(uni.agregarCorrelativas(materia.getId(), materia3.getId()));
		Materia materiaEssperada = uni.buscarMateria(materia.getId());

		assertTrue(materiaEssperada.getCorrelativas().contains(materia3));

	}

	@Test
	public void eliminarcorrelativas() {
		Uni uni = new Uni("unlam");

		Materia materia = new Materia("BaseDeDatos");
		Materia materia2 = new Materia("Matematicas");
		Materia materia3 = new Materia("informatica");
		assertTrue(uni.registrarMateria(materia));
		assertTrue(uni.registrarMateria(materia2));
		assertTrue(uni.registrarMateria(materia3));

		assertTrue(uni.agregarCorrelativas(materia.getId(), materia3.getId()));
		Materia materiaEssperada = uni.buscarMateria(materia.getId());
		assertTrue(materiaEssperada.getCorrelativas().contains(materia3));

		assertTrue(uni.eliminarCorrelativa(materia.getId(), materia3.getId()));
		assertFalse(uni.eliminarCorrelativa(materia.getId(), materia3.getId()));
		assertFalse(materiaEssperada.getCorrelativas().contains(materia3));

	}

	@Test
	public void InscribirAlumnoACurso() {
		// InscribirAlumnoACurso (dni, CodigoCurso)

		// Preparacion
		Uni uni = new Uni("unlam");

		LocalDate fechaNac = LocalDate.of(1990, 12, 31);
		LocalDate fechaIngreso = LocalDate.of(2022, 12, 31);
		LocalDate fechaInicioCicloLectivo = LocalDate.of(1990, 12, 31);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(1990, 12, 31);

		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 8, 8);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 12, 31);
		Ciclo ciclo = new Ciclo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo, fechaInicioInscripcion,
				fechaFinalizacionInscripcion);
		Turno turno = Turno.Mañana;
		Dias dias = Dias.Mar_Jue;

		Alumno alumno = new Alumno(36183763, "maxi", "Maciel", fechaNac, fechaIngreso);
		Materia materia = new Materia("pbi");
		Aula aula = new Aula(1, 10);

		Curso curso = new Curso(aula, ciclo, materia, turno, dias);

		uni.registrarAula(aula);
		uni.registrarMateria(materia);
		uni.registrarCicloLect(ciclo);
		uni.registrarAlumno(alumno);
		uni.registrarCurso(curso);

		// validacion
		assertTrue(uni.inscribirAlumnoACurso(alumno.getDni(), curso.getId()));
		assertNotNull(uni.buscarAlumnoCurso(alumno, curso));

	}

	@Test
	public void QueNoSePuedaInscribirAlumnoACurso() {
		// InscribirAlumnoACurso (dni, CodigoCurso)

		// Preparacion
		Uni uni = new Uni("unlam");
		LocalDate fechaNac = LocalDate.of(1990, 12, 31);
		LocalDate fechaIngreso = LocalDate.of(2022, 12, 31);
		LocalDate fechaInicioCicloLectivo = LocalDate.of(1990, 12, 31);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(1990, 12, 31);

		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 8, 8);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 12, 31);
		;
		Ciclo ciclo = new Ciclo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo, fechaInicioInscripcion,
				fechaFinalizacionInscripcion);
		Turno turno = Turno.Mañana;
		Dias dias = Dias.Mar_Jue;

		Alumno alumno = new Alumno(36183763, "maxi", "Maciel", fechaNac, fechaIngreso);
		Alumno alumno2 = new Alumno(36, "maxi", "Maciel", fechaNac, fechaIngreso);
		Alumno alumno3 = new Alumno(361, "maxi", "Maciel", fechaNac, fechaIngreso);
		Alumno alumno4 = new Alumno(3618, "maxi", "Maciel", fechaNac, fechaIngreso);
		Materia materia = new Materia("pbi");
		Aula aula = new Aula(1, 2);

		Curso curso = new Curso(aula, ciclo, materia, turno, dias);

		uni.registrarAula(aula);
		uni.registrarMateria(materia);
		uni.registrarCicloLect(ciclo);
		uni.registrarAlumno(alumno);
		uni.registrarAlumno(alumno2);
		uni.registrarAlumno(alumno3);
		uni.registrarAlumno(alumno4);
		uni.registrarCurso(curso);

		// validacion
		// No se puede inscribir el alumno si excede la cantidad de alumnos permitos en
		// el aula
		// La inscripción no se puede realizar si esta fuera de fecha Inscripción
		// No se puede inscribir el Alumno si ya está inscripto a otro curso para el
		// mismo día y Turno
		assertTrue(uni.inscribirAlumnoACurso(alumno.getDni(), curso.getId()));
		assertTrue(uni.inscribirAlumnoACurso(alumno2.getDni(), curso.getId()));
		assertTrue(uni.inscribirAlumnoACurso(alumno3.getDni(), curso.getId()));
		assertFalse(uni.inscribirAlumnoACurso(alumno3.getDni(), curso.getId()));
	}

	@Test
	public void RegistrarNotaAAlumnoACurso() {
		// Preparacion
		Uni uni = new Uni("unlam");
		LocalDate fechaNac = LocalDate.of(1990, 12, 31);
		LocalDate fechaIngreso = LocalDate.of(2022, 12, 31);
		LocalDate fechaInicioCicloLectivo = LocalDate.of(1990, 12, 31);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(1990, 12, 31);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 8, 8);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 12, 31);
		Ciclo ciclo = new Ciclo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo, fechaInicioInscripcion,
				fechaFinalizacionInscripcion);
		Turno turno = Turno.Mañana;
		Dias dias = Dias.Mar_Jue;

		Alumno alumno = new Alumno(36183763, "maxi", "Maciel", fechaNac, fechaIngreso);
		Materia materia = new Materia("pbi");
		Aula aula = new Aula(1, 10);

		Curso curso = new Curso(aula, ciclo, materia, turno, dias);

		uni.registrarAula(aula);
		uni.registrarMateria(materia);
		uni.registrarCicloLect(ciclo);
		uni.registrarAlumno(alumno);
		uni.registrarCurso(curso);
		uni.inscribirAlumnoACurso(alumno.getDni(), curso.getId());
		Nota nota = new Nota();
		assertTrue(uni.registrarNota(curso.getId(), alumno.getDni(), 7, TipoNota.PrimerParcial));

		// registrarNota (idComision, idAlumno, nota)

		// No se puede asignar Una nota Mayor o igual a 7 si no están todas las
		// correlativas aprobadas (Mayor o igual a 7)

	}

	@Test
	public void obtenerNota() {

		// obtenerNota(idAlumno, idMateria)
		Uni uni = new Uni("unlam");
		LocalDate fechaNac = LocalDate.of(1990, 12, 31);
		LocalDate fechaIngreso = LocalDate.of(2022, 12, 31);
		LocalDate fechaInicioCicloLectivo = LocalDate.of(1990, 12, 31);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(1990, 12, 31);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 8, 8);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 12, 31);

		Ciclo ciclo = new Ciclo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo, fechaInicioInscripcion,
				fechaFinalizacionInscripcion);
		Turno turno = Turno.Mañana;
		Dias dias = Dias.Mar_Jue;

		Alumno alumno = new Alumno(36183763, "maxi", "Maciel", fechaNac, fechaIngreso);
		Materia materia = new Materia("pbi");
		Aula aula = new Aula(1, 10);

		Curso curso = new Curso(aula, ciclo, materia, turno, dias);

		uni.registrarAula(aula);
		uni.registrarMateria(materia);
		uni.registrarCicloLect(ciclo);

		uni.registrarAlumno(alumno);
		uni.registrarCurso(curso);
		uni.inscribirAlumnoACurso(alumno.getDni(), curso.getId());
		Nota nota = new Nota();
		uni.registrarNota(curso.getId(), alumno.getDni(), 7, TipoNota.PrimerParcial);
		TipoNota tipoNota = TipoNota.PrimerParcial;
		Integer aux = 7;
		assertEquals(aux, uni.obtenerNota(alumno.getDni(), materia.getId(), tipoNota));

		uni.registrarNota(curso.getId(), alumno.getDni(), 7, TipoNota.SegundoParcial);

		assertEquals(aux, uni.obtenerNota(alumno.getDni(), materia.getId(), TipoNota.SegundoParcial));

		CondFinal condFinal = CondFinal.Promocionado;

		assertEquals(condFinal, uni.obtenerCondFinal(alumno.getDni(), materia.getId()));

		// uni.obtenerNota(alumno.getDni(), materia.getId());

	}

	@Test
	public void asignarProfeCurso() {

		Uni uni = new Uni("unlam");
		LocalDate fechaNac = LocalDate.of(1990, 12, 31);
		LocalDate fechaIngreso = LocalDate.of(2022, 12, 31);
		LocalDate fechaInicioCicloLectivo = LocalDate.of(1990, 12, 31);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(1990, 12, 31);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 8, 8);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 12, 31);
		;
		Ciclo ciclo = new Ciclo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo, fechaInicioInscripcion,
				fechaFinalizacionInscripcion);
		Turno turno = Turno.Mañana;
		Dias dias = Dias.Mar_Jue;
		Dias dias2 = Dias.Mar_Jue;

		Alumno alumno = new Alumno(36183763, "maxi", "Maciel", fechaNac, fechaIngreso);
		Alumno alumno2 = new Alumno(361383763, "maxi", "Maciel", fechaNac, fechaIngreso);
		Materia materia = new Materia("pbi");
		Materia materia2 = new Materia("pb2");

		Aula aula = new Aula(1, 10);
		Profe profe = new Profe(141, "ads", "adas", fechaNac, fechaNac);
		Profe profe2 = new Profe(1412, "ads", "adas", fechaNac, fechaNac);

		uni.registrarAula(aula);
		uni.registrarMateria(materia);
		uni.registrarMateria(materia2);
		uni.registrarCicloLect(ciclo);
		uni.registrarAlumno(alumno);
		uni.registrarProfe(profe);
		uni.registrarProfe(profe2);
		Curso curso = new Curso(aula, ciclo, materia, turno, dias);
		Curso curso2 = new Curso(aula, ciclo, materia, turno, dias2);
		uni.registrarCurso(curso);
		uni.registrarCurso(curso2);
		uni.inscribirAlumnoACurso(alumno.getDni(), curso.getId());
		uni.inscribirAlumnoACurso(alumno2.getDni(), curso2.getId());

		uni.registrarNota(curso.getId(), alumno.getDni(), 7, TipoNota.PrimerParcial);
		// AsignarProfesoresALCurso(idCurso, dniDocente)

		Integer a = 1;
		assertTrue(uni.asignarProfesoresALCurso(curso.getId(), profe.getDni()));
		assertFalse(uni.asignarProfesoresALCurso(curso2.getId(), profe.getDni()));
		assertFalse(uni.asignarProfesoresALCurso(curso2.getId(), profe2.getDni()));
		assertFalse(uni.asignarProfesoresALCurso(curso.getId(), profe2.getDni()));

		// test contador alumno curso
		assertEquals(uni.cuantosAlumnoCursanUnCurso(curso), a);
		// test contador profe curso
		assertEquals(uni.cuantosProfesCursanUnCurso(curso), a);

	}

	@Test
	public void obtenerListadoMateriasAprobadasParaUnAlumno() {
		// TODO

		// obtenerListadoMateriasAprobadasParaUnAlumno(idAlumno)

		// preparacion
		Uni uni = new Uni("unlam");

		LocalDate fechaInicioCicloLectivo = LocalDate.of(1990, 12, 31);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 31);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 8, 8);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 12, 31);
		;
		Ciclo ciclo = new Ciclo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo, fechaInicioInscripcion,
				fechaFinalizacionInscripcion);

		assertTrue(uni.registrarCicloLect(ciclo));

		LocalDate fechaIngreso = LocalDate.of(2022, 12, 31);
		LocalDate fechaNac = LocalDate.of(1990, 12, 31);
		Alumno alumno = new Alumno(36183763, "maxi", "Maciel", fechaNac, fechaIngreso);

		uni.registrarAlumno(alumno);

		Aula aula = new Aula(1, 10);

		assertTrue(uni.registrarAula(aula));

		Materia materia = new Materia("pbi");
		Materia materia20 = new Materia("informatica");
		Materia materia30 = new Materia("ingles");
		Materia materia40 = new Materia("pb2");

		assertTrue(uni.registrarMateria(materia));
	//	assertTrue(uni.registrarMateria(materia20));
	//	assertTrue(uni.registrarMateria(materia30));
	//	assertTrue(uni.registrarMateria(materia40));

	
		Turno turno = Turno.Mañana;
		Dias dias = Dias.Mar_Jue;
		Dias dias2 = Dias.Lun_Mie;
		Dias dias3 = Dias.Mar_Sab;
		Dias dias4 = Dias.Mie_Vie;

		Curso curso = new Curso(aula, ciclo, materia, turno, dias);

		assertTrue(uni.registrarCurso(curso));

		assertTrue(uni.inscribirAlumnoACurso(alumno.getDni(), curso.getId()));

		assertTrue(uni.registrarNota(curso.getId(), alumno.getDni(), 7, TipoNota.PrimerParcial));
		assertTrue(uni.registrarNota(curso.getId(), alumno.getDni(), 7, TipoNota.SegundoParcial));

		Integer aux = 7;
		assertEquals(aux, uni.obtenerNota(alumno.getDni(), materia.getId(), TipoNota.SegundoParcial));
		CondFinal aux5 = CondFinal.Promocionado;

		assertEquals(aux5, uni.obtenerCondFinal(alumno.getDni(), curso.getMateria().getId()));

		uni.mostrarCuantasMateriasaprobadas(alumno.getDni());
		uni.mostrarCuantasFaltanCursar(alumno.getDni());
	}


	
	
	@Test
	public void calcularPromedioAlumno() {
		// TODO

		// obtenerListadoMateriasAprobadasParaUnAlumno(idAlumno)

		// preparacion
		Uni uni = new Uni("unlam");

		LocalDate fechaInicioCicloLectivo = LocalDate.of(1990, 12, 31);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 31);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 8, 8);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 12, 31);
		;
		Ciclo ciclo = new Ciclo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo, fechaInicioInscripcion,
				fechaFinalizacionInscripcion);

		assertTrue(uni.registrarCicloLect(ciclo));

		LocalDate fechaIngreso = LocalDate.of(2022, 12, 31);
		LocalDate fechaNac = LocalDate.of(1990, 12, 31);
		Alumno alumno = new Alumno(36183763, "maxi", "Maciel", fechaNac, fechaIngreso);

		uni.registrarAlumno(alumno);

		Aula aula = new Aula(1, 10);

		assertTrue(uni.registrarAula(aula));

		Materia materia = new Materia("pbi");
		Materia materia20 = new Materia("informatica");
		Materia materia30 = new Materia("ingles");
		Materia materia40 = new Materia("pb2");

		assertTrue(uni.registrarMateria(materia));
		Turno turno = Turno.Mañana;
		Dias dias = Dias.Mar_Jue;
		Dias dias2 = Dias.Lun_Mie;
		Dias dias3 = Dias.Mar_Sab;
		Dias dias4 = Dias.Mie_Vie;

		Curso curso = new Curso(aula, ciclo, materia, turno, dias);

		assertTrue(uni.registrarCurso(curso));

		assertTrue(uni.inscribirAlumnoACurso(alumno.getDni(), curso.getId()));

		assertTrue(uni.registrarNota(curso.getId(), alumno.getDni(), 7, TipoNota.PrimerParcial));
		assertTrue(uni.registrarNota(curso.getId(), alumno.getDni(), 7, TipoNota.SegundoParcial));

		Integer aux = 7;
		assertEquals(aux, uni.obtenerNota(alumno.getDni(), materia.getId(), TipoNota.SegundoParcial));
		CondFinal aux5 = CondFinal.Promocionado;

		assertEquals(aux5, uni.obtenerCondFinal(alumno.getDni(), curso.getMateria().getId()));
		
		assertEquals(aux, uni.obtenerNota(alumno.getDni(), materia.getId(), TipoNota.Final));
		
		
		
	}

	


}