package com.example.tourplanner.controller;

import com.example.tourplanner.FocusChangedListener;
import com.example.tourplanner.TourEntryViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.TourEntryModel;

import java.net.URL;
import java.util.ResourceBundle;

public class TourEntryController implements Initializable {

    private TourEntryModel tourEntryModel;
    private TourEntryViewModel tourEntryViewModel;

    @FXML
    public Label toursLabel;
    @FXML
    public TextField inputTour;

    public TourEntryController(TourEntryModel tourEntryModel) {
        this.tourEntryModel = tourEntryModel;
        this.tourEntryViewModel = new TourEntryViewModel(tourEntryModel);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tourEntryViewModel.addListener(new FocusChangedListener() {
            @Override
            public void requestFocusChange(String name) {
                toursLabel.requestFocus();
            }
        });
        toursLabel.textProperty().bindBidirectional(tourEntryModel.getToursLabel());
    }

    public void saveAction(ActionEvent actionEvent) {
        tourEntryViewModel.saveDataToList(inputTour.getText());
    }


}
