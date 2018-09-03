package com.ventanas;

import com.modelo.dominio.Estudiante;
import com.repositorios.iu.RepositorioEstudiantes;

public class CrearDemoRepo{

	public static void run() {	
		RepositorioEstudiantes  repoEstudianes = RepositorioEstudiantes.getInstance();
		repoEstudianes.agregarEstudiante(new Estudiante("Fede",1111,"Entrega TP Arena","6"));
		repoEstudianes.agregarEstudiante(new Estudiante("Fede",1111,"Tp Sistemas operativos","10"));
		repoEstudianes.agregarEstudiante(new Estudiante("Fede",1111,"Parcial economía","8"));
		
		}
	
}