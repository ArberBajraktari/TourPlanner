package PresentationLayer.controller;

import BusinessLayer.BusinessLayerFactory;
import BusinessLayer.IBusinessLayer;
import PresentationLayer.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.ResourceBundle;

public class TourLogController implements Initializable {

    private final TourLogModel tourLogModel;
    @FXML
    private Label logLabel = new Label();
    @FXML
    public ListView<TourLogCellModel> listView = new ListView<>();
    private IBusinessLayer manager = BusinessLayerFactory.GetManager();



    public TourLogController(TourLogModel tourLogModel) {
        this.tourLogModel = tourLogModel;
    }

    public Label getLogLabel() {
        return logLabel;
    }

    public void setLogLabel(Label logLabel) {
        this.logLabel = logLabel;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.logLabel.textProperty().bindBidirectional(this.tourLogModel.getTourLogProperty());

        this.listView.setItems(this.tourLogModel.getTours());
        this.listView.setCellFactory(
                ToursListView -> new TourLogItemModel(p -> this.deleteProduct(p)));
    }

    private void deleteProduct(TourLogCellModel model) {
        this.tourLogModel.removeTour(model);
    }


    public void tourLogClicked(MouseEvent mouseEvent) {

    }

    public void addLog(ActionEvent actionEvent) {
        TourLogCellModel t = new TourLogCellModel();
        LocalDateTime now = LocalDateTime.now();
        t.setDate(String.valueOf(now));
        listView.getItems().add(t);
        System.out.println("button add clicked");
    }

    public void saveLog(ActionEvent actionEvent){
        Iterator<TourLogCellModel> item = this.tourLogModel.getTourLogs().iterator();
        while (item.hasNext()) {
            manager.saveTourLogs(item.next(), this.tourLogModel.getTourModelName());
        }
        this.tourLogModel.saveTourModel();

    }
}
