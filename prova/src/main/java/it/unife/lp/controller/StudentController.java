package it.unife.lp.controller;

import it.unife.lp.App;
import it.unife.lp.model.Student;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentController {
    @FXML
    private TextField idField;
    @FXML
    private TextField nomeField;
    @FXML
    private TextField cognomeField;
    @FXML
    private TextField dataNascitaField;
    @FXML
    private TextField classeField;
    @FXML
    private TextField searchField;

    private List<Student> studenti;

    public StudentController() {
        this.studenti = new ArrayList<>();
    }

    @FXML
    private void handleAddStudent() {
        int id = Integer.parseInt(idField.getText());
        String nome = nomeField.getText();
        String cognome = cognomeField.getText();
        String dataNascita = dataNascitaField.getText();
        String classe = classeField.getText();

        Student studente = new Student(id, nome, cognome, dataNascita, classe);
        studenti.add(studente);
        clearFields();
    }

    @FXML
    private void handleUpdateStudent() {
        int id = Integer.parseInt(idField.getText());
        Optional<Student> studenteOptional = studenti.stream().filter(s -> s.getId() == id).findFirst();
        if (studenteOptional.isPresent()) {
            Student studente = studenteOptional.get();
            studente.setNome(nomeField.getText());
            studente.setCognome(cognomeField.getText());
            studente.setDataNascita(dataNascitaField.getText());
            studente.setClasse(classeField.getText());
        }
        clearFields();
    }

    @FXML
    private void handleDeleteStudent() {
        int id = Integer.parseInt(idField.getText());
        studenti.removeIf(s -> s.getId() == id);
        clearFields();
    }

    @FXML
    private void handleSearchStudent() {
        String searchText = searchField.getText();
        Optional<Student> studenteOptional = studenti.stream()
                .filter(s -> String.valueOf(s.getId()).equals(searchText) || s.getNome().equalsIgnoreCase(searchText))
                .findFirst();
        if (studenteOptional.isPresent()) {
            Student studente = studenteOptional.get();
            idField.setText(String.valueOf(studente.getId()));
            nomeField.setText(studente.getNome());
            cognomeField.setText(studente.getCognome());
            dataNascitaField.setText(studente.getDataNascita());
            classeField.setText(studente.getClasse());
        } else {
            clearFields();
        }
    }

    private void clearFields() {
        idField.clear();
        nomeField.clear();
        cognomeField.clear();
        dataNascitaField.clear();
        classeField.clear();
    }

    @FXML
    private void goToTeacherView() throws IOException {
        App.setRoot("view/TeacherView");
    }

    @FXML
    private void goToCourseView() throws IOException {
        App.setRoot("view/CourseView");
    }

    @FXML
    private void showAllStudents() throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("view/StudentListView.fxml"));
        Parent root = loader.load();
        StudentListController controller = loader.getController();
        controller.setStudentList(studenti);
        Stage stage = new Stage();
        stage.setTitle("All Students");
        stage.setScene(new Scene(root, 640, 480));
        stage.show();
    }
}