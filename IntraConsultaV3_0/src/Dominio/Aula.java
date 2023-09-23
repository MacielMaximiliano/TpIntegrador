package Dominio;

import java.util.Objects;

public class Aula {
	private Integer numAula;
	private Integer cantAlumn;
	public Aula(Integer numAula, Integer cantAlumn) {
		super();
		this.numAula = numAula;
		this.cantAlumn = cantAlumn;
	}
	public Integer getNumAula() {
		return numAula;
	}
	public void setNumAula(Integer numAula) {
		this.numAula = numAula;
	}
	public Integer getCantAlumn() {
		return cantAlumn;
	}
	public void setCantAlumn(Integer cantAlumn) {
		this.cantAlumn = cantAlumn;
	}
	@Override
	public int hashCode() {
		return Objects.hash(numAula);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aula other = (Aula) obj;
		return Objects.equals(numAula, other.numAula);
	}
	



}
