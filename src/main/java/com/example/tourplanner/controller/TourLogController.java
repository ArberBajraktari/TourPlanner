package com.example.tourplanner.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TourLogController {
    @FXML
    private Label logLabel = new Label();

    public Label getLogLabel() {
        return logLabel;
    }

    public void setLogLabel(Label logLabel) {
        this.logLabel = logLabel;
    }
}
