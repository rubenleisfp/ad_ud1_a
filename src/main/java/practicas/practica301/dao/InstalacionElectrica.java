package practicas.practica301.dao;

public interface InstalacionElectrica {

    boolean esEcologica();
    int getPotencia();
    int getCosteHora();
    int getImporteConsumoHora();
    int consumir(int horas) throws InterruptedException;
}
