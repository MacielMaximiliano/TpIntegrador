package Dominio;

import java.util.Objects;

public class AlumnoCurso {

	private Integer id;
	private Alumno alumno;
	private Curso curso;
	private Nota nota;


	private static Integer cod = 1;

	public AlumnoCurso(Alumno alumno, Curso curso) {
		super();
		this.alumno = alumno;
		this.curso = curso;
		this.id = cod++;
		this.nota = new Nota();

	}

	public Nota getNota() {
		return nota;
	}
	
	
	

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public int hashCode() {
		return Objects.hash(alumno, curso);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlumnoCurso other = (AlumnoCurso) obj;
		return Objects.equals(alumno, other.alumno) && Objects.equals(curso, other.curso);
	}

	public Boolean setNota(Integer nota2, TipoNota tipoNota) {
		
		return nota.setNota( nota2, tipoNota);
		
		
		
	}

	public CondFinal mostrarCondFinal() {
		
		if (nota.getnota(TipoNota.PrimerParcial) >= 4 && nota.getnota(TipoNota.SegundoParcial) >= 4) {
			if (nota.getnota(TipoNota.PrimerParcial) >= 7 && nota.getnota(TipoNota.SegundoParcial) >= 7) {
				return CondFinal.Promocionado;
			}
			if (nota.getnota(TipoNota.PrimerParcial) >= 4 && nota.getnota(TipoNota.SegundoParcial) >= 4) {
				return CondFinal.Cursado;
			}

		}
		return CondFinal.Desaprobado;
		
	}

	


	
	

}
