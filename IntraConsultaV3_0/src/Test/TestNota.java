package Test;
import Dominio.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestNota {

	@Test
	public void test() {
		
		Nota nota = new Nota();
		nota.setNota(4, TipoNota.PrimerParcial);
		Integer aux = 4;
		assertEquals(aux, nota.getnota(TipoNota.PrimerParcial));
	}

}
