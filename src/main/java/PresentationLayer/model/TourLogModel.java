package PresentationLayer.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

public class TourLogModel {

    private StringProperty tourLog;
    private ObservableList<TourModel> tourLogs = FXCollections.observableArrayList();

    public TourLogModel(){
        tourLog = new SimpleStringProperty("Log view");
    }


    public String getTourLog() {
        return tourLog.get();
    }

    public StringProperty getTourLogProperty() {
        return tourLog;
    }

    public void setTourModel(TourModel tourModelList) {
        tourLog.set(tourModelList.getTourName());
    }

    public ObservableList<TourModel> getTours() {
        return tourLogs;
    }

    public void removeTour(TourModel product) {
        this.tourLogs.remove(product);
    }
}
