package PresentationLayer.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TourFormModel {

    private StringProperty tourName = new SimpleStringProperty("Hello");;

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
