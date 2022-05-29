package PresentationLayer.controller;

import PresentationLayer.model.TourLogCellModel;
import PresentationLayer.model.TourLogItemModel;
import PresentationLayer.model.TourModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.sql.SQLException;
import java.util.function.Consumer;

public class TourLogCellController {

    private TourLogCellModel tourLogCellModel;

    private Consumer<TourLogCellModel> onDeleteProductConsumer;

    @FXML
    public Label distance;
    @FXML
    public Label duration;

    @FXML
    private Node box = new HBox();

    public Node getProductItemBox() {
        return box;
    }

    public void setProduct(TourLogCellModel tourLogCellModel) {
        this.tourLogCellModel = tourLogCellModel;
        this.distance.textProperty().bindBidirectional(this.tourLogCellModel.getDistanceProperty());
        this.duration.textProperty().bindBidirectional(this.tourLogCellModel.getDurationProperty());
        //this.name.textProperty().bindBidirectional(this.tourModel.getTourNameProperty());
    }

    public void addListenerForDeleteTour(Consumer<TourLogCellModel> listener) {
        this.onDeleteProductConsumer = listener;
    }

    public void onDeleteTour(ActionEvent actionEvent) throws SQLException, IOException {
        this.onDeleteProductConsumer.accept(this.tourLogCellModel);
        tourLogCellModel.deleteTour(this.tourLogCellModel);
    }
}
