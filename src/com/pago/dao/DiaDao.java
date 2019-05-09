package com.pago.dao;

import java.util.ArrayList;

import com.pago.clases.Dia;

public class DiaDao {

	private ArrayList<Dia> dias;

	public final ArrayList<Dia> getObtenerDias() {
		dias = new ArrayList<Dia>();
		Dia d1 = new Dia("MO", "LUNES", "ORDINARIO");
		dias.add(d1);
		Dia d2 = new Dia("TU", "MARTES", "ORDINARIO");
		dias.add(d2);
		Dia d3 = new Dia("WE", "MIERCOLES", "ORDINARIO");
		dias.add(d3);
		Dia d4 = new Dia("TH", "JUEVES", "ORDINARIO");
		dias.add(d4);
		Dia d5 = new Dia("FR", "VIERNES", "ORDINARIO");
		dias.add(d5);
		Dia d6 = new Dia("SA", "SABADO", "EXTRA");
		dias.add(d6);
		Dia d7 = new Dia("SU", "DOMINGO", "EXTRA");
		dias.add(d7);
		return dias;
	}

}
