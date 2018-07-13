import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import com.ventanas.BuscarEstudiantesVentana;
import com.ventanas.*;
import uqbar.arena.persistence.Configuration;


public class InicioAplicacion extends Application {
	
	
	public InicioAplicacion(CrearDemoRepo crearDemoRepo) {
		super(crearDemoRepo);
	}
	
	public static void main(String[] args) {
		Configuration.configure();
		new InicioAplicacion(new CrearDemoRepo()).start();
	}
	
	
	protected Window<?> createMainWindow() {
		return new BuscarEstudiantesVentana( this);
	}
}
