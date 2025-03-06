package it.unife.lp.controller;

import it.unife.lp.model.Teacher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.List;

public class TeacherListController {

    @FXML
    private ListView<String> teacherListView;

    private ObservableList<String> teacherList;

    public TeacherListController() {
        teacherList = FXCollections.observableArrayList();
    }

    @FXML
    public void initialize() {
        teacherListView.setItems(teacherList);
    }

    public void setTeacherList(List<Teacher> teachers) {
        teacherList.clear();
        for (Teacher teacher : teachers) {
            teacherList.add(teacher.toString());
        }
    }
}