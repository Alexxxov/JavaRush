package com.javarush.test.level28.lesson15.big01;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * Created by Admin on 24.01.2017.
 */
public class Aggregator extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("gui/myGui.fxml"));
        primaryStage.setTitle("Website parser");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 740, 500));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
