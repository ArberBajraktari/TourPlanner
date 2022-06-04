package PresentationLayer.controller;

import BusinessLayer.BusinessLayerFactory;
import BusinessLayer.IBusinessLayer;
import PresentationLayer.model.TourSearchModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class TourSearchController implements Initializable {

    @FXML
    private TextField searchInput;
    @FXML
    private Button pdfButton;
    private IBusinessLayer manager = BusinessLayerFactory.GetManager();
    private TourSearchModel tourSearchModel;


    public TourSearchController(TourSearchModel tourSearchModel) {
        this.tourSearchModel = tourSearchModel;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.searchInput.textProperty().bindBidirectional(this.tourSearchModel.getSearchProperty());
    }

    public void savePDF(ActionEvent actionEvent) {
        manager.savePDF();
    }

    public void searchTours(ActionEvent actionEvent) {
        String input = this.tourSearchModel.getSearch();
    }
}
