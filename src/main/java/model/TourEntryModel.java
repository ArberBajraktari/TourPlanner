package model;

import com.example.tourplanner.FocusChangedListener;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.List;

public class TourEntryModel {

    public StringProperty toursLabel;

    public TourEntryModel(){
        toursLabel = new SimpleStringProperty("Tours: ");
    }

    public StringProperty getToursLabel(){
        return toursLabel;
    }

    public void setToursLabel(String newValue) {
        System.out.println(newValue);
        this.toursLabel.set(newValue);
    }

//    private StringProperty tourName;
//    private StringProperty distance;
//
//    public TourEntryModel(String tour, String distance){
//        this.tourName = new SimpleStringProperty(tour);
//        this.distance = new SimpleStringProperty(distance);
//    }
//
//    public TourEntryModel(String tour){
//        this.tourName = new SimpleStringProperty(tour);
//    }
//
//    public TourEntryModel(StringProperty tour, StringProperty distance) {
//        this.tourName = tour;
//        this.distance = distance;
//    }
//
//    public String getDistance() {
//        return distance.get();
//    }
//
//    public void setDistance(String distance){
//        this.distance.set(distance);
//    }
//
//    public StringProperty distanceProperty() {
//        return distance;
//    }
//
//    public String getTour() {
//        return tourName.get();
//    }
//
//    public void setTour(String tour){
//        this.tourName.set(tour);
//    }
//
//    public StringProperty tourProperty() {
//        return tourName;
//    }
}
