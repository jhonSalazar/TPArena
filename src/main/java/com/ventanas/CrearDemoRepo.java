package com.ventanas;

import com.modelo.dominio.Estudiante;
import com.repositorios.iu.RepositorioEstudiantes;

public class CrearDemoRepo{

	public static void run() {	
		RepositorioEstudiantes  repoEstudianes = RepositorioEstudiantes.getInstance();
		repoEstudianes.agregarEstudiante(new Estudiante("Jhon",1111,"Entrega UI","6"));
		repoEstudianes.agregarEstudiante(new Estudiante("Jhon",1111,"Parcial Disenio","10"));
		repoEstudianes.agregarEstudiante(new Estudiante("Fede",1234,"Parcial Disenio","2"));
		
		}
	
}