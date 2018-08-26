package com.ViewModel;

import java.util.List;

import org.uqbar.commons.utils.Observable;

import com.modelo.dominio.Estudiante;
import com.repositorios.iu.RepositorioEstudiantes;


@Observable
public class EstudianteViewModel {

	private Estudiante estudiante;
	private List<Estudiante> estudiantes;
	
	public EstudianteViewModel () {	
		this.estudiantes= RepositorioEstudiantes.getInstance().all();
		
	}

	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	
	
}
