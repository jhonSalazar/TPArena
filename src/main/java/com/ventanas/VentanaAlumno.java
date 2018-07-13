package com.ventanas;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import com.vistasmodelos.VistaEstudiante;
import com.modelo.dominio.Estudiante;

public class VentanaAlumno extends Dialog<VistaEstudiante>{
	
	public VentanaAlumno(WindowOwner owner) {
		super(owner, new VistaEstudiante(null));
	}

	@Override
	public void createContents(Panel mainPanel) {
		
		
		
		//Panel form = new Panel(mainPanel);
		//form.setLayout(new ColumnLayout(2));
		//this.setTitle("Ingreso de alumnos");
		
		//new Label(form).setText("Nombre");
		//new Label(form).setText("Legajo");
		
		mainPanel.setLayout(new VerticalLayout());
		Panel Formulario = new Panel(mainPanel);
		Formulario.setLayout(new HorizontalLayout());
		Panel FormularioLeg = new Panel(mainPanel);
		FormularioLeg.setLayout(new HorizontalLayout());
		Panel Notas = new Panel(mainPanel);
		Notas.setLayout(new HorizontalLayout());
		
		Panel Botones = new Panel(mainPanel);
		Botones.setLayout(new HorizontalLayout());
		
		//.setLayout(new ColumnLayout(2));

	    new org.uqbar.arena.widgets.Label(Formulario).setText("Nombre: ");
	    new TextBox(Formulario);
	    new org.uqbar.arena.widgets.Label(FormularioLeg).setText("Legajo: ");
	    new org.uqbar.arena.widgets.Label(FormularioLeg).setText("  ");
	    new TextBox(FormularioLeg);
	    new org.uqbar.arena.widgets.Label(Notas).setText("Nota:  ");
	    new org.uqbar.arena.widgets.Label(Notas).setText("     ");
	    new TextBox(Notas);
	    addActions(Botones);
		
	}


	@Override
	protected void addActions(Panel actions) {
		new Button(actions).setCaption("Aceptar").onClick(this::accept).setAsDefault();
		new Button(actions).setCaption("Cancelar").onClick(this::cancel);
	}

	@Override
	protected void executeTask() {
		System.out.println("Alumno Ingresado");
		super.executeTask();
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		// TODO Auto-generated method stub
		
	}

}
