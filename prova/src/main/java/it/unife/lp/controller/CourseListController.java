package it.unife.lp.controller;

import it.unife.lp.model.Course;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.List;

public class CourseListController {

    @FXML
    private ListView<String> courseListView;

    private ObservableList<String> courseList;

    public CourseListController() {
        courseList = FXCollections.observableArrayList();
    }

    @FXML
    public void initialize() {
        courseListView.setItems(courseList);
    }

    public void setCourseList(List<Course> courses) {
        courseList.clear();
        for (Course course : courses) {
            courseList.add(course.toString());
        }
    }
}