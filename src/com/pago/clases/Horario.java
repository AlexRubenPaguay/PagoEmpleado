package com.pago.clases;

public class Horario {
	
private String hora;
private String costo;
private String tipo;

public Horario() {

}

public Horario(String hora, String costo, String tipo) {
	
	this.hora = hora;
	this.costo = costo;
	this.tipo = tipo;
}
public String getHora() {
	return hora;
}
public void setHora(String hora) {
	this.hora = hora;
}
public String getCosto() {
	return costo;
}
public void setCosto(String costo) {
	this.costo = costo;
}
public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	this.tipo = tipo;
}
}
