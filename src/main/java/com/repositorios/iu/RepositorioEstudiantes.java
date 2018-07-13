package com.repositorios.iu;

import java.io.Serializable;
import java.util.List;

import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;
import com.modelo.dominio.*;
import uqbar.arena.persistence.PersistentRepo;



@SuppressWarnings("serial")
@Observable
public class RepositorioEstudiantes extends PersistentRepo<Estudiante> implements Serializable {
	private static RepositorioEstudiantes instance;

	/**
	 * Definición del Singleton
	 */
	public static synchronized RepositorioEstudiantes getInstance() {
		if (instance == null) {
			instance = new RepositorioEstudiantes();
		}
		return instance;
	}

	private RepositorioEstudiantes() {
	}

	public void create(Estudiante estudiante) {
		this.validarEstudiantesDuplicados(estudiante);
		estudiante.validar();
		super.create(estudiante);
	}

	public void createIfNotExists(String  nombre, int legajo,String tarea,String nota) {
		Estudiante estudiante = new Estudiante(nombre, legajo,tarea,nota);
		this.createIfNotExists(estudiante);
	}
	
	public Estudiante createIfNotExists(Estudiante estudiante) {
		Estudiante estudianteDB = this.get(estudiante.getLegajo());
		if (estudianteDB == null) {
			this.create(estudiante);
			estudianteDB = estudiante;
		}
		return estudianteDB;
	}

	/**
	 * Devuelve un Estudiante en base al número (que no puede repetirse)
	 */
	public Estudiante get(Integer unNumero) {
		List<Estudiante> estudiantes = this.search(unNumero);
		if (estudiantes.isEmpty()) {
			return null;
		} else {
			return estudiantes.get(0);
		}
	}

	protected void validarEstudiantesDuplicados(Estudiante estudiante) {
		/*if (!this.search(estudiante.getLegajo()).isEmpty()) {
			throw new UserException("Ya existe el estudiante  con el número: " + estudiante.getLegajo());
		}*/
	}

	// ********************************************************
	// ** Búsquedas
	// ********************************************************

	public List<Estudiante> search(int numero) {
		return this.search(numero, null,null,null);
	}


	public List<Estudiante> search(int  numero, String nombre,String tarea,String nota) {
		Estudiante estudiante = new Estudiante(nombre, numero,tarea,nota);
		return this.searchByExample(estudiante);
	}

	@Override
	public Class<Estudiante> getEntityType() {
		return Estudiante.class;
	}

	@Override
	public Estudiante createExample() {
		return new Estudiante();
	}
}
