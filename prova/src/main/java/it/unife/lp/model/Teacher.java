package it.unife.lp.model;

import java.util.ArrayList;
import java.util.List;

public class Teacher {
    private int id;
    private String nome;
    private String cognome;
    private String materia;
    private List<Course> corsiInsegnati;

    public Teacher(int id, String nome, String cognome, String materia) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.materia = materia;
        this.corsiInsegnati = new ArrayList<>();
    }

    

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getMateria() {
        return materia;
    }
    public void setMateria(String materia) {
        this.materia = materia;
    }

    public List<Course> getCorsiInsegnati() {
        return corsiInsegnati;
    }

    public void setCorsiInsegnati(List<Course> corsiInsegnati) {
        this.corsiInsegnati = corsiInsegnati;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", materia='" + materia + '\'' +
                ", corsiInsegnati=" + corsiInsegnati +
                '}';
    }

    public void aggiungiCorso(Course corso) {
        corsiInsegnati.add(corso);
    }

    public void rimuoviCorso(Course corso) {
        corsiInsegnati.remove(corso);
    }
}