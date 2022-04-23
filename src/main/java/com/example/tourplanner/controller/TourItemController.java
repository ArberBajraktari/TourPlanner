package com.example.tourplanner.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import model.TourModel;

import java.util.function.Consumer;

public class TourItemController {
    private TourModel product;

    private Consumer<TourModel> onDeleteProductConsumer;

    @FXML
    public Label name;


    @FXML
    private Node box = new HBox();

    public TourItemController() { }

    public Node getProductItemBox() {
        return box;
    }

    public void setProduct(TourModel product) {
        this.product = product;
        this.name.textProperty().bindBidirectional(this.product.getTourProperty());
    }


    public void onDeleteProduct(ActionEvent actionEvent) {
        this.onDeleteProductConsumer.accept(this.product);
    }

    public void addListenerForDeleteProduct(Consumer<TourModel> listener) {
        this.onDeleteProductConsumer = listener;
    }
}
