package com.pago.dao;

import java.util.ArrayList;

import com.pago.clases.Horario;

public class HorarioDao {
	
	private ArrayList<Horario> horario;
	
	public final ArrayList<Horario> getObtenerHorarios(){
		horario=new ArrayList<Horario>();
		Horario h1= new Horario("00:01 - 09:00", "25", "ORDINARIO");
		horario.add(h1);
		Horario h2= new Horario("09:01 - 18:00", "15", "ORDINARIO");
		horario.add(h2);
		Horario h3= new Horario("18:01 - 00:00", "20", "ORDINARIO");
		horario.add(h3);
		Horario h4= new Horario("00:01 - 09:00", "30", "EXTRA");
		horario.add(h4);
		Horario h5= new Horario("09:01 - 18:00", "20", "EXTRA");
		horario.add(h5);
		Horario h6= new Horario("18:01 - 00:00", "25", "EXTRA");
		horario.add(h6);
		return horario;
		
	}

}
