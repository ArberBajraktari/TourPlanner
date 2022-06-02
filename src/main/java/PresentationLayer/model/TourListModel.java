package PresentationLayer.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TourListModel {

    public TourListModel(){
    }

    private ObservableList<TourModel> tours = FXCollections.observableArrayList();

    public ObservableList<TourModel> getTours() {
        return tours;
    }

    public void setTours(ObservableList<TourModel> tours) {
        this.tours = tours;
    }

    public void addTours(TourModel tour) {
        this.tours.add(tour);
    }

    public void removeTour(TourModel product) {
        this.tours.remove(product);
    }

    public void removeAll() {
        this.tours.clear();
    }

}
