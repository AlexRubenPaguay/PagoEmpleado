package com.pago.clases;

public class Dia {
	private String codigo;
	private String nombre;
	private String tipo;
	
	public Dia() {		
		
	}
	
	public Dia(String codigo, String nombre, String tipo) {		
		this.codigo = codigo;
		this.nombre = nombre;
		this.tipo = tipo;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	

}
