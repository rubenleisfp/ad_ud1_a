package practicas.practica10.model;

public class Ceo {
    private int manha;
    private int noite;
    private int tarde;

    // Getters y Setters
    public int getManha() {
        return manha;
    }

    public void setManha(int manha) {
        this.manha = manha;
    }

    public int getNoite() {
        return noite;
    }

    public void setNoite(int noite) {
        this.noite = noite;
    }

    public int getTarde() {
        return tarde;
    }

    public void setTarde(int tarde) {
        this.tarde = tarde;
    }

    @Override
    public String toString() {
        return "Ceo{" +
                "manha=" + manha +
                ", noite=" + noite +
                ", tarde=" + tarde +
                '}';
    }
}
