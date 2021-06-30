package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.util.Db;


import java.sql.Connection;
import java.sql.SQLException;


public class Main extends Application {

    Connection db = null;

    public void init(){
        System.out.println("Application has started...");
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        db = Db.getConnection();



        Parent root = FXMLLoader.load(getClass().getResource("view/home/login.fxml"));
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.show();
    }

    /*public void stop() throws SQLException {
        db.close();
        System.out.println("Application stopped...");
    }*/


    public static void main(String[] args) { launch(args); }



}
