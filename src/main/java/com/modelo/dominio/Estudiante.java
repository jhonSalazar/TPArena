package com.modelo.dominio;

import java.util.List;


import java.util.ArrayList;

import org.uqbar.commons.model.Entity;
import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;
import org.uqbar.commons.utils.Transactional;

import scala.Boolean;
import uqbar.arena.persistence.annotations.PersistentClass;
import uqbar.arena.persistence.annotations.PersistentField;



@SuppressWarnings("serial")
@Observable

public class Estudiante extends Entity {

	private String nombre;
	private int legajo;
	private List<Tarea> tareas ;	
	private String tarea;
	private String nota;
	private Boolean conceptual;

	public Boolean getConceptual() {
		return conceptual;
	}


	public void setConceptual(Boolean conceptual) {
		this.conceptual = conceptual;
	}


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


	public List<Tarea> getTareas() {
		return tareas;
	}


	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}
	
	public Estudiante (String nombre,int legajo,String tarea,String nota) {
		this.nombre=nombre;
		this.legajo=legajo;
		this.tarea=tarea;
		this.nota=nota;
		tareas = new ArrayList <Tarea>();
	}
	
	public Estudiante () {
		tareas = new ArrayList <Tarea>();
	}

	
	void agregarTarea (Tarea unaTarea) {
		tareas.add(unaTarea);
	}

	
	public String getTarea() {
		return tarea;
	}


	public void setTarea(String tarea) {
		this.tarea = tarea;
	}
	
	
}
