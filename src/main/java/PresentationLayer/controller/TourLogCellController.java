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

    private TourLogCellModel tourModel;

    private Consumer<TourLogCellModel> onDeleteProductConsumer;

    @FXML
    public Label name;

    @FXML
    private Node box = new HBox();

    public Node getProductItemBox() {
        return box;
    }

    public void setProduct(TourLogCellModel TourModel) {
        this.tourModel = TourModel;
        this.name.textProperty().bindBidirectional(this.tourModel.getTourNameProperty());
        //this.name.textProperty().bindBidirectional(this.tourModel.getTourNameProperty());
    }

    public void addListenerForDeleteTour(Consumer<TourLogCellModel> listener) {
        this.onDeleteProductConsumer = listener;
    }

    public void onDeleteTour(ActionEvent actionEvent) throws SQLException, IOException {
        this.onDeleteProductConsumer.accept(this.tourModel);
        tourModel.deleteTour(this.tourModel);
    }
}
