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
		this.validarClientesDuplicados(estudiante);
		estudiante.validar();
		super.create(estudiante);
	}

	public void createIfNotExists(String  nombre, int legajo) {
		Estudiante estudiante = new Estudiante(nombre, legajo);
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

	protected void validarClientesDuplicados(Estudiante estudiante) {
		if (!this.search(estudiante.getLegajo()).isEmpty()) {
			throw new UserException("Ya existe el estudiante  con el número: " + estudiante.getLegajo());
		}
	}

	// ********************************************************
	// ** Búsquedas
	// ********************************************************

	public List<Estudiante> search(int numero) {
		return this.search(numero, null);
	}

	/**
	 * Busca los celulares que coincidan con los datos recibidos. Tanto número como nombre pueden ser nulos,
	 * en ese caso no se filtra por ese atributo.
	 * Para que funcione correctamente el search by example hay que tener cuidado 
	 * ya que se incluyen en la búsqueda cualquiera de los valores de un objeto example que no sean nulos, esto implica
	 * 1) ojo con los tipos primitivos boolean, int, float, etc.
	 * 2) pero además ojo con los valores inicializados por default, tanto en el constructor como en la definición de la clase
	 * ej: Boolean recibeResumenCuenta = false implica que siempre va a buscar a los clientes que no reciban resumen de cuenta
	 *
	 * Para soportar búsquedas por substring hay que descomentar todo el código de abajo, el problema es que trae 
	 * a memoria todo el grafo de celulares (con una cantidad enorme de celulares puede traer problemas de performance)
	 * En ese caso el celular (12345, "Juan Gonzalez") será contemplado por la búsqueda (23, "Gonza")
	 * 
	 */
	public List<Estudiante> search(int  numero, String nombre) {
		Estudiante estudiante = new Estudiante(nombre, numero);
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
