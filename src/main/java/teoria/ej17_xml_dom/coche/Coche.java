package teoria.ej17_xml_dom.coche;

public class Coche {


	private int id;
	private String marca;
	private String modelo;
	private double cilindrada;

	public Coche(int id, String marca, String modelo, double cilindrada) {
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.cilindrada = cilindrada;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(double cilindrada) {
		this.cilindrada = cilindrada;
	}

	@Override
	public String toString() {
		return "Coche [marca=" + marca + ", modelo=" + modelo + ", cilindrada=" + cilindrada + "]";
	}

}