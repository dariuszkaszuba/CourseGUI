package controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Course;
import model.Participant;



public class DetailCourseController {



    @FXML
    private Label lbl_course_name;

    @FXML
    private Label lbl_course_category;

    @FXML
    private Label lbl_course_date;

    @FXML
    private Label lbl_course_trainer;

    @FXML
    private Label lbl_course_participants;

    @FXML
    private TextField tf_particip_name;

    @FXML
    private TextField tf_particip_lastname;

    @FXML
    private TableView<Participant> tbl_particip;

    @FXML
    private TableColumn<Participant, String> col_particip_name;

    @FXML
    private TableColumn<Participant, String> col_particip_last_name;

    @FXML
    void deleteParticipant(ActionEvent event) {

    }
    public static int id;
    @FXML
    void saveParticipant(ActionEvent event) {
        if(!tf_particip_name.getText().equals("")&&!tf_particip_lastname.getText().equals("")){
            String particip_name =tf_particip_name.getText();
            String particip_lastname=tf_particip_lastname.getText();
            Participant p  = new Participant(++id, particip_name, particip_lastname);


        }
    }
    public void initialize(){
        lbl_course_name.setText(CourseController.c_selected.getCourse_name());
        lbl_course_category.setText(CourseController.c_selected.getCourse_category());
        lbl_course_date.setText(CourseController.c_selected.getCourse_date().toString());
        lbl_course_trainer.setText(CourseController.c_selected.getCourse_trainer());
        lbl_course_participants.setText(String.valueOf(CourseController.c_selected.getNoParticipant()));
    }

}

