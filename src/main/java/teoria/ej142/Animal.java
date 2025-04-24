package teoria.ej142;

public class Animal {
    private String nombre;
    private int velocidad;
    private int cantidadPatas;
    private boolean puedeVolar;

    public Animal() {

    }
    public Animal(String nombre, int velocidad, int cantidadPatas, boolean puedeVolar) {
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.cantidadPatas = cantidadPatas;
        this.puedeVolar = puedeVolar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getCantidadPatas() {
        return cantidadPatas;
    }

    public void setCantidadPatas(int cantidadPatas) {
        this.cantidadPatas = cantidadPatas;
    }

    public boolean isPuedeVolar() {
        return puedeVolar;
    }

    public void setPuedeVolar(boolean puedeVolar) {
        this.puedeVolar = puedeVolar;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "nombre='" + nombre + '\'' +
                ", velocidad=" + velocidad +
                ", cantidadPatas=" + cantidadPatas +
                ", puedeVolar=" + puedeVolar +
                '}';
    }
}
