package com.modelo.dominio;
import org.uqbar.commons.model.Entity;
import org.uqbar.commons.utils.Observable;




@SuppressWarnings("serial")
@Observable

public class Estudiante extends Entity {

	private String nombre;
	private int legajo;
	private String tarea;
	private String nota;
	


	public String getNota() {
		return nota;
	}


	public void setNota(String nota) {
		this.nota = nota;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getLegajo() {
		return legajo;
	}


	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	
	public Estudiante (String nombre,int legajo,String tarea,String nota) {
		this.nombre=nombre;
		this.legajo=legajo;
		this.tarea=tarea;
		this.nota=nota;
	}
	
	public String getTarea() {
		return tarea;
	}

	public void setTarea(String tarea) {
		this.tarea = tarea;
	}
	
	
}
