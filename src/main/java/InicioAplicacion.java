import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import com.ventanas.BuscarEstudiantesVentana;
import com.ventanas.*;
import uqbar.arena.persistence.Configuration;


public class InicioAplicacion extends Application {
	
	
	public static void main(String[] args) {
		CrearDemoRepo.run();
		new InicioAplicacion().start();
	}
	
	
	protected Window<?> createMainWindow() {
		return new BuscarEstudiantesVentana(this);
	}
}
