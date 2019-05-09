package calcularpago;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import com.pago.clases.Dia;
import com.pago.clases.Horario;

import servicios.DiaServicio;
import servicios.HorarioServicio;

public class ProcesadorArchivo {

	public String vectorHorario[] = null;
	public List<String> vectorNumeros = new ArrayList<String>();
	public List<String> valNum = new ArrayList<String>();
	public HorarioServicio hs = new HorarioServicio();
	public DiaServicio ds = new DiaServicio();
	public List<Horario> servicioHorario = new ArrayList<Horario>();
	public List<Float> totalHorasTrabajadas = new ArrayList<Float>();
	public List<String> nombresNumeros = new ArrayList<String>();
	public String nombreEmpleado="";

	public String[] transformaVector(String direccion) {

		try {
			FileReader fr = new FileReader(direccion);
			BufferedReader br = new BufferedReader(fr);
			String contenido;
			String concatenacionLineas = "";
			while ((contenido = br.readLine()) != null) {
				concatenacionLineas = concatenacionLineas + contenido;
			}
			br.close();
			vectorHorario = concatenacionLineas.split(",");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return vectorHorario;
	}

	public void extraeNumero() {
		int cont=0;
		for (int i = 0; i < vectorHorario.length; i++) {

			String str = vectorHorario[i];
			StringReader sr = new StringReader(str);
			StreamTokenizer st = new StreamTokenizer(sr);

			try {
				String miRegistro = "";
				while (st.nextToken() != StreamTokenizer.TT_EOF) {
					
					if (st.ttype == StreamTokenizer.TT_WORD) {

						if (obtienePalabra(st.sval).length() > 0) {
							if(cont<=0) {
							nombreEmpleado=	obtienePalabra(st.sval);
							}
							miRegistro += obtienePalabra(st.sval) + ",";

						}
						if (obtieneNumero(st.sval).length() > 0) {
							miRegistro += obtieneNumero(st.sval) + ",";

						}

					}
					if (st.ttype == StreamTokenizer.TT_NUMBER) {

						miRegistro += (Math.abs((int) st.nval)) + ",";

					}
					cont++;

				}
				nombresNumeros.add(i, miRegistro);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			sr.close();

		}
	}

	public String obtieneNumero(String cadena) {

		char cadenaAux[] = null;
		String registro = "";
		cadenaAux = cadena.toCharArray();

		for (int j = 0; j < cadenaAux.length; j++) {

			if (Character.isDigit(cadenaAux[j])) {
				registro += cadenaAux[j];
			}
		}

		return registro;
	}

	public String obtienePalabra(String cadena) {

		char cadenaAux[] = null;
		String registro = "";
		cadenaAux = cadena.toCharArray();

		for (int j = 0; j < cadenaAux.length; j++) {

			if (!(Character.isDigit(cadenaAux[j])) && (!(Character.isWhitespace(cadenaAux[j])))) {
				registro += cadenaAux[j];
			}
		}

		return registro;
	}

	public void obtenerDiaHorasTrabajasPorDia() {

		List<Dia> diaServicio = new ArrayList<Dia>();
		diaServicio = ds.obtenerTodosDias();
		List<String> horaInicioFin = new ArrayList<String>();

		for (int i = 0; i < nombresNumeros.size(); i++) {
			String tipoDia = "";

			String str = nombresNumeros.get(i);
			for (int j = 0; j < diaServicio.size(); j++) {

				Dia cadena = diaServicio.get(j);
				horaInicioFin = soloNumeros(str); // Token

				int resultado = (nombresNumeros.get(i)).indexOf(cadena.getCodigo()); // busca una cadena dentro de otra

				if (resultado != -1) {

					if (cadena.getCodigo().equals("MO") || cadena.getCodigo() == "MO" || cadena.getCodigo().equals("TU")
							|| cadena.getCodigo() == "TU" || cadena.getCodigo().equals("WE")
							|| cadena.getCodigo() == "WE" || cadena.getCodigo().equals("TH")
							|| cadena.getCodigo() == "TH" || cadena.getCodigo().equals("FR")
							|| cadena.getCodigo() == "FR") {
						tipoDia = "ORDINARIO";
						totalHorasTrabajadas.add(pagoDia(tipoDia, horaInicioFin.get(0), horaInicioFin.get(2)));

					} else if (cadena.getCodigo().equals("SA") || cadena.getCodigo() == "SA"
							|| cadena.getCodigo().equals("SU") || cadena.getCodigo() == "SU") {
						tipoDia = "EXTRA";
						totalHorasTrabajadas.add(pagoDia(tipoDia, horaInicioFin.get(0), horaInicioFin.get(2)));
					}
				}
			}

		}

	}

	public float pagoDia(String typoDia, String horaInicio, String horaFin) {

		List<Horario> horarios = new ArrayList<Horario>();
		horarios = hs.obtenerTodosHorarios();
		float pagoDia = 0;

		for (Horario horario : horarios) {

			int inicioBD = Integer.parseInt(soloNumeros(horario.getHora()).get(0));
			int finBD = Integer.parseInt(soloNumeros(horario.getHora()).get(2));

			if (((Integer.parseInt(horaInicio) >= 18))) {
				finBD = 24;
			}

			if ((horario.getTipo().equals(typoDia)
					&& (Integer.parseInt(horaInicio) >= inicioBD && Integer.parseInt(horaFin) <= finBD))) {

				pagoDia = (Math.abs(Integer.parseInt(horaInicio) - Integer.parseInt(horaFin)))
						* Integer.parseInt(horario.getCosto());

			}

		}

		return pagoDia;
	}

	public List<String> soloNumeros(String cadena) {

		List<String> listaNumerica = new ArrayList<String>();
		StringReader sr = new StringReader(cadena);
		StreamTokenizer st = new StreamTokenizer(sr);

		try {

			while (st.nextToken() != StreamTokenizer.TT_EOF) {

				if (st.ttype == StreamTokenizer.TT_NUMBER) {

					listaNumerica.add(String.valueOf((int) st.nval));

				}
			}

		} catch (IOException e) {

			e.printStackTrace();
		}

		sr.close();

		return listaNumerica;
	}

	public void pago() {
		float sumaPago = 0;
		for (int i = 0; i < totalHorasTrabajadas.size(); i++) {
			sumaPago += totalHorasTrabajadas.get(i);
		}

		System.out.println("El monto a pagar " +nombreEmpleado + " es de: " + (int) sumaPago + " USD");

	}

}
