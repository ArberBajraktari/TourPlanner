package com.example.tourplanner.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import com.example.tourplanner.model.TourEntryModel;

import java.net.URL;
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
    public void addTour(ActionEvent actionEvent) {
        this.newTourListener.accept(this.tourEntryModel);
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
