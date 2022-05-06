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

    public void addTours(TourModel tour) {
        this.tours.add(tour);
    }

    public void removeTour(TourModel product) {
        this.tours.remove(product);
    }

    public void removeAll() {
        this.tours.clear();
    }

    public void removeProduct(TourModel tour) {
        this.tours.remove(tour);
    }
}
