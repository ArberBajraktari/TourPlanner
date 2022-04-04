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

    private TourEntryModel tourEntryModel = new TourEntryModel();
    private TourEntryViewModel mainViewModel = new TourEntryViewModel();

    @FXML
    public Label toursLabel;
    @FXML
    public TextField inputTour;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mainViewModel.addListener(new FocusChangedListener() {
            @Override
            public void requestFocusChange(String name) {
                toursLabel.requestFocus();
            }
        });
        toursLabel.textProperty().bindBidirectional(tourEntryModel.getToursLabel());
    }

    public void saveAction(ActionEvent actionEvent) {
        System.out.println("here");
        mainViewModel.saveDataToList();
    }


}
