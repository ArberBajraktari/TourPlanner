package PresentationLayer;

import PresentationLayer.controller.ControllerFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        //"Import" Stylesheet
        ControllerFactory factory = new ControllerFactory();
        FXMLLoader fxmlLoader = getFxmlLoader(factory);
        Scene scene = new Scene(fxmlLoader.load(), 500, 600);
        scene.getStylesheets().add(String.valueOf(getClass().getResource("StringConcatenation.css")));
        primaryStage.setTitle("Tourplanner");
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(400);
        primaryStage.show();

    }

    private FXMLLoader getFxmlLoader(ControllerFactory factory) {
        FXMLLoader fxmlLoader =
                new FXMLLoader(
                        Main.class.getResource("main.fxml"),
                        null,
                        new JavaFXBuilderFactory(),
                        controller -> {
                            try {
                                return factory.create(controller);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            System.out.println("returning null");
                            return null;
                        });
        return fxmlLoader;

    }


    public static void main(String[] args) {
        launch(args);
    }
}