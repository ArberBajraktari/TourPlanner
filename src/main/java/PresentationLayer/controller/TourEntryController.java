package PresentationLayer.controller;

import PresentationLayer.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import PresentationLayer.model.TourEntryModel;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.function.Consumer;

public class TourEntryController implements Initializable {
    private TourEntryModel tourEntryModel;

    private Consumer<TourEntryModel> newTourListener;

    @FXML
    public Label toursLabel;
    @FXML
    public TextField inputTour;

    public TourEntryController(TourEntryModel tourEntryModel) {
        this.tourEntryModel = tourEntryModel;
    }

    public TourEntryController() {

    }


    //butoni
    public void addTour(ActionEvent actionEvent) throws SQLException, IOException {
//        FXMLLoader l = Main.getFXMLTour();
//        Scene scene = new Scene(l.load(), 600, 400);
//        Stage stage = new Stage();
//        stage.setTitle("New Window");
//        stage.setScene(scene);
//        stage.show();
        this.newTourListener.accept(this.tourEntryModel);
        tourEntryModel.createTour(this.tourEntryModel);
    }

    public void addListener(Consumer<TourEntryModel> listenToNewTour) {
        this.newTourListener = listenToNewTour;
    }

    public String getConsumer(){
       return newTourListener.toString();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.inputTour.textProperty().bindBidirectional(this.tourEntryModel.getTourNameProperty());
    }

}
