package calcularpago;

public class principal {

	public static void main(String[] args) {
	String direccion="C:\\PagoEmpleado\\ingresoDiasHoras.txt";
	ProcesadorArchivo pa= new ProcesadorArchivo();
    pa.transformaVector(direccion);
	pa.extraeNumero();
	pa.obtenerDiaHorasTrabajasPorDia();
	pa.pago();	
	}

}
