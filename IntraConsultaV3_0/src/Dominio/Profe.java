package Dominio;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Profe {

	private Integer dni;
	private String nombre;
	private String apellido;
	private LocalDate fechaNac;
	private LocalDate fechaIng;

	public Profe(Integer dni, String nombre, String apellido, LocalDate fechaNac2, LocalDate fechaIngreso) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNac = fechaNac2;
		this.fechaIng = fechaIngreso;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public LocalDate getFechaIng() {
		return fechaIng;
	}

	public void setFechaIng(LocalDate fechaIng) {
		this.fechaIng = fechaIng;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profe other = (Profe) obj;
		return Objects.equals(dni, other.dni);
	}

}
