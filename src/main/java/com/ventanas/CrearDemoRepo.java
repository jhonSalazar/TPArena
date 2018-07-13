package com.ventanas;

import org.uqbar.arena.bootstrap.Bootstrap;

import com.modelo.dominio.Estudiante;
import com.modelo.dominio.Tarea;
import com.repositorios.iu.RepositorioEstudiantes;
import com.repositorios.iu.RepositorioTareas;


public class CrearDemoRepo implements Bootstrap {

	@Override
	public void run() {
		RepositorioTareas repoTare  = RepositorioTareas.getInstance();
		Tarea tarea = new Tarea("Parcial 1");
		repoTare.createIfNotExists(tarea);
	
		//repoTare.createIfNotExists(new Tarea("Trabajo practico"));
		
		RepositorioEstudiantes  repoEstudianes = RepositorioEstudiantes.getInstance();
		repoEstudianes.createIfNotExists(new Estudiante("Jhon Saalazar ", 1539449));
		repoEstudianes.createIfNotExists(new Estudiante("Fede  ", 1234));
		repoEstudianes.createIfNotExists(new Estudiante("Gaby ", 21212524));
	}

	@Override
	public boolean isPending() {
		
		return RepositorioEstudiantes.getInstance().allInstances().isEmpty();
		
	}

}
