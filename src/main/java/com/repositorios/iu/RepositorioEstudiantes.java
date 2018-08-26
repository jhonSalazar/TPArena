package com.repositorios.iu;

import java.util.List;
import java.util.ArrayList;

import org.uqbar.commons.utils.Observable;
import com.modelo.dominio.*;

@SuppressWarnings("serial")
@Observable
public class RepositorioEstudiantes //extends PersistentRepo<Estudiante>
{
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
	
	public List<Estudiante> estudiantes = new ArrayList<Estudiante>();
	
	public List<Estudiante> all(){
		return this.estudiantes;
	}
	
	public void agregarEstudiante (Estudiante estudiante) {
		estudiantes.add(estudiante);
	}

}
