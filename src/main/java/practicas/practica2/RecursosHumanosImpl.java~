package practicas.practica2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

public class RecursosHumanosImpl implements RecursosHumanos{


	@Override
	public Empleado getEmpleadoFromJsonFile(File file) {
		Empleado empleado = null;
		try {
			final String FORMATO_FECHA = "dd/MM/yyyy";
			final DateFormat DF = new SimpleDateFormat(FORMATO_FECHA);
			final Gson gson = new GsonBuilder().setDateFormat(FORMATO_FECHA).create();
			
			empleado= gson.fromJson(new FileReader(file), Empleado.class);
		
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			System.out.println(e);
		}
		return empleado;
	}
	
	@Override
	public List<Empleado> getEmpleadosFromJsonFile(File file) {
		try {
			final String FORMATO_FECHA = "dd/MM/yyyy";
			final DateFormat DF = new SimpleDateFormat(FORMATO_FECHA);
			
			Type listType = new TypeToken<ArrayList<Empleado>>(){}.getType();
			final Gson gson = new GsonBuilder().setDateFormat(FORMATO_FECHA).create();
			List<Empleado> empleados = gson.fromJson(new FileReader(file), listType);
			return empleados;

		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			System.out.println(e);
		}
		return null;
	}

}
