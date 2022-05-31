package PresentationLayer.controller;

import PresentationLayer.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class TourLogController implements Initializable {

    private final TourLogModel tourLogModel;
    @FXML
    private Label logLabel = new Label();
    @FXML
    public ListView<TourLogCellModel> listView = new ListView<>();

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
        listView.getItems().add(t);
        System.out.println("button add clicked");
    }

    public void saveLog(ActionEvent actionEvent) {
//        if(this.tourDetailsModel.getWorkingMode()){
//
//            System.out.println("Saving tour to DB");
//        }else{
//            System.out.println("Pop up window");
//        }
        this.tourLogModel.saveTourModel();

        //Revert to Working mode
//        this.tourDetailsModel.setEditMode(false);
//        this.tourDetailsModel.setEditButton("Edit");
//        this.tourDetailsModel.setWorkMode(true);

    }
}
