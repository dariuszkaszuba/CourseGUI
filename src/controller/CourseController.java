
package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Course;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Observable;


public class CourseController {

    ObservableList<Course> courses = FXCollections.observableArrayList();
    public static int id;

    @FXML
    private TableView<Course> tbl_course;

    @FXML
    private TableColumn<Course, String> col_cours_name;

    @FXML
    private TableColumn<Course, String> col_course_category;

    @FXML
    private TextField tf_course_name;

    @FXML
    private TextField tf_course_category;

    @FXML
    private DatePicker dp_course_date;

    @FXML
    private TextField tf_course_trainer;

    @FXML
    void addCourse(ActionEvent event) {
        if (!tf_course_name.getText().equals("") && !tf_course_category.getText().equals("") && dp_course_date.getValue() != null) {
            String course_name = tf_course_name.getText();
            String course_category = tf_course_category.getText();
            LocalDate course_date = dp_course_date.getValue();
            String course_trainer = tf_course_trainer.getText();
            Course c = new Course(++id, course_name, course_category, course_date, course_trainer);
            courses.add(c);
            insertCoursesIntoTableView();
            tf_course_name.clear();
            tf_course_category.clear();
            dp_course_date.setValue(null);
            tf_course_trainer.clear();
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Bład");
            a.setHeaderText("Bład dodawania nowego kursu");
            a.setContentText("Musisz podac wszystkie dane w celu dodania nowego kursu");
            a.show();
        }
    }

    @FXML
    void deleteCourse(ActionEvent event) {
        Course c_deleted = tbl_course.getSelectionModel().getSelectedItem();
//        int id_deleted = tbl_course.getSelectionModel().getSelectedItem().getId();
        courses.remove(c_deleted);
        insertCoursesIntoTableView();
    }

    static Course c_selected;

    @FXML
    void getCourse(ActionEvent event) throws IOException {
        c_selected = tbl_course.getSelectionModel().getSelectedItem();
        //wywoalnie nowego widoku
        Stage courseStage= new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/detailCourseView.fxml"));
        courseStage.setTitle("Wybrany kursy");
        courseStage.setScene(new Scene(root));
        courseStage.show();

    }

    private void insertCoursesIntoTableView() {
        col_cours_name.setCellValueFactory(new PropertyValueFactory<Course, String>("course_name"));
        col_course_category.setCellValueFactory(new PropertyValueFactory<Course, String>("course_category"));
        tbl_course.setItems(courses);
    }

    public void initialize() {
        insertCoursesIntoTableView();
    }

}

