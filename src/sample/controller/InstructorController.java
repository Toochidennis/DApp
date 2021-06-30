package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import sample.model.UserModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InstructorController {
    UserModel instructor = new UserModel();
    String dbTable = "users";

    @FXML
    private TextField txtFirstname;

    @FXML
    private TextField txtMiddleName;

    @FXML
    private TextField txtLastname;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPhone;

    @FXML
    private RadioButton btnMale;

    @FXML
    private RadioButton btnFemale;

    @FXML
    private ComboBox<?> txtState;

    @FXML
    private DatePicker txtDate;

    @FXML
    private TextField txtAddress;

    @FXML
    private  String radioButtonLbl;


    public String getTxtFirstname() {
        return txtFirstname.getText();
    }

    public String getTxtMiddleName() {
        return txtMiddleName.getText();
    }

    public String getTxtLastname() {
        return txtLastname.getText();
    }

    public String getTxtEmail() {
        return txtEmail.getText();
    }

    public String getTxtPhone() {
        return txtPhone.getText();
    }

    public RadioButton getBtnMale() {
        return btnMale;
    }

    public RadioButton getBtnFemale() {
        return btnFemale;
    }

    public String getTxtState() {
        return txtState.getEditor().getText();
    }

    public String getTxtDate() {
        return txtDate.getEditor().getText();
    }

    public String getTxtAddress() {
        return txtAddress.getText();
    }


    public String getRadioButtonLbl() {
        return radioButtonLbl;
    }


    @FXML
    void exitApp(MouseEvent event) {

    }

    @FXML
    void femaleAction(ActionEvent event) {
        radioButtonLbl = btnFemale.getText();

    }

    @FXML
    void maleAction(ActionEvent event) {
        radioButtonLbl = btnMale.getText();

    }

    @FXML
    void submitAction(MouseEvent event) throws SQLException {

        instructor.insertUser(getTxtFirstname(),getTxtMiddleName(),
                getTxtLastname(), getTxtEmail(), getRadioButtonLbl(),
                getTxtPhone(),
                getTxtState(), getTxtDate(), getTxtAddress(), dbTable);

        alert();
        clearFields();


    }


    public void alert(){
        Alert alert = new Alert((Alert.AlertType.INFORMATION));
        alert.setTitle("Message Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Student has been submitted successfully");
        alert.showAndWait();
    }

    public void clearFields(){
        txtFirstname.setText("");
        txtMiddleName.setText("");
        txtLastname.setText("");
        txtEmail.setText("");
        btnMale.setText("");
        btnFemale.setText("");
        txtPhone.setText("");
        txtState.getEditor().setText("");
        txtDate.getEditor().setText("");
        txtAddress.setText("");
    }



}





