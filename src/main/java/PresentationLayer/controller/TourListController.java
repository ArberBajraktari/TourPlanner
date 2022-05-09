package PresentationLayer.controller;

import PresentationLayer.model.TourItemModel;
import PresentationLayer.model.TourListModel;
import PresentationLayer.model.TourModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class TourListController implements Initializable{
    private TourListModel tourListModel;

    @FXML
    public ListView<TourModel> listView = new ListView<>();

    public TourListController(TourListModel tourListModel) {
        this.tourListModel = tourListModel;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.listView.setItems(this.tourListModel.getTours());
        this.listView.setCellFactory(
                ToursListView -> new TourItemModel(p -> this.deleteProduct(p)));
    }

    private void deleteProduct(TourModel model) {
        this.tourListModel.removeProduct(model);
    }

}