package practicas.practica302.service;

import practicas.practica302.dao.Animal;

/**
 * Clase de servicio que nos proporciona la logica funcional de mi zoo
 * Indica como funciona el mismo dependiendo de la hora, dependiendo del animal utilizado
 *
 */
public class ZooService {


    Animal animalFavorito;

    /**
     * Establecemos la implementacion de animal, un objeto concreto que representa a nuestro animal favorito
     * @param animalFav
     */
    public ZooService(Animal animalFav) {
        this.animalFavorito = animalFav;
    }

    /**
     * Dependiendo de la hora, se realiza un trabajo distinto con el animal
     *
     * Saludarlo, alimentarlo, bañarlo o revisar si todo está bien cuando duerme
     *
     * @param hora
     * @return Devuelve la acción realizada por el animal
     */
    public String realizarTrabajo(int hora) {
        String resultado = "";
        if (hora > 5 && hora <13) {
            resultado = this.animalFavorito.hacerSonido();
        } else if (hora >= 13 && hora<17) {
            resultado = this.animalFavorito.alimentar();
        } else if (hora >= 17 && hora<21) {
            resultado = this.animalFavorito.bañar();
        } else {
            resultado = this.animalFavorito.dormir();
        }
        return resultado;
    }
}
