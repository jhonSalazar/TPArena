package com.ventanas;
import org.uqbar.arena.bindings.NotNullObservable;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import com.ViewModel.EstudianteViewModel;
import com.modelo.dominio.Estudiante;

@SuppressWarnings("serial")
public class BuscarEstudiantesVentana extends SimpleWindow<EstudianteViewModel> {

	public BuscarEstudiantesVentana(WindowOwner parent) {
		super(parent, new EstudianteViewModel());
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {	
		this.setTitle("Notas de Alumnos");
		Table<Estudiante> table = new Table<Estudiante>(mainPanel, Estudiante.class);
		table.setHeight(200);
		table.setWidth(450);
		table.bindItemsToProperty("estudiantes");
		table.bindValueToProperty("estudiante");

		Column<Estudiante> nombreColumn = new Column<Estudiante>(table);
		nombreColumn.setTitle("nombre");
		nombreColumn.setFixedSize(150);
		nombreColumn.bindContentsToProperty("nombre");
	
		
		Column<Estudiante> numeroColumn = new Column<Estudiante>(table);
		numeroColumn.setTitle("Número");
		numeroColumn.setFixedSize(100);
		numeroColumn.bindContentsToProperty("legajo");
	
		Column<Estudiante> modeloColumn = new Column<Estudiante>(table);
		modeloColumn.setTitle("Tarea");
		modeloColumn.setFixedSize(150);
		modeloColumn.bindContentsToProperty("tarea");
		
		Column<Estudiante> notaColum = new Column<Estudiante>(table);
		notaColum.setTitle("Nota");
		notaColum.setFixedSize(30);
		notaColum.bindContentsToProperty("nota");

	}
	
	@Override
	protected void addActions(Panel actionsPanel) { }
	


}
