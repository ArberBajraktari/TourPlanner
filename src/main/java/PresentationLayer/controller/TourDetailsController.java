package PresentationLayer.controller;

import PresentationLayer.model.TourDetailsModel;
import PresentationLayer.model.TourModel;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class TourDetailsController implements Initializable {

    private final TourDetailsModel tourDetailsModel;
    @FXML
    private Button editButton;
    @FXML
    private Button saveButton;
    @FXML
    private TextField tourName;
    @FXML
    private TextField tourDesc;
    @FXML
    private TextField tourFrom;
    @FXML
    private TextField tourTo;
    @FXML
    private Label tourNameLabel;
    @FXML
    private Label tourDescLabel;
    @FXML
    private Label tourFromLabel;
    @FXML
    private Label tourToLabel;

    public TourDetailsController(TourDetailsModel tourDetailsModel) {
        this.tourDetailsModel = tourDetailsModel;
    }

    public void editMode(ActionEvent actionEvent) {
        if(this.tourDetailsModel.getEditMode() == true){
            this.tourDetailsModel.setEditMode(false);
            this.tourDetailsModel.setEditButton("Edit");
            this.tourDetailsModel.setWorkMode(true);
            this.tourDetailsModel.resetTourModel();
        }else{
            this.tourDetailsModel.setEditMode(true);
            this.tourDetailsModel.setEditButton("Cancel");
            this.tourDetailsModel.setWorkMode(false);
        }

    }

    public void saveTour(ActionEvent actionEvent) {
        if(this.tourDetailsModel.getWorkingMode()){

            System.out.println("Saving tour to DB");
        }else{
            System.out.println("Pop up window");
        }
        this.tourDetailsModel.saveTourModel();

        //Revert to Working mode
        this.tourDetailsModel.setEditMode(false);
        this.tourDetailsModel.setEditButton("Edit");
        this.tourDetailsModel.setWorkMode(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.tourName.textProperty().bindBidirectional(this.tourDetailsModel.getTourNameProperty());
        this.tourDesc.textProperty().bindBidirectional(this.tourDetailsModel.getTourDescProperty());
        this.tourFrom.textProperty().bindBidirectional(this.tourDetailsModel.getTourFromProperty());
        this.tourTo.textProperty().bindBidirectional(this.tourDetailsModel.getTourToProperty());

        this.tourName.visibleProperty().bind(this.tourDetailsModel.getEditModeProperty());
        this.tourDesc.visibleProperty().bind(this.tourDetailsModel.getEditModeProperty());
        this.tourFrom.visibleProperty().bind(this.tourDetailsModel.getEditModeProperty());
        this.tourTo.visibleProperty().bind(this.tourDetailsModel.getEditModeProperty());

        this.tourNameLabel.visibleProperty().bind(this.tourDetailsModel.getWorkingModeProperty());
        this.tourDescLabel.visibleProperty().bind(this.tourDetailsModel.getWorkingModeProperty());
        this.tourFromLabel.visibleProperty().bind(this.tourDetailsModel.getWorkingModeProperty());
        this.tourToLabel.visibleProperty().bind(this.tourDetailsModel.getWorkingModeProperty());

        this.tourNameLabel.textProperty().bind(this.tourDetailsModel.getTourNameProperty());
        this.tourDescLabel.textProperty().bind(this.tourDetailsModel.getTourDescProperty());
        this.tourFromLabel.textProperty().bind(this.tourDetailsModel.getTourFromProperty());
        this.tourToLabel.textProperty().bind(this.tourDetailsModel.getTourToProperty());

        this.editButton.textProperty().bindBidirectional(this.tourDetailsModel.getEditButtonProperty());

    }


}
