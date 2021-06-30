package sample.controller;


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.model.ValidationModel;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    ValidationModel verify = new ValidationModel();
    String table = "admins";

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Label lblError;


    public String getTxtUsername() {
        return txtUsername.getText();
    }

    public String getTxtPassword() {
        return txtPassword.getText();
    }

    public String getTable() {
        return table;
    }

    public Stage createStage(String title, Parent parent){
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        stage.setTitle(title);
        stage.initStyle(StageStyle.UTILITY);
        stage.initModality(Modality.APPLICATION_MODAL);
        return stage;

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    @FXML
    public void exitApp(MouseEvent mouseEvent) {
        Platform.exit();
    }


    @FXML
    void loginAction(MouseEvent event) {
        if (getTxtUsername().isEmpty()){
            lblError.setText("Invalid username or password! :(");
            txtPassword.setText("");
            txtUsername.setText("");
            return;
        }
        if (getTxtPassword().isEmpty()){
            lblError.setText("Invalid username or password! :(");
            txtPassword.setText("");
            txtUsername.setText("");
            return;
        }

        try {
            if (login().equals("Success")){
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.close();
                Parent homeRoot = FXMLLoader.load(getClass().getResource("/sample/view/home/home.fxml"));
                createStage("Home Page", homeRoot).showAndWait();
                txtPassword.setText("");
                txtUsername.setText("");
            }else {
                lblError.setText("Invalid username or password! :(");
                txtPassword.setText("");
                txtUsername.setText("");
            }
        } catch (SQLException | IOException e) {
            e.getCause();
        }

    }


    public String login() throws SQLException {

        ResultSet rs = verify.validateAdmin(getTable(), getTxtUsername(),
                getTxtPassword());
        if (!rs.next()){
            lblError.setText("Invalid username or password! :(");
            return "Error";
        }else {
            lblError.setText("Login successful!");
            lblError.setTextFill(Color.GREEN);
            return "Success";

        }

    }


}