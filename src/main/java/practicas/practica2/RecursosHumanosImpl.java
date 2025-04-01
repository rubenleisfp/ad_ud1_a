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
		throw new UnsupportedOperationException("Operacion a implementar por el alumno");
	}
	
	@Override
	public List<Empleado> getEmpleadosFromJsonFile(File file) {
		throw new UnsupportedOperationException("Operacion a implementar por el alumno");
	}

}
