package practicas.practica2;

import java.io.File;
import java.util.List;

public interface RecursosHumanos {
	
	/**
	 * A partir de un fichero con un array de empleados en formato Json, obtendrá la lista de empleados
	 * 
	 * @param file
	 * @return
	 */
	List<Empleado> getEmpleadosFromJsonFile(File file);

	/**
	 * A partir de un fichero con un empleado, devolverá el objeto empleado
	 * @param file
	 * @return
	 */
	Empleado getEmpleadoFromJsonFile(File file);
}
