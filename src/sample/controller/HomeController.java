package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HomeController {



    private Stage createStage(String title, Parent parent){
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle(title);
        stage.initStyle(StageStyle.UTILITY);
        return stage;

    }


    @FXML
    void exitApp(MouseEvent event) {

    }

    @FXML
    void signOut(MouseEvent event) throws IOException {

        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
        Parent loginRoot = FXMLLoader.load(getClass().getResource("/sample/view/home/login.fxml"));
        createStage("Login Page", loginRoot).showAndWait();
    }


    @FXML
    void studentAction(ActionEvent e) throws IOException {
        String menu = ((MenuItem) e.getSource()).getText();

        switch (menu){
            case "Add Student":
                    Parent addStudentRoot = FXMLLoader.load(getClass().getResource("/sample/view/student/addstudent.fxml"));
                    createStage("Add Student", addStudentRoot).showAndWait();
                break;

            case "Remove Student":
                    Parent removeStudentRoot = FXMLLoader.load(getClass().getResource("/sample/view/student/removestudent.fxml"));
                    createStage("Remove Student", removeStudentRoot).showAndWait();
                break;

            case "Edit Student":
                    Parent editStudentRoot = FXMLLoader.load(getClass().getResource("/sample/view/student/editstudent.fxml"));
                    createStage("Edit Student", editStudentRoot).showAndWait();
                break;

            case "View Student":
                    Parent viewStudentRoot = FXMLLoader.load(getClass().getResource("/sample/view/student/viewstudent.fxml"));
                    createStage("View Student", viewStudentRoot).showAndWait();
                break;
            default:
                break;
        }

    }

    @FXML
    void courseAction(ActionEvent e) throws IOException {
        String menu = ((MenuItem) e.getSource()).getText();

        switch (menu){
            case "Add Course":
                    Parent addCourseRoot = FXMLLoader.load(getClass().getResource("/sample/view/course/addcourse.fxml"));
                    createStage("Add Course", addCourseRoot).showAndWait();
                break;

            case "Remove Course":
                    Parent removeCourseRoot = FXMLLoader.load(getClass().getResource("/sample/view/course/removecourse.fxml"));
                    createStage("Remove Course", removeCourseRoot).showAndWait();
                break;

            case "Edit Course":
                    Parent editCourseRoot = FXMLLoader.load(getClass().getResource("/sample/view/course/editcourse.fxml"));
                    createStage("Edit Course", editCourseRoot).showAndWait();

                break;
            case "View Course":
                    Parent viewCourseRoot = FXMLLoader.load(getClass().getResource("/sample/view/course/viewcourse.fxml"));
                    createStage("View Course", viewCourseRoot).showAndWait();
                break;
            default:
                break;
        }

    }

    @FXML
    void instructorAction(ActionEvent e) throws IOException {
        String menu = ((MenuItem) e.getSource()).getText();

        switch (menu){
            case "Add Instructor":
                    Parent addInstructorRoot = FXMLLoader.load(getClass().getResource("/sample/view/instructor/addinstructor.fxml"));
                    createStage("Add Instructor", addInstructorRoot).showAndWait();
                break;

            case "Remove Instructor":
                    Parent removeInstructorRoot = FXMLLoader.load(getClass().getResource("/sample/view/instructor/removeinstructor.fxml"));
                    createStage("Remove Instructor", removeInstructorRoot).showAndWait();
                break;

            case "Edit Instructor":
                    Parent editInstructorRoot = FXMLLoader.load(getClass().getResource("/sample/view/instructor/editinstructor.fxml"));
                    createStage("Edit Instructor", editInstructorRoot).showAndWait();
                break;

            case "View Instructor":
                    Parent viewInstructorRoot = FXMLLoader.load(getClass().getResource("/sample/view/instructor/viewinstructor.fxml"));
                    createStage("View  Instructor", viewInstructorRoot).showAndWait();
                break;
            default:
                break;
        }

    }


    public void quitAction(ActionEvent actionEvent) {
    }
}
