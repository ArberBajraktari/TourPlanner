package PresentationLayer.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

public class TourLogModel {

    private StringProperty tourLog;
    private ObservableList<TourLogCellModel> tourLogs = FXCollections.observableArrayList();

    public TourLogModel(){
        tourLog = new SimpleStringProperty("Log view");
    }


    public String getTourLog() {
        return tourLog.get();
    }

    public StringProperty getTourLogProperty() {
        return tourLog;
    }

    public void setTourModel(TourLogCellModel tourModelList) {
        //TODO comment here
        //tourLog.set(tourModelList.getTourName());
    }

    public ObservableList<TourLogCellModel> getTours() {
        return tourLogs;
    }

    public void removeTour(TourLogCellModel product) {
        this.tourLogs.remove(product);
    }
}
