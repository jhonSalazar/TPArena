package com.ventanas;

import org.uqbar.arena.windows.WindowOwner;

import com.modelo.dominio.*;


@SuppressWarnings("serial")
public class CrearEstudianteVentana extends EditarEstudianteVentana {

	public CrearEstudianteVentana(WindowOwner owner) {
		super(owner, new Estudiante());
		this.setTitle("Generar un nuevo Estudiante");
	}

}
