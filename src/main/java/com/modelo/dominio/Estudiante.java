package com.modelo.dominio;

import java.util.List;


import java.util.ArrayList;

import org.uqbar.commons.model.Entity;
import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;
import org.uqbar.commons.utils.Transactional;

import uqbar.arena.persistence.annotations.PersistentClass;
import uqbar.arena.persistence.annotations.PersistentField;



@SuppressWarnings("serial")
@Transactional
@Observable
@PersistentClass
public class Estudiante extends Entity {
	@PersistentField
	private String nombre;
	
	@PersistentField
	private int legajo;
	
	private List<Tarea> tareas = new ArrayList <Tarea>(); 
	
	private Tarea tarea;
	
	private int nota;
	
	public int getNota() {
		return nota;
	}


	public void setNota(int nota) {
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

	
	
	
	public Estudiante (String nombre,int legajo) {
		this.nombre=nombre;
		this.legajo=legajo;
	}
	
	public Estudiante () {

	}

	
	void agregarTarea (Tarea unaTarea) {
		tareas.add(unaTarea);
	}
	
	/**
	 * Valida que el celular esté correctamente cargado
	 */
	public void validar() {
		if (!this.ingresoNumero()) {
			throw new UserException("Debe ingresar número");
		}		
		if (!this.ingresoNombre()) {
			throw new UserException("Debe ingresar nombre");
		}
		if (this.tareas == null) {
			throw new UserException("Debe ingresar las tareas del alumno");
		}
	}
	

	public boolean ingresoNumero() {
		return this.legajo != 0;
	}
	
	public boolean ingresoNombre() {
		return this.nombre != null && !this.nombre.trim().equals("");
	}


	public Tarea getTarea() {
		return tarea;
	}


	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}
	
	
}
