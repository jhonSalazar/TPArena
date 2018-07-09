package com.modelo.dominio;

import java.util.List;


import java.util.ArrayList;
import org.uqbar.commons.utils.Observable;



@Observable
public class Estudiante {
	
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


	public List<Tarea> getTareas() {
		return tareas;
	}


	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}


	private String nombre;
	private int legajo;
	private List<Tarea> tareas = new ArrayList <Tarea>(); 
	
	
	public Estudiante (String nombre,int legajo) {
		this.nombre=nombre;
		this.legajo=legajo;
	}
	
	public Estudiante () {

	}

	
	void agregarTarea (Tarea unaTarea) {
		tareas.add(unaTarea);
	}
	
	
}
