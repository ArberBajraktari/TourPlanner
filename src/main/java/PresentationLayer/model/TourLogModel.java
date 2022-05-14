package PresentationLayer.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;

public class TourLogModel {

    private StringProperty tourLog;

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
}
