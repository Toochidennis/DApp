package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import sample.model.CourseModel;

import java.sql.SQLException;

public class CourseController {
    CourseModel course = new CourseModel();
    String table = "courses";

    @FXML
    private TextField txtTitle;

    @FXML
    private TextField txtInstructor;

    @FXML
    private TextField txtDuration;

    @FXML
    private TextArea txtDescription;

    public String getTable() {
        return table;
    }

    public String getTxtTitle() {
        return txtTitle.getText();
    }

    public String getTxtInstructor() {
        return txtInstructor.getText();
    }

    public String getTxtDuration() {
        return txtDuration.getText();
    }

    public String getTxtDescription() {
        return txtDescription.getText();
    }

    @FXML
    void addCourse(MouseEvent event) throws SQLException {

        course.insertCourse(getTxtTitle(), getTxtInstructor(),
                getTxtDuration(), getTxtDescription(), getTable());
        alert();
        clearFields();

    }


    public void alert(){
        Alert alert = new Alert((Alert.AlertType.INFORMATION));
        alert.setTitle("Message Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Added successfully");
        alert.setHeight(50);
        alert.setWidth(100);
        alert.showAndWait();
    }

    public void clearFields(){
        txtTitle.setText("");
        txtInstructor.setText("");
        txtDuration.setText("");
        txtDescription.setText("");
    }

    @FXML
    void exitApp(MouseEvent event) {

    }

}
