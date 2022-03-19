package com.example.tourplanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        //"Import" Stylesheet
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene scene = new Scene(root, 500, 600);
        scene.getStylesheets().add(String.valueOf(getClass().getResource("StringConcatenation.css")));
        primaryStage.setTitle("Tourplanner");
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(400);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}