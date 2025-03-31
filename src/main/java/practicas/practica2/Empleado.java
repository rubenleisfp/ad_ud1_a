package practicas.practica2;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Empleado {

	private final int id;

	private final String nombre;

	private final String empresa;

	@SerializedName("vacaciones")
	private final List<SolicitudVacaciones> solicitudes;

	public Empleado(int id, String nombre, String empresa, List<SolicitudVacaciones> solicitudes) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.empresa = empresa;
		this.solicitudes = solicitudes;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getEmpresa() {
		return empresa;
	}

	public List<SolicitudVacaciones> getSolicitudes() {
		return solicitudes;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", empresa=" + empresa + ", solicitudes=" + solicitudes
				+ "]";
	}

	

}