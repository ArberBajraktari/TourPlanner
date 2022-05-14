package PresentationLayer.controller;

import PresentationLayer.model.TourDetailsModel;
import PresentationLayer.model.TourItemModel;
import PresentationLayer.model.TourListModel;
import PresentationLayer.model.TourModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class TourListController implements Initializable{
    private TourListModel tourListModel;
    private TourDetailsModel tourDetailsModel;

    @FXML
    public ListView<TourModel> listView = new ListView<>();

    public TourListController(TourListModel tourListModel, TourDetailsModel tourDetailsModel) {
        this.tourListModel = tourListModel;
        this.tourDetailsModel = tourDetailsModel;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.listView.setItems(this.tourListModel.getTours());
        this.listView.setCellFactory(
                ToursListView -> new TourItemModel(p -> this.deleteProduct(p)));
    }

    private void deleteProduct(TourModel model) {
        this.tourListModel.removeTour(model);
    }

    @FXML
    private void tourItemClicked(MouseEvent mouseEvent) {
        //Select the model that is clicked
        TourModel tourModelList = listView.getSelectionModel().getSelectedItem();
        tourDetailsModel.setTourModel(tourModelList);
    }
}
