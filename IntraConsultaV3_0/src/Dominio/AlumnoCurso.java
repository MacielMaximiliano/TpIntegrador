package Dominio;

import java.util.Objects;

public class AlumnoCurso {

	private Integer id;
	private Alumno alumno;
	private Curso curso;
	private Nota parcial1;
	private Nota parcial2;
	private Nota nFinal;
	private boolean notaRecuperada;

	private static Integer cod = 1;

	public AlumnoCurso(Alumno alumno, Curso curso) {
		super();
		this.alumno = alumno;
		this.curso = curso;
		this.id = cod++;
		this.parcial1 = null;
		this.parcial2 = null;
		this.notaRecuperada = false;

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

	public CondFinal mostrarCondFinal() {
		// para cargar la nota final, debe tener aprobadas las parciales
		if (parcial1.getValor() >= 4 && parcial2.getValor() >= 4) {
			if (parcial1.getValor() >= 7 && parcial2.getValor() >= 7) {
				return CondFinal.Promocionado;
			}
			if (parcial1.getValor() >= 4 && parcial2.getValor() >= 4) {
				return CondFinal.Cursado;
			}

		}
		return CondFinal.Desaprobado;
	}

	private boolean recuperarNota1(Nota nota) {
		if (!notaRecuperada) {
			notaRecuperada = true;
			parcial1 = nota;
		}
		return notaRecuperada;
	}

	private boolean recuperarNota2(Nota nota) {
		if (!notaRecuperada) {
			notaRecuperada = true;
			parcial2 = nota;
		}
		return notaRecuperada;

	}

	private boolean puedeRecuperar() {
		if (parcial1.getValor() <= 4 || parcial2.getValor() <= 4) {
			return true;
		}
		return false;

	}

	public Nota getnota(TipoNota tipoNota) {
		switch (tipoNota) {
		case PrimerParcial:
			return this.parcial1;

		case SegundoParcial:
			return this.parcial2;

		default:
			return nFinal;

		}

	}

	public void setNota(Nota nota) {
		TipoNota tipoNota = nota.getTipoNota();
		switch (tipoNota) {
		case PrimerParcial:
			this.parcial1 = nota;
				break;
		case SegundoParcial:
			this.parcial2 = nota;
				break;
				
		case Recuperatorio1:
			recuperarNota1(nota);
				break;
				
		case Recuperatorio2:
			recuperarNota2(nota);
				break;	
		default:
			break;
		}

	}
}
