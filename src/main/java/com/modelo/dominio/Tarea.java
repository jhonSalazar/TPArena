package com.modelo.dominio;



import org.uqbar.commons.model.Entity;
import org.uqbar.commons.utils.Observable;
import org.uqbar.commons.utils.Transactional;

import uqbar.arena.persistence.annotations.PersistentClass;

@SuppressWarnings("serial")
@Transactional
@Observable
@PersistentClass
public class Tarea extends Entity {

	private String nombre;
	private TipoCalificacion tipo;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoCalificacion getTipo() {
		return tipo;
	}

	public void setTipo(TipoCalificacion tipo) {
		this.tipo = tipo;
	}

	public Tarea (String nombre,TipoCalificacion tipo) {
		this.nombre=nombre;
		this.tipo=tipo;	
	}
	
	public Tarea (String nombre) {
		this.nombre=nombre;
			
	}
	

	public Tarea() {
			// TODO Auto-generated constructor stub
	}
}
