package com.ventanas;


import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.MainWindow;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.*;
import com.modelo.dominio.Estudiante;





@SuppressWarnings("serial")
public class VentanaAplicacion extends MainWindow<Estudiante>{
	public VentanaAplicacion(Estudiante model) {
		super(model);
		// TODO Auto-generated constructor stub
	}
	
	/*
	@Override
	protected void addActions(Panel panelActions) {
		new Button(panelActions)
		.setCaption("Nueva Alumno")
		.onClick(this::registrarAlumno);
	}
	*/

	@Override
	public void createContents(Panel mainPanel) {
		this.setTitle("TPARENA - ALUMNOS");
		
		mainPanel.setLayout(new VerticalLayout());
		Panel form = new Panel(mainPanel);
		
		Panel Formulario = new Panel(mainPanel);
		Formulario.setLayout(new HorizontalLayout());
		//form.setLayout(new ColumnLayout(2));
		
		new org.uqbar.arena.widgets.Label(Formulario).setText("Seleccionar Alumnos");		
		new TextBox(Formulario).bindValueToProperty("nombre");
		
		
		
		Table TablaAlumnos = new Table<>(form, Estudiante.class);
		
		Column<Estudiante> columnaNombre = new Column<Estudiante>(TablaAlumnos);
		columnaNombre.setTitle("Nombre");
		

		Column<Estudiante> columnaLegajo = new Column<Estudiante>(TablaAlumnos);
		columnaLegajo.setTitle("Legajo");
		

		Column<Estudiante> columnaNota = new Column<Estudiante>(TablaAlumnos);
		columnaNota.setTitle("Nota");
		
		TablaAlumnos.setHeight(400);
		TablaAlumnos.setWidth(700);
		
		new Button(mainPanel).setCaption("Ingresar Alumno").onClick(this::registrarAlumno);
		//new Button(mainPanel).setCaption("Cerrar").onClick(onClick);
	}
	public void registrarAlumno() {
		Dialog<?> dialog = new VentanaAlumno(this);
		dialog.open();
		dialog.onAccept(() -> {});
	}

}

