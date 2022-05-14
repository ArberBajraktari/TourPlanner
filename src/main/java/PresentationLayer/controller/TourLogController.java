package PresentationLayer.controller;

import PresentationLayer.model.TourLogModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class TourLogController implements Initializable {

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.logLabel.textProperty().bindBidirectional(this.tourLogModel.getTourLogProperty());
//        this.logLabel.textProperty().bindBidirectional(this.tourLogModel.tourLogProperty());
    }
}
