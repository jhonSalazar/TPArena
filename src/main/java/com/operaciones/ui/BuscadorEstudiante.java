package com.operaciones.ui;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.utils.Observable;

import com.modelo.dominio.*;
import com.repositorios.iu.*;


@Observable
public class BuscadorEstudiante {
	
	private int legajo;
	private String nombre;
	private String tarea;
	private String nota;
	
	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	private List<Estudiante> resultados;
	private Estudiante estudianteSeleccionado;
	
	public String getTarea() {
		return tarea;
	}

	public void setTarea(String tarea) {
		this.tarea = tarea;
	}

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public Estudiante getEstudianteSeleccionado() {
		return estudianteSeleccionado;
	}

	public void setEstudianteSeleccionado(Estudiante estudianteSeleccionado) {
		this.estudianteSeleccionado = estudianteSeleccionado;
	}



	// ********************************************************
	// ** Acciones
	// ********************************************************

	public void buscar() {
		this.resultados = new ArrayList<Estudiante>();
		this.resultados = RepositorioEstudiantes.getInstance().search(this.legajo, this.nombre,this.tarea,this.nota);
	}

	public void limpiar() {
		this.nombre = "";
		this.legajo = 0;
		this.resultados = new ArrayList<Estudiante>();
	}

	public void eliminarCelularSeleccionado() {
		RepositorioEstudiantes.getInstance().delete(this.getEstudianteSeleccionado());
		this.buscar();
	}

	// ********************************************************
	// ** Accessors
	// ********************************************************

	public int getNumero() {
		return this.legajo;
	}

	public void setNumero(int legajo) {
		this.legajo = legajo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Estudiante getEstudianteSeleccionado1() {
		return this.estudianteSeleccionado;
	}

	public void setCelularSeleccionado(Estudiante estudianteSeleccionado) {
		this.estudianteSeleccionado = estudianteSeleccionado;
	}

	public List<Estudiante> getResultados() {
		return this.resultados;
	}

	public void setResultados(List<Estudiante> resultados) {
		this.resultados = resultados;
	}
}
