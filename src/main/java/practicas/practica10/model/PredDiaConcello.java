package practicas.practica10.model;

public class PredDiaConcello {
    private Ceo ceo;
    private String dataPredicion;
    private Integer nivelAviso; // Puede ser null
    private PChoiva pchoiva;
    private int tMax;
    private int tMin;
    private Integer tmaxFranxa; // Puede ser null
    private Integer tminFranxa; // Puede ser null
    private int uvMax;
    private Vento vento;

    // Getters y Setters
    public Ceo getCeo() {
        return ceo;
    }

    public void setCeo(Ceo ceo) {
        this.ceo = ceo;
    }

    public String getDataPredicion() {
        return dataPredicion;
    }

    public void setDataPredicion(String dataPredicion) {
        this.dataPredicion = dataPredicion;
    }

    public Integer getNivelAviso() {
        return nivelAviso;
    }

    public void setNivelAviso(Integer nivelAviso) {
        this.nivelAviso = nivelAviso;
    }

    public PChoiva getPchoiva() {
        return pchoiva;
    }

    public void setPchoiva(PChoiva pchoiva) {
        this.pchoiva = pchoiva;
    }

    public int gettMax() {
        return tMax;
    }

    public void settMax(int tMax) {
        this.tMax = tMax;
    }

    public int gettMin() {
        return tMin;
    }

    public void settMin(int tMin) {
        this.tMin = tMin;
    }

    public Integer getTmaxFranxa() {
        return tmaxFranxa;
    }

    public void setTmaxFranxa(Integer tmaxFranxa) {
        this.tmaxFranxa = tmaxFranxa;
    }

    public Integer getTminFranxa() {
        return tminFranxa;
    }

    public void setTminFranxa(Integer tminFranxa) {
        this.tminFranxa = tminFranxa;
    }

    public int getUvMax() {
        return uvMax;
    }

    public void setUvMax(int uvMax) {
        this.uvMax = uvMax;
    }

    public Vento getVento() {
        return vento;
    }

    public void setVento(Vento vento) {
        this.vento = vento;
    }

    @Override
    public String toString() {
        return "PredDiaConcello{" +
                "ceo=" + ceo +
                ", dataPredicion='" + dataPredicion + '\'' +
                ", nivelAviso=" + nivelAviso +
                ", pchoiva=" + pchoiva +
                ", tMax=" + tMax +
                ", tMin=" + tMin +
                ", tmaxFranxa=" + tmaxFranxa +
                ", tminFranxa=" + tminFranxa +
                ", uvMax=" + uvMax +
                ", vento=" + vento +
                '}';
    }
}