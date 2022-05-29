package PresentationLayer.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class TourLogCellModel {

    @FXML
    private StringProperty tourName = new SimpleStringProperty("hallall");

    public void deleteTour(TourLogCellModel tourModel) throws SQLException, FileNotFoundException {

        System.out.println("ok");
        //TODO fix
        //System.out.println(tourModel.getTourName());
        //manager.deleteTourItem(tourModel);
    }

    public StringProperty getTourNameProperty() {
        return tourName;
    }
}
