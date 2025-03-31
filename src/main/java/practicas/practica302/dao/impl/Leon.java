package practicas.practica302.dao.impl;

import practicas.practica302.dao.Animal;

public class Leon implements Animal {

    @Override
    public String hacerSonido() {
        return "Rugido!";
    }

    @Override
    public String bañar() {
        return "No me toques marrano! Los felinos nos limpiamos solitos";
    }

    @Override
    public String alimentar() {
        return "Quiero carne...";
    }

    @Override
    public String dormir() {
        return "Duermo con los ojos abiertos.... para acechar a mis presas zzzzz!";
    }
}
