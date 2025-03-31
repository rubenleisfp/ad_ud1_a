package practicas.practica10.service.dto;

public class TemperaturaMedia {

    private double tmax;
    private double tmi;

    public TemperaturaMedia() {
    }

    public TemperaturaMedia(double tmax, double tmi) {
        this.tmax = tmax;
        this.tmi = tmi;
    }


    public double getTmax() {
        return tmax;
    }

    public void setTmax(double tmax) {
        this.tmax = tmax;
    }

    public double getTmi() {
        return tmi;
    }

    public void setTmi(double tmi) {
        this.tmi = tmi;
    }
}
