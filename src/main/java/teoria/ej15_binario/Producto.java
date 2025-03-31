package teoria.ej15_binario;

import java.io.Serializable;

public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nombre;
	private double precio;

	public Producto(String nombre, float precio) {
		this.nombre = nombre;
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", precio=" + precio + "]";
	}

}