package practicas.practica9;

public class Provincia {
	
	private String nombre;
	private int poblacion;
	
	public Provincia(String nombre, int poblacion) {
		this.nombre = nombre;
		this.poblacion = poblacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(int poblacion) {
		this.poblacion = poblacion;
	}
	@Override
	public String toString() {
		return "Provincia [nombre=" + nombre + ", poblacion=" + poblacion + "]";
	}
	
	
}
