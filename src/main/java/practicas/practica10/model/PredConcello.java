package practicas.practica10.model;

import java.util.List;

public class PredConcello {
    private int idConcello;
    private List<PredDiaConcello> listaPredDiaConcello;
    private String nome;

    // Getters y Setters
    public int getIdConcello() {
        return idConcello;
    }

    public void setIdConcello(int idConcello) {
        this.idConcello = idConcello;
    }

    public List<PredDiaConcello> getListaPredDiaConcello() {
        return listaPredDiaConcello;
    }

    public void setListaPredDiaConcello(List<PredDiaConcello> listaPredDiaConcello) {
        this.listaPredDiaConcello = listaPredDiaConcello;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "PredConcello{" +
                "idConcello=" + idConcello +
                ", listaPredDiaConcello=" + listaPredDiaConcello +
                ", nome='" + nome + '\'' +
                '}';
    }
}
