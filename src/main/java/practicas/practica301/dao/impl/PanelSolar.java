package practicas.practica301.dao.impl;

import practicas.practica301.dao.InstalacionElectrica;

public class PanelSolar implements InstalacionElectrica {

    @Override
    public boolean esEcologica() {
        return true;
    }

    @Override
    public int getPotencia() {
        return 10;
    }

    @Override
    public int getCosteHora() {
        return 5;
    }

    @Override
    public int getImporteConsumoHora() {
        return getPotencia() * getCosteHora();
    }

    @Override
    public int consumir(int horas) throws InterruptedException {
        int consumo = 0;
        for (int i=0; i<horas; i++) {
            consumo = consumo + getImporteConsumoHora();
            System.out.println("Consumo: " +consumo);
            Thread.sleep(1000);
        }
        return consumo;
    }
}
