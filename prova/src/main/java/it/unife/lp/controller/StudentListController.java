package it.unife.lp.controller;

import it.unife.lp.model.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.List;

public class StudentListController {

    @FXML
    private ListView<String> studentListView;

    private ObservableList<String> studentList;

    public StudentListController() {
        studentList = FXCollections.observableArrayList();
    }

    @FXML
    public void initialize() {
        studentListView.setItems(studentList);
    }

    public void setStudentList(List<Student> students) {
        studentList.clear();
        for (Student student : students) {
            studentList.add(student.toString());
        }
    }
}