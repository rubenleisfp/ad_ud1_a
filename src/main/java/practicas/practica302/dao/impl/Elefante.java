package practicas.practica302.dao.impl;

import practicas.practica302.dao.Animal;

public class Elefante implements Animal {
    @Override
    public String hacerSonido() {
        return "Barrito!";
    }

    @Override
    public String bañar() {
        return "No hace falta que me bañes, ya lo hago solito con la trompa, llevame al lago!";
    }

    @Override
    public String alimentar() {
        return "Llevame al campo para comer!";
    }

    @Override
    public String dormir() {
        return "Estoy durmiendo de pie y no voy trompa!!! zzz";
    }
}
