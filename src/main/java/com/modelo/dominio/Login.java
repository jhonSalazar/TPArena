package com.modelo.dominio;

public class Login {
	private int legajo;
	private String clave;
	
	public Login(int legajo,String clave) {
		this.legajo = legajo;
		this.clave = clave;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

}
