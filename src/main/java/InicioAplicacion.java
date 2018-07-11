import com.modelo.dominio.Estudiante;
import com.ventanas.VentanaAplicacion;



public class InicioAplicacion {
	public static void main(String[] args) {
	    new VentanaAplicacion(new Estudiante()).startApplication();
	}

}
