package PresentationLayer.controller;

import PresentationLayer.model.TourEntryModel;
import PresentationLayer.model.TourItemModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import PresentationLayer.model.TourModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.function.Consumer;

public class TourItemController {
    private TourModel tourModel;
    private Consumer<TourModel> onDeleteProductConsumer;

    @FXML
    public Label name;

    @FXML
    private Node box = new HBox();

    public Node getProductItemBox() {
        return box;
    }

    public void setProduct(TourModel TourModel) {
        this.tourModel = TourModel;
        this.name.textProperty().bindBidirectional(this.tourModel.getTourNameProperty());
    }

    public void addListenerForDeleteTour(Consumer<TourModel> listener) {
        this.onDeleteProductConsumer = listener;
    }

    public void onDeleteTour(ActionEvent actionEvent) throws SQLException, IOException {
        this.onDeleteProductConsumer.accept(this.tourModel);
        tourModel.deleteTour(this.tourModel);
    }
}
