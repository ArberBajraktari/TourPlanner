package PresentationLayer.controller;

import PresentationLayer.model.TourListModel;
import PresentationLayer.model.TourModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {


    private final TourListModel tourListModel;


    @FXML
    private TourEntryController tourEntryController;
    @FXML
    private TourListController tourListController;


    public MainController(TourListModel tourListModel) {
        this.tourListModel = tourListModel;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.tourEntryController.addListener(
                p -> this.tourListModel.addTours(TourModel.From(p)));

    }
}
