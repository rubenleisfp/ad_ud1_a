package teoria.ej19_json.alumno;

public class Asignatura {

	private String nombre;
	private double calificacion;

	public Asignatura(String nombre, double calificacion) {
		this.nombre = nombre;
		this.calificacion = calificacion;

	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
	@Override
	public String toString() {
		return "Calificacion [nombre=" + nombre + ", calificacion=" + calificacion + "]";
	}
	
}
