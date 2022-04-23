package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TourModel {
    private StringProperty tourName = new SimpleStringProperty();

    public static TourModel From(TourEntryModel source) {
        var newInstance = new TourModel();
        newInstance.tourName.set(source.getTourName());
        return newInstance;
    }

    public String getTourName() {
        return tourName.get();
    }

    public StringProperty getTourProperty() {
        return tourName;
    }
}
