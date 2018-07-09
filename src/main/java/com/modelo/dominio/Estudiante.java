package com.modelo.dominio;

import java.util.List;


import java.util.ArrayList;
import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import org.uqbar.commons.utils.Observable;



@Observable
public class Estudiante {
	
	private String nombre;
	private int legajo;
	private List<Tarea> tareas = new ArrayList <Tarea>(); 
	
	
	public Estudiante (String nombre,int legajo) {
		this.nombre=nombre;
		this.legajo=legajo;
	}

	
	void agregarTarea (Tarea unaTarea) {
		tareas.add(unaTarea);
	}
	
	
}
