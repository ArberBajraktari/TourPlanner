package PresentationLayer.controller;

import PresentationLayer.model.TourEntryModel;
import PresentationLayer.model.TourFormModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class TourFormController implements Initializable{

    private TourFormModel tourFormModel = new TourFormModel();
    @FXML
    private Label name;

    public TourFormController(){

    }

    public TourFormController(String tourName) {
        tourFormModel.setTourName(tourName);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.name.textProperty().bindBidirectional(this.tourFormModel.getTourNameProperty());
    }
}
