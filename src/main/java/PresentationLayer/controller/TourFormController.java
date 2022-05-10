package PresentationLayer.controller;

import PresentationLayer.model.TourEntryModel;
import PresentationLayer.model.TourFormModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class TourFormController implements Initializable{

    @FXML
    public Label tourName;
    private TourFormModel tourFormModel;
    private TourEntryModel tourEntryModel;
    @FXML
    private Label name;


    public TourFormController(){

    }

    public TourFormController(TourFormModel tourFormModel) {
        this.tourFormModel = tourFormModel;
    }

    public TourFormController(TourFormModel tourFormModel, TourEntryModel tourEntryModel) {
        this.tourFormModel = tourFormModel;
        this.tourEntryModel = tourEntryModel;
        this.tourFormModel.setTourName(this.tourEntryModel.getTourName());
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.name.textProperty().bindBidirectional(this.tourFormModel.getTourNameProperty());
    }
}
