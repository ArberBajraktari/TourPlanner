package com.example.tourplanner;

import com.example.tourplanner.controller.TourItemController;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import model.TourModel;

import java.io.IOException;
import java.util.function.Consumer;

public class TourListItemCell extends javafx.scene.control.ListCell<TourModel>{

    private Consumer<TourModel> onDeleteProductCallBack;

    public TourListItemCell(Consumer<TourModel> callback) {
        this.onDeleteProductCallBack = callback;
    }

    @Override
    public void updateItem(TourModel product, boolean empty)
    {
        super.updateItem(product, empty);
        if (empty || product == null) {
            setText(null);
            setGraphic(null);
            return;
        }
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TourItem.fxml"));
        try
        {
            fxmlLoader.load();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        var controller = (TourItemController)fxmlLoader.getController();
        controller.setProduct(product);
        controller.addListenerForDeleteTour(this.onDeleteProductCallBack);
        setGraphic(controller.getProductItemBox());
    }
}
