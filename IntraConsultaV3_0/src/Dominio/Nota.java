package Dominio;

import java.util.Objects;

public class Nota {
	private static Integer idSt = 1;
	private Integer id;
	private boolean notaRecuperada;
	
	private Integer parcial1 ;
	private Integer parcial2 ;
	private Integer nFinal;

	public Nota() {
		
		this.notaRecuperada = false;
	}

	

	public Integer getId() {
		return id;
	}

	
	

	

	public CondFinal mostrarCondFinal() {
		// para cargar la nota final, debe tener aprobadas las parciales
		if (parcial1 >= 4 && parcial2 >= 4) {
			if (parcial1 >= 7 && parcial2 >= 7) {
				return CondFinal.Promocionado;
			}
			if (parcial1 >= 4 && parcial2 >= 4) {
				return CondFinal.Cursado;
			}

		}
		return CondFinal.Desaprobado;
	}

	private boolean recuperarNota1(Integer nota) {
		if (!notaRecuperada) {
			notaRecuperada = true;
			parcial1 = nota;
		}
		return notaRecuperada;
	}

	private boolean recuperarNota2(Integer nota) {
		if (!notaRecuperada) {
			notaRecuperada = true;
			parcial2 = nota;
		}
		return notaRecuperada;

	}

	private boolean puedeRecuperar() {
		if (parcial1 <= 4 || parcial2 <= 4) {
			return true;
		}
		return false;

	}

	public Integer getnota(TipoNota tipoNota) {
		switch (tipoNota) {
		case PrimerParcial:
			return this.parcial1;

		case SegundoParcial:
			return this.parcial2;

		default:
			return nFinal;

		}

	}

	public void setNota(Integer nota, TipoNota tipoNota) {

		switch (tipoNota) {
		case PrimerParcial:
			parcial1 = nota;
			break;
		case SegundoParcial:
			parcial2 = nota;
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
