package com.javarush.test.level28.lesson15.big01;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.Optional;


/**
 * Created by Admin on 24.01.2017.
 */
public class Aggregator extends Application {
    public static Parent root;

    @Override
    public void start(Stage primaryStage) throws Exception{
        root = FXMLLoader.load(getClass().getResource("gui/myGui.fxml"));
        primaryStage.setTitle("Website parser");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 740, 500));
        primaryStage.show();

        primaryStage.setOnCloseRequest( event ->
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                    "Are you sure you want to exit?",
                    ButtonType.YES,
                    ButtonType.NO);
            alert.setTitle("Exit Program");
            alert.setHeaderText(null);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.YES)
                System.exit(0);
            else
                event.consume();
        } );
    }

    public static void main(String[] args) {
        launch(args);
    }
}
