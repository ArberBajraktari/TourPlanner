package com.example.tourplanner.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import com.example.tourplanner.model.TourLogModel;

public class TourLogController {

    private final TourLogModel tourLogModel;
    @FXML
    private Label logLabel = new Label();

    public TourLogController(TourLogModel tourLogModel) {
        this.tourLogModel = tourLogModel;
    }

    public Label getLogLabel() {
        return logLabel;
    }

    public void setLogLabel(Label logLabel) {
        this.logLabel = logLabel;
    }
}
