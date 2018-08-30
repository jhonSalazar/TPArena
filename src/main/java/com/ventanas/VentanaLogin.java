package com.ventanas;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.TaskWindow;
import org.uqbar.arena.windows.WindowOwner;
import com.ViewModel.LoginViewModel;



public class VentanaLogin extends SimpleWindow<LoginViewModel> {

	public VentanaLogin(WindowOwner owner) {
		super(owner, new LoginViewModel());
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		Panel form = new Panel(mainPanel);
		form.setLayout(new ColumnLayout(2));
		this.setTitle("Ingreso del Alumno");
		
			
		new Label(form).setText("Legajo");
		new NumericField(form).setWidth(150);//.bindValueToProperty("legajo");
		
		new Label(form).setText("Password");
		new TextBox(form).setWidth(200);//.bindValueToProperty("clave");
		
		Panel panelBotones = new Panel(mainPanel);
		panelBotones.setLayout(new HorizontalLayout());
		panelBotones.setLayout(new ColumnLayout(4));
		
		new Button(panelBotones)
		.setCaption("Ingresar")
		.onClick( () -> this.mostrarAlumno());
	}

	@Override
	protected void addActions(Panel actions) {

	}
	
	public void mostrarAlumno() {
		SimpleWindow<?> dialog = new BuscarEstudiantesVentana(this);
		dialog.open();
	}
	

}