package Dominio;

import java.util.ArrayList;
import java.util.Objects;

public class ProfeCurso {
	private static Integer idSt = 1;

	private Integer id;
	private Curso curso;
	private ArrayList<Profe> profes;

	public ProfeCurso(Curso curso, Profe profes) {

		this.id = idSt++;
		this.curso = curso;
		this.profes = new ArrayList<Profe>();
		this.profes.add(profes);
	}

	public Integer getId() {
		return id;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public ArrayList<Profe> getProfes() {
		return profes;
	}

	public Boolean setProfe(Profe profe) {
		if (profes.contains(profe)) {
			return false;
		}
		return profes.add(profe);
	}

	@Override
	public int hashCode() {
		return Objects.hash(curso);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProfeCurso other = (ProfeCurso) obj;
		return Objects.equals(curso, other.curso);
	}

}
