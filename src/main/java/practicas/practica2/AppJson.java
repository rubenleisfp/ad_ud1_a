package practicas.practica2;

import java.io.File;
import java.util.List;

public class AppJson {

	public static void main(String[] args) {
		RecursosHumanos recursosHumanos = new RecursosHumanosImpl();
		
		File fileEmpleado = new File("src/main/resources/practicas/practica2/Empleado.json");
		Empleado empleado = recursosHumanos.getEmpleadoFromJsonFile(fileEmpleado);
		System.out.println("Empleado:" + empleado);
		
		File fileEmpleados = new File("src/main/resources/practicas/practica2/Empleados.json");
		List<Empleado> empleados = recursosHumanos.getEmpleadosFromJsonFile(fileEmpleados);
		for (Empleado emp: empleados) {
			System.out.println(emp);
		}
	}
}
