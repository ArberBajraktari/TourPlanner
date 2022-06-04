package PresentationLayer.controller;

import BusinessLayer.BusinessLayerFactory;
import BusinessLayer.ConfigurationManager;
import BusinessLayer.IBusinessLayer;
import PresentationLayer.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.ResourceBundle;

public class TourListController implements Initializable{
    private TourListModel tourListModel;
    private TourDetailsModel tourDetailsModel;
    private TourLogModel tourLogModel;

    @FXML
    public ListView<TourModel> listView = new ListView<>();
    private IBusinessLayer manager = BusinessLayerFactory.GetManager();

    public TourListController(TourListModel tourListModel, TourDetailsModel tourDetailsModel, TourLogModel tourLogModel) {
        this.tourListModel = tourListModel;
        this.tourDetailsModel = tourDetailsModel;
        this.tourLogModel = tourLogModel;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            this.tourListModel.setTours(manager.getAllTour());
            Iterator<TourModel> allTours = this.tourListModel.getTours().iterator();
            while(allTours.hasNext()){
                TourModel temp = allTours.next();
                temp.setTourLogs(manager.getAllTourLogs(temp.getTourName()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.listView.setItems(this.tourListModel.getTours());
        this.listView.setCellFactory(
                ToursListView -> new TourItemModel(p -> this.deleteProduct(p)));
    }

    private void deleteProduct(TourModel model) {
        String path;
        try {
            path = ConfigurationManager.GetConfigProperty("FileAccessStoragePath");
            File file = new File(path + this.tourDetailsModel.getTourName() + ".jpg");
            file.delete();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        this.tourListModel.removeTour(model);
    }

    @FXML
    private void tourItemClicked(MouseEvent mouseEvent) {
        //Select the model that is clicked
        TourModel tourModelList = listView.getSelectionModel().getSelectedItem();
        TourModel temp = new TourModel();
        tourDetailsModel.setTourModel(temp);
        tourLogModel.setTourModel(temp);
        if(tourModelList != null){
            tourDetailsModel.setTourModel(tourModelList);
            tourLogModel.setTourModel(tourModelList);
        }
    }

    public void importData(ActionEvent actionEvent) {
    }

    public void exportData(ActionEvent actionEvent) {
        this.tourListModel.exportData();
    }
}
