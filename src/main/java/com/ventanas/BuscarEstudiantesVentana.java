package com.ventanas;

import java.awt.Color;

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

import com.modelo.dominio.Estudiante;
import com.operaciones.ui.*;

@SuppressWarnings("serial")
public class BuscarEstudiantesVentana extends SimpleWindow<BuscadorEstudiante> {

	public BuscarEstudiantesVentana(WindowOwner parent) {
		super(parent, new BuscadorEstudiante());
		this.getModelObject().buscar();
	}

	/**
	 * El default de la vista es un formulario que permite disparar la búsqueda (invocando con super) Además
	 * le agregamos una grilla con los resultados de esa búsqueda y acciones que pueden hacerse con elementos
	 * de esa búsqueda
	 */
	@Override
	protected void createMainTemplate(Panel mainPanel) {
		this.setTitle("Buscador de Alumnos");
		this.setTaskDescription("Ingrese los parámetros de búsqueda");

		super.createMainTemplate(mainPanel);

		this.createResultsGrid(mainPanel);
		this.createGridActions(mainPanel);

	}

// *************************************************************************
// * FORMULARIO DE BUSQUEDA 
// *************************************************************************
	
	/**
	 * El panel principal de búsuqeda permite filtrar por número o nombre
	 */
	@Override
	protected void createFormPanel(Panel mainPanel) {
		Panel searchFormPanel = new Panel(mainPanel);
		searchFormPanel.setLayout(new ColumnLayout(2));
		
		Panel panelBotones = new Panel(mainPanel);
		panelBotones.setLayout(new HorizontalLayout());
		panelBotones.setLayout(new ColumnLayout(4));

		new Label(searchFormPanel)
			.setText("Número")
			.setForeground(Color.BLUE);
		new NumericField(searchFormPanel)
			.setWidth(150)
			.bindValueToProperty("legajo");

		new Label(searchFormPanel)
			.setText("Nombre ")
			.setForeground(Color.BLUE);
		
		new TextBox(searchFormPanel)
			.setWidth(200)
			.bindValueToProperty("nombre");
		
		new Label(searchFormPanel)
		.setText("Tarea ")
		.setForeground(Color.BLUE);
	
		new TextBox(searchFormPanel)
		.setWidth(200)
		.bindValueToProperty("tarea");
		
		new Button(panelBotones)
		.setCaption("Buscar")
		.onClick( () -> this.getModelObject().buscar() )
		.setAsDefault()
		.disableOnError();

		new Button(panelBotones) //
		.setCaption("Limpiar")
		.onClick( () -> this.getModelObject().limpiar() );

		new Button(panelBotones)//
		.setCaption("Nuevo Estudiante")
		.onClick( () -> this.crearEstudiante() ); 
		
	}

	/**
	 * Acciones asociadas de la pantalla principal. Interesante para ver es cómo funciona el binding que mapea
	 * la acción que se dispara cuando el usuario presiona click Para que el binding sea flexible necesito
	 * decirle objeto al que disparo la acción y el mensaje a enviarle Contra: estoy atado a tener métodos sin
	 * parámetros. Eso me impide poder pasarle parámetros como en el caso del alta/modificación.
	 * Buscar/Limpiar -> son acciones que resuelve el modelo (BuscadorCelular) Nuevo -> necesita disparar una
	 * pantalla de alta, entonces lo resuelve la vista (this)
	 * 
	 */
	@Override
	protected void addActions(Panel actionsPanel) {
		new Button(actionsPanel)
			.setCaption("Buscar")
			.onClick( () -> this.getModelObject().buscar() )
			.setAsDefault()
			.disableOnError();

		new Button(actionsPanel) //
			.setCaption("Limpiar")
			.onClick( () -> this.getModelObject().limpiar() );

		new Button(actionsPanel)//
			.setCaption("Nuevo Estudiante")
			.onClick( () -> this.crearEstudiante() );
	}

// *************************************************************************
// **  RESULTADOS DE LA BUSQUEDA 
// *************************************************************************
	
	/**
	 * Se crea la grilla en el panel de abajo El binding es: el contenido de la grilla en base a los
	 * resultados de la búsqueda Cuando el usuario presiona Buscar, se actualiza el model, y éste a su vez
	 * dispara la notificación a la grilla que funciona como Observer
	 */
	protected void createResultsGrid(Panel mainPanel) {
		Table<Estudiante> table = new Table<Estudiante>(mainPanel, Estudiante.class);
		table.setHeight(200);
		table.setWidth(450);

		table.bindItemsToProperty("resultados");
		table.bindValueToProperty("estudianteSeleccionado");

		this.describeResultsGrid(table);
	}

	/**
	 * Define las columnas de la grilla Cada columna se puede bindear 1) contra una propiedad del model, como
	 * en el caso del número o el nombre 2) contra un transformer que recibe el model y devuelve un tipo
	 * (generalmente String), como en el caso de Recibe Resumen de Cuenta
	 * 
	 * @param table
	 */
	protected void describeResultsGrid(Table<Estudiante> table) {
		new Column<Estudiante>(table) //
			.setTitle("Nombre")
			.setFixedSize(150)
			.bindContentsToProperty("nombre");

		Column<Estudiante> numeroColumn = new Column<Estudiante>(table);
		numeroColumn.setTitle("Número");
		numeroColumn.setFixedSize(100);
		numeroColumn.bindContentsToProperty("legajo");

	/*	Column<Estudiante> modeloColumn = new Column<Estudiante>(table);
		modeloColumn.setTitle("Modelo");
		modeloColumn.setFixedSize(150);
		modeloColumn.bindContentsToProperty("modeloCelular");*/

	/*	Column<Celular> ingresoColumn = new Column<Celular>(table);
		ingresoColumn.setTitle("Recibe resumen de cuenta");
		ingresoColumn.setFixedSize(50);
		ingresoColumn.bindContentsToProperty("recibeResumenCuenta").setTransformer( recibe -> {
			Boolean siRecibe = (Boolean) recibe;
			if(siRecibe == null)
				return "NO";
			return siRecibe ? "SI" : "NO";
		}); */
	}

	protected void createGridActions(Panel mainPanel) {
		Panel actionsPanel = new Panel(mainPanel);
		actionsPanel.setLayout(new HorizontalLayout());

		Button edit = new Button(actionsPanel);
		edit.setCaption("Editar");
		edit.onClick( () -> this.modificarCelular() );

		Button remove = new Button(actionsPanel);
		remove.setCaption("Borrar");
		remove.onClick( () -> this.getModelObject().eliminarCelularSeleccionado() );

		// Deshabilitar los botones si no hay ningún elemento seleccionado en la grilla.
		NotNullObservable elementSelected = new NotNullObservable("estudianteSeleccionado");
		remove.bindEnabled(elementSelected);
		edit.bindEnabled(elementSelected);
	}

	// ********************************************************
	// ** Acciones
	// ********************************************************

	public void crearEstudiante() {
		this.openDialog(new CrearEstudianteVentana(this));
	}

	public void modificarCelular() {
		this.openDialog(
			new EditarEstudianteVentana(
				this, this.getModelObject().getEstudianteSeleccionado()));
	}

	protected void openDialog(Dialog<?> dialog) {
		dialog.onAccept( () -> this.getModelObject().buscar() );
		dialog.open();
	}

}
