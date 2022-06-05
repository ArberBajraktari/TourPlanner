package PresentationLayer.model;

import PresentationLayer.controller.TourItemController;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.util.function.Consumer;

public class TourItemModel extends javafx.scene.control.ListCell<TourModel>{

    private Consumer<TourModel> onDeleteProductCallBack;

    public TourItemModel(Consumer<TourModel> callback) {
        this.onDeleteProductCallBack = callback;
    }

    //Load TourItem.fxml to the ListView
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
