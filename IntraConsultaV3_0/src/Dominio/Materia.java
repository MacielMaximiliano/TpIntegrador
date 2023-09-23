package Dominio;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

public class Materia {
	private String nombre;
	private Integer id;
	
	
	private ArrayList<Materia> correlativas;

	private static Integer idSt = 1;

	public Materia(String string) {
		this.nombre = string;
		this.id = idSt;
	
		correlativas = new ArrayList<Materia>();
	}

	public Integer getId() {

		return this.id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Materia> getCorrelativas() {
		return correlativas;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Materia other = (Materia) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre);
	}


	



	}
	
	
	
	

