package it.unife.lp.controller;

import it.unife.lp.App;
import it.unife.lp.model.Teacher;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TeacherController {
    @FXML
    private TextField idField;
    @FXML
    private TextField nomeField;
    @FXML
    private TextField cognomeField;
    @FXML
    private TextField materiaField;
    @FXML
    private TextField searchField;

    private List<Teacher> insegnanti;

    public TeacherController() {
        this.insegnanti = new ArrayList<>();
    }

    @FXML
    private void handleAddTeacher() {
        int id = Integer.parseInt(idField.getText());
        String nome = nomeField.getText();
        String cognome = cognomeField.getText();
        String materia = materiaField.getText();

        Teacher insegnante = new Teacher(id, nome, cognome, materia);
        insegnanti.add(insegnante);
        clearFields();
    }

    @FXML
    private void handleUpdateTeacher() {
        int id = Integer.parseInt(idField.getText());
        Optional<Teacher> insegnanteOptional = insegnanti.stream().filter(t -> t.getId() == id).findFirst();
        if (insegnanteOptional.isPresent()) {
            Teacher insegnante = insegnanteOptional.get();
            insegnante.setNome(nomeField.getText());
            insegnante.setCognome(cognomeField.getText());
            insegnante.setMateria(materiaField.getText());
        }
        clearFields();
    }

    @FXML
    private void handleDeleteTeacher() {
        int id = Integer.parseInt(idField.getText());
        insegnanti.removeIf(t -> t.getId() == id);
        clearFields();
    }

    @FXML
    private void handleSearchTeacher() {
        String searchText = searchField.getText();
        Optional<Teacher> insegnanteOptional = insegnanti.stream()
                .filter(t -> String.valueOf(t.getId()).equals(searchText) || t.getNome().equalsIgnoreCase(searchText))
                .findFirst();
        if (insegnanteOptional.isPresent()) {
            Teacher insegnante = insegnanteOptional.get();
            idField.setText(String.valueOf(insegnante.getId()));
            nomeField.setText(insegnante.getNome());
            cognomeField.setText(insegnante.getCognome());
            materiaField.setText(insegnante.getMateria());
        } else {
            clearFields();
        }
    }

    private void clearFields() {
        idField.clear();
        nomeField.clear();
        cognomeField.clear();
        materiaField.clear();
    }

    @FXML
    private void goToStudentView() throws IOException {
        App.setRoot("view/StudentView");
    }

    @FXML
    private void goToCourseView() throws IOException {
        App.setRoot("view/CourseView");
    }

    @FXML
    private void showAllTeachers() throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("view/TeacherListView.fxml"));
        Parent root = loader.load();
        TeacherListController controller = loader.getController();
        controller.setTeacherList(insegnanti);
        Stage stage = new Stage();
        stage.setTitle("All Teachers");
        stage.setScene(new Scene(root, 640, 480));
        stage.show();
    }
}