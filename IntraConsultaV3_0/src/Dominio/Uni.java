package Dominio;

import java.util.ArrayList;

public class Uni {

	private String nombre;
	private ArrayList<Materia> materias;
	private ArrayList<Aula> aulas;
	private ArrayList<Ciclo> ciclosLectivos;
	private ArrayList<Profe> profes;
	private ArrayList<Alumno> alumnos;
//	private ArrayList<Nota> nota;

	private ArrayList<Curso> cursos;

	private ArrayList<ProfeCurso> profesAsignados;
	private ArrayList<AlumnoCurso> alumnosAsignados;

	public Uni(String nombre) {

		this.nombre = nombre;
		this.cursos = new ArrayList<Curso>();
		this.materias = new ArrayList<Materia>();
		this.aulas = new ArrayList<Aula>();
		this.ciclosLectivos = new ArrayList<Ciclo>();

		this.profes = new ArrayList<Profe>();
		this.alumnos = new ArrayList<Alumno>();
		this.profesAsignados = new ArrayList<ProfeCurso>();
		this.alumnosAsignados = new ArrayList<AlumnoCurso>();
		// this.nota = new ArrayList<Nota>();

	}

	public Boolean registrarMateria(Materia materia) {

		if (materias.contains(materia)) {
			return false;
		}
		return materias.add(materia);

	}

	public Materia buscarMateria(Integer idMateria) {
		Materia aux = null;
		for (int i = 0; i < materias.size(); i++) {

			if (materias.get(i).getId().equals(idMateria)) {
				aux = materias.get(i);

			}
		}

		return aux;
	}

	public Boolean registrarAlumno(Alumno alumno) {
		if (alumnos.contains(alumno)) {
			return false;
		}
		return alumnos.add(alumno);

	}

	public Alumno buscarAlumno(Integer dni) {
		Alumno aux = null;
		for (int i = 0; i < alumnos.size(); i++) {
			if (alumnos.get(i).getDni() == dni) {
				aux = alumnos.get(i);
			}
		}

		return aux;
	}

	public Boolean registrarCicloLect(Ciclo ciclo) {
		if (ciclosLectivos.contains(ciclo)) {
			return false;
		}
		//metodo a probar
		for (int i = 0; i < ciclosLectivos.size(); i++) {
				if(seSuperponen(ciclosLectivos.get(i),ciclo	)) {
					return false;
				}
		}
		
		
		
		return ciclosLectivos.add(ciclo);

	}
	
	
	
	 public boolean seSuperponen(Ciclo cArray ,Ciclo nuevo) {
	   
	        boolean despues = cArray.getFechaFinalizacionCicloLectivo().isBefore(nuevo.getFechaInicioCicloLectivo());
	        
	       
	        boolean antes = cArray.getFechaInicioCicloLectivo().isAfter(nuevo.getFechaFinalizacionCicloLectivo());
	        
	      
	        return !(despues || antes);
	    }
	
	
	
	
	

	public Ciclo buscarCicloLect(Integer idCiclo) {
		Ciclo aux = null;
		for (int i = 0; i < ciclosLectivos.size(); i++) {
			if (ciclosLectivos.get(i).getId() == (idCiclo)) {
				aux = ciclosLectivos.get(i);
			}
		}

		return aux;
	}

	public Boolean registrarProfe(Profe profe) {
		if (profes.contains(profe)) {
			return false;
		}
		return profes.add(profe);
	}

	public Profe buscarProfe(Integer dni) {
		Profe aux = null;
		for (int i = 0; i < profes.size(); i++) {
			if (profes.get(i).getDni() == (dni)) {
				aux = profes.get(i);
			}
		}

		return aux;
	}

	public Boolean registrarAula(Aula aula) {
		if (aulas.contains(aula)) {
			return false;
		}
		return aulas.add(aula);
	}

	public Aula buscarAula(Integer numAula) {
		Aula aux = null;
		for (int i = 0; i < aulas.size(); i++) {
			if (aulas.get(i).getNumAula() == numAula) {
				aux = aulas.get(i);
			}
		}

		return aux;
	}

	// No se Pueden generar 2 Comisiones para la misma materia, el mismo
	// cicloLectivo y el mismo turno
	public Boolean registrarCurso(Curso curso) {
		if (cursos.contains(curso)) {
			return false;
		}
		return cursos.add(curso);
	}

	public Curso buscarCurso(Integer idCurso) {
		Curso aux = null;
		for (int i = 0; i < cursos.size(); i++) {
			if (cursos.get(i).getId() == idCurso) {
				aux = cursos.get(i);
			}
		}

		return aux;
	}

	// Se debe validar que ambos códigos existan en una materia
	public Boolean agregarCorrelativas(Integer id, Integer id2) {
		Materia materia = buscarMateria(id);
		Materia materia2 = buscarMateria(id2);

		if (materia != null && materia2 != null) {
			return materia.getCorrelativas().add(materia2);

		}
		return false;
	}

