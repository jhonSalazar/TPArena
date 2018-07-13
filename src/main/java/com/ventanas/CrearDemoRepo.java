package com.ventanas;

import org.uqbar.arena.bootstrap.Bootstrap;

import com.modelo.dominio.Estudiante;
import com.modelo.dominio.Tarea;
import com.repositorios.iu.RepositorioEstudiantes;
import com.repositorios.iu.RepositorioTareas;


public class CrearDemoRepo implements Bootstrap {

	@Override
	public void run() {
		
		RepositorioEstudiantes  repoEstudianes = RepositorioEstudiantes.getInstance();
		repoEstudianes.createIfNotExists(new Estudiante("Jhon",1111,"Entrega UI","6"));

	}

	@Override
	public boolean isPending() {		
		return RepositorioEstudiantes.getInstance().allInstances().isEmpty();
		
	}

}
