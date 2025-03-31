package practicas.practica301.dao.impl;

import practicas.practica301.dao.InstalacionElectrica;

public class GasNatural implements InstalacionElectrica {

    @Override
    public boolean esEcologica() {
        return false;
    }

    @Override
    public int getPotencia() {
        return 15;
    }

    @Override
    public int getCosteHora() {
        return 10;
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
