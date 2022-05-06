package PresentationLayer.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TourEntryModel {

    private StringProperty tourName;

    public TourEntryModel(){
        tourName = new SimpleStringProperty("");
    }

    public void setTourName(String newValue) {
        this.tourName.set(newValue);
    }

    public String getTourName() {
        return tourName.get();
    }

    public StringProperty getTourNameProperty() {
        return tourName;
    }
}
