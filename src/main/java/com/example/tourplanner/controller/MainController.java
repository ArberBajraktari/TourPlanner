package com.example.tourplanner.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import model.TourListModel;
import model.TourModel;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {


    private final TourListModel tourListModel;

    @FXML
    private TourEntryController tourEntryController = new TourEntryController();
    @FXML
    private TourListController tourListController;


    public MainController(TourListModel tourListModel) {
        this.tourListModel = tourListModel;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.tourEntryController.addListener(
                p -> this.tourListModel.addTours(TourModel.From(p)));

        System.out.println(this.tourEntryController.getConsumer());
    }
}
