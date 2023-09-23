package Dominio;

import java.util.Objects;

public class Nota {
	private static Integer idSt = 1;
	private Integer id;
	private TipoNota tipoNota;
	private Integer valor;

	public Nota(TipoNota tipoNota) {
		this.id = idSt++;
		this.tipoNota = tipoNota;
	}

	public TipoNota getTipoNota() {
		return tipoNota;
	}

	public void setTipoNota(TipoNota tipoNota) {
		this.tipoNota = tipoNota;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	

	public Integer getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(tipoNota, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nota other = (Nota) obj;
		return tipoNota == other.tipoNota && Objects.equals(valor, other.valor);
	}





}
