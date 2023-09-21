package Dominio;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Ciclo {
	private static Integer idCont= 1;
	private	Integer id; 
	private LocalDate fechaInicioCicloLectivo;
	private LocalDate fechaFinalizacionCicloLectivo;
	private LocalDate fechaInicioInscripcion;
	private LocalDate fechaFinalizacionInscripcion;
	
	public Ciclo( LocalDate fechaInicioCicloLectivo2, LocalDate fechaFinalizacionCicloLectivo2,
			LocalDate fechaInicioInscripcion2, LocalDate fechaFinalizacionInscripcion2) {
		
		this.id = idCont++;
		this.fechaInicioCicloLectivo = fechaInicioCicloLectivo2;
		this.fechaFinalizacionCicloLectivo = fechaFinalizacionCicloLectivo2;
		this.fechaInicioInscripcion = fechaInicioInscripcion2;
		this.fechaFinalizacionInscripcion = fechaFinalizacionInscripcion2;
	}

	public Integer getId() {
		return id;
	}

	

	public LocalDate getFechaInicioCicloLectivo() {
		return fechaInicioCicloLectivo;
	}

	public void setFechaInicioCicloLectivo(LocalDate fechaInicioCicloLectivo) {
		this.fechaInicioCicloLectivo = fechaInicioCicloLectivo;
	}

	public LocalDate getFechaFinalizacionCicloLectivo() {
		return fechaFinalizacionCicloLectivo;
	}

	public void setFechaFinalizacionCicloLectivo(LocalDate fechaFinalizacionCicloLectivo) {
		this.fechaFinalizacionCicloLectivo = fechaFinalizacionCicloLectivo;
	}

	public LocalDate getFechaInicioInscripcion() {
		return fechaInicioInscripcion;
	}

	public void setFechaInicioInscripcion(LocalDate fechaInicioInscripcion) {
		this.fechaInicioInscripcion = fechaInicioInscripcion;
	}

	public LocalDate getFechaFinalizacionInscripcion() {
		return fechaFinalizacionInscripcion;
	}

	public void setFechaFinalizacionInscripcion(LocalDate fechaFinalizacionInscripcion) {
		this.fechaFinalizacionInscripcion = fechaFinalizacionInscripcion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fechaFinalizacionCicloLectivo, fechaFinalizacionInscripcion, fechaInicioCicloLectivo,
				fechaInicioInscripcion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ciclo other = (Ciclo) obj;
		return Objects.equals(fechaFinalizacionCicloLectivo, other.fechaFinalizacionCicloLectivo)
				&& Objects.equals(fechaFinalizacionInscripcion, other.fechaFinalizacionInscripcion)
				&& Objects.equals(fechaInicioCicloLectivo, other.fechaInicioCicloLectivo)
				&& Objects.equals(fechaInicioInscripcion, other.fechaInicioInscripcion);
	}

	

	
	
	
	}

	
	
	
	
	
	
	
	
	
	
	

	


