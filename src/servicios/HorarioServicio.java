package servicios;

import java.util.ArrayList;

import com.pago.clases.Horario;
import com.pago.dao.HorarioDao;

public class HorarioServicio {

	public ArrayList<Horario> obtenerTodosHorarios() {
		final HorarioDao horario = new HorarioDao();
		return horario.getObtenerHorarios();
	}
}
