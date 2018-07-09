package com.ventanas;


import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.MainWindow;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.*;
import com.modelo.dominio.Estudiante;




@SuppressWarnings("serial")
public class VentanaEstudiante extends MainWindow<Estudiante>{
	public VentanaEstudiante(Estudiante model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createContents(Panel mainPanel) {
		
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
		
		TablaAlumnos.setHeight(500);
		TablaAlumnos.setWidth(700);
		
		new Button(mainPanel).setCaption("Ingresar Alumno");
		mainPanel.setWidth(600);
	}
	
	public static void main(String[] args) {
	    new VentanaEstudiante(new Estudiante()).startApplication();
	}

	
}
