package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TourEntry {
    private final StringProperty tour;
    private final StringProperty distance;

    public TourEntry(String tour, String distance){
        this.tour = new SimpleStringProperty(tour);
        this.distance = new SimpleStringProperty(distance);
    }

    public TourEntry(StringProperty tour, StringProperty distance) {
        this.tour = tour;
        this.distance = distance;
    }

    public String getDistance() {
        return distance.get();
    }

    public void setDistance(String distance){
        this.distance.set(distance);
    }

    public StringProperty distanceProperty() {
        return distance;
    }

    public String getTour() {
        return tour.get();
    }

    public void setTour(String tour){
        this.tour.set(tour);
    }

    public StringProperty tourProperty() {
        return tour;
    }
}
