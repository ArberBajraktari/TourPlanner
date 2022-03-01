package com.example.tourplanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppManager extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AppManager.class.getResource("StringConcatenation.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        //"Import" Stylesheet
        scene.getStylesheets().add(String.valueOf(getClass().getResource("StringConcatenation.css")));
        stage.setTitle("Hello World!");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}