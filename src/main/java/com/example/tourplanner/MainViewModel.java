package com.example.tourplanner;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.TourEntry;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel {

    private List<FocusChangedListener> focusChangedListenerList = new ArrayList<FocusChangedListener>();

    private final StringProperty currentTour = new SimpleStringProperty("");
    private final StringProperty currentDistance = new SimpleStringProperty("");
    private final ObservableList<TourEntry> data =
            FXCollections.observableArrayList(
                    new TourEntry("tour1", "120"),
                    new TourEntry("tour2", "60")
            );

    public StringProperty getCurrentTour() {
        return currentTour;
    }

    public StringProperty getCurrentDistance(){
        return currentDistance;
    }

    public ObservableList getData(){
        return data;
    }

    public void addListener(FocusChangedListener listener) {
        this.focusChangedListenerList.add(listener);
    }
    public void saveDataToList(){
        data.add(new TourEntry(currentTour.get(), currentDistance.get()));
        currentTour.set("");
        currentDistance.set("");
        for (var listener: this.focusChangedListenerList) {
            listener.requestFocusChange("input of tour");
        }
}

}
