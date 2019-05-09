package servicios;

import java.util.ArrayList;

import com.pago.clases.Dia;
import com.pago.dao.DiaDao;

public class DiaServicio {
	
	public ArrayList<Dia> obtenerTodosDias(){		
		 final DiaDao dia=new DiaDao();
		return dia.getObtenerDias();
	}
}
