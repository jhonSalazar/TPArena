package com.ventanas;

import org.uqbar.arena.bootstrap.Bootstrap;

import com.repositorios.iu.RepositorioEstudiantes;


public class CrearDemoRepo implements Bootstrap {

	@Override
	public void run() {

		RepositorioEstudiantes repoCelulares = RepositorioEstudiantes.getInstance();
		repoCelulares.createIfNotExists("Jhon Saalazar ", 21212524);
		repoCelulares.createIfNotExists("Fede con todo ", 21212524);
		repoCelulares.createIfNotExists("Gaby durmiendo ", 21212524);
	}

	@Override
	public boolean isPending() {
		// por ahora no funciona pero esta es la idea
		return RepositorioEstudiantes.getInstance().allInstances().isEmpty();
		
	}

}
