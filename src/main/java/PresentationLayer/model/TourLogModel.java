package PresentationLayer.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.util.Iterator;

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

    public void setTourModel(TourModel tourModelList) {
        setLogModel(tourModelList);
        tourLog.set(tourModelList.getTourName());

    }

    private void setLogModel(TourModel tourModel) {

        clearLogs();

        tourModel.getTourList();
        TourLogCellModel t = new TourLogCellModel();
        t.setDistanceProperty(tourModel.getTourName());
        tourLogs.add(t);
    }

    private void clearLogs(){

        for (Iterator<TourLogCellModel> iterator = tourLogs.iterator(); iterator.hasNext(); ) {
            String value = String.valueOf(iterator.next());
            if (value.length() > 0) {
                iterator.remove();
            }
        }

    }

    public ObservableList<TourLogCellModel> getTours() {
        return tourLogs;
    }

    public void removeTour(TourLogCellModel product) {
        this.tourLogs.remove(product);
    }

    public void saveTourModel() {

    }
}
