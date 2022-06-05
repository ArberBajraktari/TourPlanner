package PresentationLayer.model;

import BusinessLayer.IBusinessLayer;
import BusinessLayer.BusinessLayerFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.IOException;
import java.sql.SQLException;

public class TourEntryModel {

    private IBusinessLayer manager = BusinessLayerFactory.GetManager();
    private StringProperty tourName;

    public TourEntryModel(){
        tourName = new SimpleStringProperty("");
    }

    public String getTourName() {
        return tourName.get();
    }

    public StringProperty getTourNameProperty() {
        return tourName;
    }

    //When add is clicked, the new Tour will be added to the DB
    public boolean createTour(TourEntryModel tourEntryModel) throws SQLException, IOException {
        manager.createTourItem(tourEntryModel);
        return true;
    }
}
