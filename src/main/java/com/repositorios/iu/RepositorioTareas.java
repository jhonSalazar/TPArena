package com.repositorios.iu;

import java.io.Serializable;
import java.util.List;

import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

import com.modelo.dominio.Tarea;

import uqbar.arena.persistence.PersistentRepo;


@SuppressWarnings("serial")
@Observable
public class RepositorioTareas extends PersistentRepo<Tarea> implements Serializable {
	
	private static RepositorioTareas instance;

	public static RepositorioTareas getInstance() {
		if (instance == null) {
			instance = new RepositorioTareas();
		}
		return instance;
	}

	public Tarea createExample(){
		return new Tarea();
	}
	
	public Class<Tarea> getEntityType(){
		return Tarea.class;
	}
	
	private RepositorioTareas() {
	}
	
	public Tarea createIfNotExists(Tarea Tarea) {
		if(this.find(Tarea.getNombre()).isEmpty()){
			this.create(Tarea);
		}
		return Tarea;
	}

	public List<Tarea> find(String nombre) {
		Tarea example = new Tarea();
		example.setNombre(nombre);
		return this.searchByExample(example);		
	}
	
	public Tarea get(String nombre) {
		List<Tarea> tareas = this.find(nombre);
		if(tareas.isEmpty())
			throw new UserException("No se encontró la tarea : " + nombre);
		
		return tareas.get(0);
	}

	public List<Tarea> getTareas() {
		return this.allInstances();
	}
}
