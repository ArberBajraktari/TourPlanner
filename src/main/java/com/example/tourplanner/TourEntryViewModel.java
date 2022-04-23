package com.example.tourplanner;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.TourEntryModel;

import java.util.ArrayList;
import java.util.List;

public class TourEntryViewModel {

    public List<FocusChangedListener> focusChangedListenerList = new ArrayList<FocusChangedListener>();
    private TourEntryModel tourEntryModel;


    private final StringProperty currentTour = new SimpleStringProperty("");
    private final StringProperty currentDistance = new SimpleStringProperty("");

    public TourEntryViewModel(TourEntryModel tourEntryModel) {
        this.tourEntryModel = tourEntryModel;
    }

    public StringProperty getCurrentTour() {
        return currentTour;
    }

    public StringProperty getCurrentDistance(){
        return currentDistance;
    }

    public void saveDataToList(String text){
        this.tourEntryModel.setTourName(text);
        for (var listener: this.focusChangedListenerList) {
            listener.requestFocusChange("input of tour");
        }
        System.out.println(tourEntryModel.getTourName());
    }
}
