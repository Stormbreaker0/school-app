package it.unife.lp.model;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private int id;
    private String nome;
    private String cognome;
    private String dataNascita;
    private String classe;
    private List<Course> corsi;

    public Student(int id, String nome, String cognome, String dataNascita, String classe) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.classe = classe;
        this.corsi = new ArrayList<>();
    }

    // Getters and Setters
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

    public String getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public List<Course> getCorsi() {
        return corsi;
    }

    public void setCorsi(List<Course> corsi) {
        this.corsi = corsi;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataNascita='" + dataNascita + '\'' +
                ", classe='" + classe + '\'' +
                ", corsi=" + corsi +
                '}';
    }

    public void aggiungiCorso(Course corso) {
        corsi.add(corso);
    }

    public void rimuoviCorso(Course corso) {
        corsi.remove(corso);
    }
}