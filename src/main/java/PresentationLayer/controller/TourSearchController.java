package PresentationLayer.controller;

import BusinessLayer.BusinessLayerFactory;
import BusinessLayer.IBusinessLayer;
import PresentationLayer.model.TourSearchModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.IOException;

public class TourSearchController {

    @FXML
    private Button pdfButton;


    private IBusinessLayer manager = BusinessLayerFactory.GetManager();

    private TourSearchModel tourSearchModel;
    public TourSearchController(TourSearchModel tourSearchModel) {
        this.tourSearchModel = tourSearchModel;
    }


    public void savePDF(ActionEvent actionEvent) {
        manager.savePDF();
    }
}
