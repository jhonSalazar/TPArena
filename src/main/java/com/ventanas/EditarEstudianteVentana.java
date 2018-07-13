package com.ventanas;




import org.uqbar.arena.aop.windows.TransactionalDialog;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.WindowOwner;
import com.modelo.dominio.Estudiante;
import com.repositorios.iu.RepositorioEstudiantes;


@SuppressWarnings("serial")
public class EditarEstudianteVentana extends TransactionalDialog<Estudiante> {

	public EditarEstudianteVentana(WindowOwner owner, Estudiante model) {
		super(owner, model);
		this.setTitle("Editar datos del Estudiante");
	}

	@SuppressWarnings("unchecked")
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
		
		new Label(form).setText("Tarea");
		new TextBox(form)
			.setWidth(200)
			.bindValueToProperty("tarea");
		
		new Label(form).setText("Nota");
		new TextBox(form)
			.setWidth(200)
			.bindValueToProperty("nota");
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
