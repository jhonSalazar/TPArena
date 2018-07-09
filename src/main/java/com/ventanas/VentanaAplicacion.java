package com.ventanas;


import org.uqbar.arena.Application;

import org.uqbar.arena.windows.Window;
import com.modelo.dominio.Estudiante;


public class VentanaAplicacion  extends Application{
	

	/*public static void main(String[] args) {
		
		new VentanaAplicacion().start();
	}*/

	@Override
	protected Window<?> createMainWindow() {
		// TODO Auto-generated method stub
	//	return new VentanaNotas(this);
		return new VentanaEstudiante(new Estudiante());
	}


	
}
