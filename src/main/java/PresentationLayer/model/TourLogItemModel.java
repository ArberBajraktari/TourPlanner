package PresentationLayer.model;

import PresentationLayer.controller.TourItemController;
import PresentationLayer.controller.TourLogCellController;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.util.function.Consumer;

public class TourLogItemModel extends javafx.scene.control.ListCell<TourLogCellModel>{

    private Consumer<TourLogCellModel> onDeleteProductCallBack;

    public TourLogItemModel(Consumer<TourLogCellModel> callback) {
        this.onDeleteProductCallBack = callback;
    }

    @Override
    public void updateItem(TourLogCellModel product, boolean empty)
    {
        super.updateItem(product, empty);
        if (empty || product == null) {
            setText(null);
            setGraphic(null);
            return;
        }
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TourLogItem.fxml"));
        try
        {
            fxmlLoader.load();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        var controller = (TourLogCellController)fxmlLoader.getController();
        controller.setProduct(product);
        controller.addListenerForDeleteTour(this.onDeleteProductCallBack);
        setGraphic(controller.getProductItemBox());
    }
}
