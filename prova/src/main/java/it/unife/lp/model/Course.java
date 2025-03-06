package it.unife.lp.model;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private int id;
    private String nome;
    private String descrizione;
    private Teacher insegnante;
    private List<Student> studentiIscritti;

    public Course(int id, String nome, String descrizione) {
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
        this.studentiIscritti = new ArrayList<>();
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

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Teacher getInsegnante() {
        return insegnante;
    }

    public void setInsegnante(Teacher insegnante) {
        this.insegnante = insegnante;
    }

    public List<Student> getStudentiIscritti() {
        return studentiIscritti;
    }

    public void setStudentiIscritti(List<Student> studentiIscritti) {
        this.studentiIscritti = studentiIscritti;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", insegnante=" + insegnante +
                ", studentiIscritti=" + studentiIscritti +
                '}';
    }

    public void aggiungiStudente(Student studente) {
        studentiIscritti.add(studente);
    }

    public void rimuoviStudente(Student studente) {
        studentiIscritti.remove(studente);
    }

    public void setTeacher(Teacher insegnante) {
        this.insegnante = insegnante;
    }

    public void removeTeacher() {
        this.insegnante = null;
    }
}