package Dominio;

import java.util.Objects;

public class Nota {
	private static Integer idSt = 1;
	private Integer id;
	
	private boolean notaRecuperada;
	private Integer parcial1 ;	// lo dejo asi con 2 7 ahi y anda todo perfecto
	private Integer parcial2 ;
	

	public Nota() {
		
		this.notaRecuperada = false;
	}

	

	public Integer getId() {
		return id;
	}

	
	// para cargar la nota final, debe tener aprobadas las parciales
	

	

	
	private boolean recuperarNota1(Integer nota) {
		if (!notaRecuperada &&puedeRecuperar()) {
			notaRecuperada = true;
			parcial1 = nota;
		}
		return notaRecuperada;
	}

	private boolean recuperarNota2(Integer nota) {
		if (!notaRecuperada && puedeRecuperar()) {
			notaRecuperada = true;
			parcial2 = nota;
		}
		return notaRecuperada;

	}

	private boolean puedeRecuperar() {
		if (parcial1 >= 4 || parcial2 >= 4) {
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
			return (parcial1+parcial2)/2;

		}

	}

	public boolean setNota(Integer nota, TipoNota tipoNota) {

		switch (tipoNota) {
		case PrimerParcial:
			this.parcial1 = nota;
			return true;
		case SegundoParcial:
			this.parcial2 = nota;
			return true;

		case Recuperatorio1:
			recuperarNota1(nota);
			return true;

		case Recuperatorio2:
			recuperarNota2(nota);
			return true;
			
		default:
			break;
		}
		return false;

	}



	

	
	
	
}
