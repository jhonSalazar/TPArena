package com.ventanas;

import org.uqbar.arena.aop.windows.TransactionalDialog;
import org.uqbar.arena.bindings.ObservableProperty;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.CheckBox;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.ListBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;

import com.modelo.dominio.Estudiante;
import com.repositorios.iu.RepositorioEstudiantes;

@SuppressWarnings("serial")
public class EditarEstudianteVentana extends TransactionalDialog<Estudiante> {

	public EditarEstudianteVentana(WindowOwner owner, Estudiante model) {
		super(owner, model);
		this.setTitle("Editar datos del cliente");
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		Panel form = new Panel(mainPanel);
		form.setLayout(new ColumnLayout(2));

		new Label(form).setText("Número");
		new NumericField(form)
			.setWidth(150)
			.bindValueToProperty("legajo");

		new Label(form).setText("Nombre del estudiante");
		new TextBox(form)
			.setWidth(200)
			.bindValueToProperty("nombre");

		/*new Label(form).setText("Modelo del aparato");
		Selector<ModeloCelular> selector = new Selector<ModeloCelular>(form); //
		selector.bindValueToProperty("modeloCelular");
		selector.allowNull(false);
		selector.setWidth(200);

		Binding<ModeloCelular, Selector<ModeloCelular>, ListBuilder<ModeloCelular>> itemsBinding = selector.bindItems( //
				new ObservableProperty(RepositorioModelos.getInstance(), "modelos"));
		itemsBinding.setAdapter( //
				new PropertyAdapter(ModeloCelular.class, "descripcionEntera"));

		new Label(form).setText("Recibe resumen cuenta en domicilio");
		CheckBox chkRecibeResumenCuenta = new CheckBox(form);
		chkRecibeResumenCuenta.bindValueToProperty("recibeResumenCuenta");
		chkRecibeResumenCuenta.bindEnabledToProperty("habilitaResumenCuenta");*/
	}

	@Override
	protected void addActions(Panel actions) {
		new Button(actions)
			.setCaption("Aceptar")
			.onClick(() -> {
				RepositorioEstudiantes repoEstudiantes = RepositorioEstudiantes.getInstance();
				Estudiante modelObject = this.getModelObject();
				if (modelObject.isNew()) {
					repoEstudiantes.create(modelObject);
				} else {
					repoEstudiantes.update(modelObject);
				}
				this.accept();
			})
			.setAsDefault()
			.disableOnError();

		new Button(actions) //
				.setCaption("Cancelar").onClick( () -> this.cancel() );
	}
}
