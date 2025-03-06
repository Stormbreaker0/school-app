package it.unife.lp.controller;

import it.unife.lp.App;
import it.unife.lp.model.Course;
import it.unife.lp.model.Student;
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

public class CourseController {
    @FXML
    private TextField idField;
    @FXML
    private TextField nomeField;
    @FXML
    private TextField descrizioneField;
    @FXML
    private TextField searchField;
    @FXML
    private TextField studentIdField;
    @FXML
    private TextField teacherIdField;

    private List<Course> corsi;

    public CourseController() {
        this.corsi = new ArrayList<>();
    }

    @FXML
    private void handleAddCourse() {
        int id = Integer.parseInt(idField.getText());
        String nome = nomeField.getText();
        String descrizione = descrizioneField.getText();

        Course corso = new Course(id, nome, descrizione);
        corsi.add(corso);
        clearFields();
    }

    @FXML
    private void handleUpdateCourse() {
        int id = Integer.parseInt(idField.getText());
        Optional<Course> corsoOptional = corsi.stream().filter(c -> c.getId() == id).findFirst();
        if (corsoOptional.isPresent()) {
            Course corso = corsoOptional.get();
            corso.setNome(nomeField.getText());
            corso.setDescrizione(descrizioneField.getText());
        }
        clearFields();
    }

    @FXML
    private void handleDeleteCourse() {
        int id = Integer.parseInt(idField.getText());
        corsi.removeIf(c -> c.getId() == id);
        clearFields();
    }

    @FXML
    private void handleSearchCourse() {
        String searchText = searchField.getText();
        Optional<Course> corsoOptional = corsi.stream()
                .filter(c -> String.valueOf(c.getId()).equals(searchText) || c.getNome().equalsIgnoreCase(searchText))
                .findFirst();
        if (corsoOptional.isPresent()) {
            Course corso = corsoOptional.get();
            idField.setText(String.valueOf(corso.getId()));
            nomeField.setText(corso.getNome());
            descrizioneField.setText(corso.getDescrizione());
        } else {
            clearFields();
        }
    }

    @FXML
    private void handleAddStudentToCourse() {
        int courseId = Integer.parseInt(idField.getText());
        int studentId = Integer.parseInt(studentIdField.getText());
        Optional<Course> corsoOptional = corsi.stream().filter(c -> c.getId() == courseId).findFirst();
        if (corsoOptional.isPresent()) {
            Course corso = corsoOptional.get();
            // Assuming you have a method to get a student by ID
            Student student = getStudentById(studentId);
            if (student != null) {
                corso.aggiungiStudente(student);
            }
        }
        studentIdField.clear();
    }

    @FXML
    private void handleRemoveStudentFromCourse() {
        int courseId = Integer.parseInt(idField.getText());
        int studentId = Integer.parseInt(studentIdField.getText());
        Optional<Course> corsoOptional = corsi.stream().filter(c -> c.getId() == courseId).findFirst();
        if (corsoOptional.isPresent()) {
            Course corso = corsoOptional.get();
            // Assuming you have a method to get a student by ID
            Student student = getStudentById(studentId);
            if (student != null) {
                corso.rimuoviStudente(student);
            }
        }
        studentIdField.clear();
    }

    @FXML
    private void handleAssignTeacherToCourse() {
        int courseId = Integer.parseInt(idField.getText());
        int teacherId = Integer.parseInt(teacherIdField.getText());
        Optional<Course> corsoOptional = corsi.stream().filter(c -> c.getId() == courseId).findFirst();
        if (corsoOptional.isPresent()) {
            Course corso = corsoOptional.get();
            // Assuming you have a method to get a teacher by ID
            Teacher teacher = getTeacherById(teacherId);
            if (teacher != null) {
                corso.setTeacher(teacher);
            }
        }
        teacherIdField.clear();
    }

    @FXML
    private void handleRemoveTeacherFromCourse() {
        int courseId = Integer.parseInt(idField.getText());
        Optional<Course> corsoOptional = corsi.stream().filter(c -> c.getId() == courseId).findFirst();
        if (corsoOptional.isPresent()) {
            Course corso = corsoOptional.get();
            corso.removeTeacher();
        }
        teacherIdField.clear();
    }

    private void clearFields() {
        idField.clear();
        nomeField.clear();
        descrizioneField.clear();
    }

    private Student getStudentById(int id) {
        // Implement this method to return a student by ID
        return null;
    }

    private Teacher getTeacherById(int id) {
        // Implement this method to return a teacher by ID
        return null;
    }

    @FXML
    private void goToStudentView() throws IOException {
        App.setRoot("view/StudentView");
    }

    @FXML
    private void goToTeacherView() throws IOException {
        App.setRoot("view/TeacherView");
    }

    @FXML
    private void showAllCourses() throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("view/CourseListView.fxml"));
        Parent root = loader.load();
        CourseListController controller = loader.getController();
        controller.setCourseList(corsi);
        Stage stage = new Stage();
        stage.setTitle("All Courses");
        stage.setScene(new Scene(root, 640, 480));
        stage.show();
    }
}