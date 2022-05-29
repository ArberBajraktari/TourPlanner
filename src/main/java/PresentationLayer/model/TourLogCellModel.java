package PresentationLayer.model;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class TourLogCellModel {

    @FXML
    private StringProperty distance = new SimpleStringProperty("hallall");
    @FXML
    private StringProperty duration = new SimpleStringProperty("hallall");

    public void deleteTour(TourLogCellModel tourModel) throws SQLException, FileNotFoundException {
        System.out.println("ok");
        //TODO fix
        //System.out.println(tourModel.getTourName());
        //manager.deleteTourItem(tourModel);
    }

    public StringProperty getDistanceProperty() {
        return distance;
    }

    public void setDistanceProperty(String distance) {
        this.distance.set(distance);
    }

    public StringProperty getDurationProperty() {
        return duration;
    }
}
