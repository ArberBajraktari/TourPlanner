package PresentationLayer.model;

import BusinessLayer.IBusinessLayer;
import BusinessLayer.BusinessLayerFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Iterator;

public class TourModel {
    @FXML
    private StringProperty tourName = new SimpleStringProperty();
    @FXML
    private StringProperty tourDesc = new SimpleStringProperty();
    @FXML
    private StringProperty tourFrom = new SimpleStringProperty();
    @FXML
    private StringProperty tourTo = new SimpleStringProperty();

    @FXML
    private StringProperty distance = new SimpleStringProperty();

    private ObservableList<TourLogCellModel> tourLogs = FXCollections.observableArrayList();


    private IBusinessLayer manager = BusinessLayerFactory.GetManager();

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
    public void deleteTour(TourModel tourModel) throws SQLException, FileNotFoundException {
        System.out.println(tourModel.getTourName());
        manager.deleteTourItem(tourModel);
    }

    public String getTourDesc() {
        return tourDesc.get();
    }

    public void setTourDesc(String tourDesc) {
        this.tourDesc.set(tourDesc);
    }

    public String getTourFrom() {
        return tourFrom.get();
    }

    public String getTourTo() {
        return tourTo.get();
    }

    public void setTourFrom(String tourFrom) {
        this.tourFrom.set(tourFrom);
    }

    public void setTourTo(String tourTo) {
        this.tourTo.set(tourTo);
    }

    public String getDistance() {
        return distance.get();
    }

    public StringProperty distanceProperty() {
        return distance;
    }


    public ObservableList<TourLogCellModel> getTours() {
        return tourLogs;
    }
    public void setTourLogs(ObservableList<TourLogCellModel> tourLogs){
        Iterator<TourLogCellModel> it = tourLogs.iterator();
        while (it.hasNext()) {
            TourLogCellModel value = it.next();
            this.tourLogs.add(value);
        }
    }
}