	public Boolean eliminarCorrelativa(Integer id, Integer id2) {
		Materia materia = buscarMateria(id);
		Materia materia2 = buscarMateria(id2);

		if (materia != null && materia2 != null) {
			return materia.getCorrelativas().remove(materia2);

		}
		return false;
	}
	
	
	//TODO
	// La inscripción no se puede realizar si esta fuera de fecha Inscripción

	
	
	
	public Boolean inscribirAlumnoACurso(Integer dni, Integer id) {
		Alumno alumno = buscarAlumno(dni);
		Curso curso = buscarCurso(id);
		

		if (alumno == null && curso == null) {
			return false;
		}
		
		
		// No se puede inscribir el alumno si excede la cantidad de alumnos permitos en
		// el aula
		if(cuantosAlumnoCursanUnCurso(curso) > curso.getAula().getCantAlumn()){
			
			return false;
		}
		
		
		// No se puede inscribir el Alumno si ya está inscripto a otro curso para el
		// mismo día y Turno
		if(alumnoInscriptoMismoDiaYturno(alumno,curso)) {
			return false;
		}
		
		
		
		
		if(!alumnoTieneCorrelativasAprobadas(alumno,curso.getMateria())) {
			return false;
		}
			
		

		AlumnoCurso alumnoCurso = new AlumnoCurso(alumno, curso);
		return alumnosAsignados.add(alumnoCurso);
	}

	
	private boolean alumnoTieneCorrelativasAprobadas(Alumno alumno, Materia materia) {
		//TODO		
		
		// No se puede inscribir Alumnos si este no tiene almenos cursada todas las
		// correlativas (Todas las correlativas Con nota >=4
		return true;
		
	
	
	
	
	
	
	
	
	
	
	
	}

	public Boolean registrarNota(Integer id, Integer dni, Nota nota) {
		Alumno alumno = buscarAlumno(dni);
		Curso curso = buscarCurso(id);
		AlumnoCurso aux = new AlumnoCurso(alumno, curso);

		for (int i = 0; i < alumnosAsignados.size(); i++) {

			if (alumnosAsignados.get(i).equals(aux)) {
				// TODO revisar esto
				return alumnosAsignados.get(i).setNota(nota);
			}

		}

		return false;

	}

	public Nota obtenerNota(Integer dni, Integer id) {
		Alumno alumno = buscarAlumno(dni);
		Materia materia = buscarMateria(id);

		Nota nota = null;

		for (int i = 0; i < alumnosAsignados.size(); i++) {

			if (alumnosAsignados.get(i).getAlumno().equals(alumno)
					&& alumnosAsignados.get(i).getCurso().getMateria().equals(materia)) {
				nota = alumnosAsignados.get(i).getNota();
			}

		}
		return nota;

	}

	public Boolean asignarProfesoresALCurso(Integer id, Integer dni) {
		boolean aux = false;
		Curso curso = buscarCurso(id);
		Profe profe = buscarProfe(dni);
		ProfeCurso profeCurso = new ProfeCurso(curso, profe);
		if (curso != null && profe != null) {
			
			
			//TODO revisar el metodo un profeCada20
			if (ProfeEnOotroCursoAlMismoHorario(profe, curso) == false
					//&& UnoProfeCada20(curso)
					) {
				profesAsignados.add(profeCurso);
				aux = true;
			}
		}

		return aux;

	}

	private boolean UnoProfeCada20(Curso curso) {
		Integer ProfesDelCurso = cuantosProfesCursanUnCurso(curso);
		Integer AlumnosDelCurso =cuantosAlumnoCursanUnCurso(curso);
						
		if(ProfesDelCurso!=0 &&AlumnosDelCurso!=0 && (AlumnosDelCurso/ProfesDelCurso) <20) {
			return true;
		}		
		return false;
	}



	public Integer cuantosAlumnoCursanUnCurso(Curso curso) {
		Integer ContadorProfes = 0;
		for (int i = 0; i < alumnosAsignados.size(); i++) {
			if (alumnosAsignados.get(i).getCurso().equals(curso)) {
				ContadorProfes++;
			}
		}return ContadorProfes;
	}

	public Integer cuantosProfesCursanUnCurso(Curso curso) {
		Integer ContadorProfes = 0;
		for (int i = 0; i < profesAsignados.size(); i++) {
			if (profesAsignados.get(i).getCurso().equals(curso)) {
				ContadorProfes++;
			}
		}return ContadorProfes;
	}

	private boolean ProfeEnOotroCursoAlMismoHorario(Profe profe, Curso curso) {
		boolean aux = false;
		for (int i = 0; i < profesAsignados.size(); i++) {
			if (profesAsignados.get(i).getProfes().contains(profe)
					&& profesAsignados.get(i).getCurso().getHorario().equals(curso.getHorario())
					&& profesAsignados.get(i).getCurso().getDias().equals(curso.getDias())) {

				aux = true;
			}

		}

		return aux;
	}

	
	
	
	private boolean alumnoInscriptoMismoDiaYturno(Alumno alumno, Curso curso) {
		boolean aux = false;
		for (int i = 0; i < alumnosAsignados.size(); i++) {
			if (alumnosAsignados.get(i).getAlumno().equals(alumno)
					&& alumnosAsignados.get(i).getCurso().getHorario().equals(curso.getHorario())
					&& alumnosAsignados.get(i).getCurso().getDias().equals(curso.getDias())) {

				aux = true;
			}

		}

		return aux;
	}
	
	
	
}
