package PresentationLayer.model;

import BusinessLayer.AppManager;
import BusinessLayer.AppManagerFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TourModel {
    private StringProperty tourName = new SimpleStringProperty();
    private AppManager manager = AppManagerFactory.GetManager();

    public static TourModel From(TourEntryModel source) {
        var newInstance = new TourModel();
        newInstance.tourName.set(source.getTourName());
        return newInstance;
    }

    //Getter and Setter
    public String getTourName() {
        return tourName.get();
    }
    public void setTourName(String name){
        this.tourName.set(name);
    }

    //Getter and Setter for Property
    public StringProperty getTourNameProperty() {
        return tourName;
    }

    //Delete Tour
    public void deleteTour(TourModel tourModel) {
        System.out.println(tourModel.getTourName());
        manager.deleteTourItem(tourModel);
    }
}
