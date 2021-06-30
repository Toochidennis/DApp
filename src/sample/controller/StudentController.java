package sample.controller;

import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import sample.model.UserModel;


import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class StudentController implements Initializable {
    UserModel student = new UserModel();
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
    private String radioButtonLbl;

    @FXML
    private ComboBox<?> txtState;

    @FXML
    private DatePicker txtDate;

    @FXML
    private TextField txtAddress;



    @FXML
    private TableView<UserModel> table;

    @FXML
    private TableColumn<UserModel, Integer> colId;

    @FXML
    private TableColumn<UserModel, String> colFirstname;

    @FXML
    private TableColumn<UserModel, String> colMiddleName;

    @FXML
    private TableColumn<UserModel, String> colLastname;

    @FXML
    private TableColumn<UserModel, String> colEmail;

    @FXML
    private TableColumn<UserModel, String> colGender;

    @FXML
    private TableColumn<UserModel, String> colPhone;

    @FXML
    private TableColumn<UserModel, String> colState;

    @FXML
    private TableColumn<UserModel, String> colDob;

    @FXML
    private TableColumn<UserModel, String> colAddress;



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
    void femaleAction(ActionEvent event) {
        radioButtonLbl = btnFemale.getText();
    }

    @FXML
    void maleAction(ActionEvent event) {
        radioButtonLbl = btnMale.getText();
    }


    @FXML
    void exitApp(MouseEvent event) {

    }


    @FXML
    void addStudent(MouseEvent event) throws SQLException {

        student.insertUser(getTxtFirstname(),getTxtMiddleName(),
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
        refresh();
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


    //delete student
    @FXML
    void deleteStudent(MouseEvent event) {
        student = table.getSelectionModel().getSelectedItem();
        try {
            student.deleteUser(dbTable,student.getId());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        refresh();


    }

//View student code

    @FXML
    void refreshView(ActionEvent event) {

        refresh();
    }

    public void refresh(){
        try {
            student.selectUser(dbTable);
        } catch (SQLException troubles) {
            System.out.println(troubles.getMessage());
        }

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colFirstname.setCellValueFactory(new PropertyValueFactory<>(
                "firstName"));
        colMiddleName.setCellValueFactory(new PropertyValueFactory<>(
                "middleName"));
        colLastname.setCellValueFactory(new PropertyValueFactory<>(
                "lastName"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colState.setCellValueFactory(new PropertyValueFactory<>("state"));
        colDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));

        table.setItems(student.getOs());

    }

    ObservableList options = FXCollections.observableArrayList();


    @FXML
    private ComboBox<UserModel> selectCombo;




    @FXML
    void comboAction(MouseEvent event) throws SQLException {
       /* student = selectCombo.getSelectionModel().getSelectedItem();
        student.selectUser(dbTable,getTxtFirstname());
        selectCombo.setItems(student.getOptions());*/
        try {
            student.selectUse(dbTable);
            selectCombo.setItems(student.getOptions());
            selectCombo.setEditable(true);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}


