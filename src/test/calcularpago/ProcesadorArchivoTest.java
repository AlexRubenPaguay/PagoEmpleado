/**
 * 
 */
package test.calcularpago;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import calcularpago.ProcesadorArchivo;

/**
 * @author Axe
 *
 */
class ProcesadorArchivoTest {

	@Test
	void dadoUnStringObtenerNumero() {
		String test="5678i0i mo5lo1tov8  &";
		ProcesadorArchivo procesar=new ProcesadorArchivo();
		String cadenaNumero=procesar.obtieneNumero(test);
		assertEquals(56780518,Integer.parseInt(cadenaNumero));
		
		
	}
	
	@Test
	void dadoUnStringObtenerCaracteres() {
		String test="5678i0im   o5lo1tov8 ";
		ProcesadorArchivo procesar=new ProcesadorArchivo();
		String cadenaPalabra=procesar.obtienePalabra(test);
		assertEquals("iimolotov",cadenaPalabra);		
	}


}
