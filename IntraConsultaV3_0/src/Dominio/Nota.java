package Dominio;

public class Nota {
	private static Integer idSt = 1;
	private Integer id;
	private Integer parcial1;
	private Integer parcial2;
	private boolean notaRecuperada;

	private Integer Final;

	public Nota() {
		this.id = idSt++;
		this.parcial1 = 0;
		this.parcial2 = 0;
		this.notaRecuperada = false;
	}

	public Integer getParcial() {
		return parcial1;
	}

	public void setParcial(Integer parcial) {
		this.parcial1 = parcial;
	}

	public Integer getParcial2() {
		return parcial2;
	}

	public void setParcial2(Integer parcial2) {
		this.parcial2 = parcial2;
	}

	public Integer getFinal() {
		return Final;
	}

	public boolean recuperarNota1(Integer nota) {
		if (!notaRecuperada) {
			notaRecuperada = true;
			parcial1 = nota;
		}
		return notaRecuperada;
	}

	public boolean recuperarNota2(Integer nota) {
		if (!notaRecuperada) {
			notaRecuperada = true;
			parcial2 = nota;
		}
		return notaRecuperada;

	}
	private boolean puedeRecuperar() {
		if (parcial1 <=4 || parcial2 <=4) {
			return true;
		}
		return false;

	}

	public CondFinal mostrarCondFinal() {
		if (parcial1 >= 7 && parcial2 >= 7) {
			return CondFinal.Promocionado;
		}
		if (parcial1 >= 4 && parcial2 >= 4) {
			return CondFinal.Cursado;
		}

		return CondFinal.Desaprobado;
	}

	@Override
	public String toString() {
		return "Nota [parcial=" + parcial1 + ", parcial2=" + parcial2 + ", Final=" + Final + "]";
	};

}
