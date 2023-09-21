package Dominio;

import java.util.Objects;

public class Curso {
	
	private static Integer codStatic = 1;
	private Integer id;
	private Aula aula;
	private Ciclo ciclo;
	private Materia materia;
	private Turno turno;
	private Dias dias;
//
	public Curso(Aula aula, Ciclo ciclo, Materia materia, Turno turno ,Dias dias) {
	
		this.id= codStatic++;
		this.aula = aula;
		this.ciclo = ciclo;
		this.materia = materia;
		this.turno = turno;
		this.dias = dias;
	}

	public Integer getId() {
		return this.id;
	}

	public Aula getAula() {
		
		return this.aula;
	}

	public Materia getMateria() {
		
		return this.materia;
	}

	public static Integer getCodStatic() {
		return codStatic;
	}

	public Turno getTurno() {
		return turno;
	}

	public Dias getDias() {
		return dias;
	}

	public Ciclo getCiclo() {
	
		return this.ciclo;
	}

	public Turno getHorario() {
		
		return this.turno;
	}

	public void agregarAula(Aula aula2) {
		this.aula = aula2;
		
	}

	public void agregarMateria(Materia materia2) {
		this.materia = materia2;
		
	}

	public void agregarCicloLect(Ciclo ciclo2) {
	this.ciclo = ciclo2;
		
	
	}

	@Override
	public int hashCode() {
		return Objects.hash(ciclo, dias, materia, turno);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return Objects.equals(ciclo, other.ciclo) && dias == other.dias && Objects.equals(materia, other.materia)
				&& turno == other.turno;
	}
	
	
	
	
}
