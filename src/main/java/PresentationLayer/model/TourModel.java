package PresentationLayer.model;

import BusinessLayer.IBusinessLayer;
import BusinessLayer.BusinessLayerFactory;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.io.File;
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
    private StringProperty tourTransport = new SimpleStringProperty();
    @FXML
    private StringProperty tourDistance = new SimpleStringProperty();
    @FXML
    private StringProperty tourEstTime = new SimpleStringProperty();
    @FXML
    private StringProperty tourInfo = new SimpleStringProperty();
    @FXML
    private IntegerProperty tourRating = new SimpleIntegerProperty();

    private ObservableList<TourLogCellModel> tourLogs = FXCollections.observableArrayList();


    public String getTourTransport() {
        return tourTransport.get();
    }

    public String getTourDistance() {
        return tourDistance.get();
    }

    public String getTourEstTime() {
        return tourEstTime.get();
    }

    public void setTourTransport(String tourTransport) {
        this.tourTransport.set(tourTransport);
    }

    public void setTourDistance(String tourDistance) {
        this.tourDistance.set(tourDistance);
    }

    public void setTourEstTime(String tourEstTime) {
        this.tourEstTime.set(tourEstTime);
    }

    public void setTourInfo(String tourInfo) {
        this.tourInfo.set(tourInfo);
    }

    public String getTourInfo() {
        return tourInfo.get();
    }

    public void deleteImg(String img){
        File myObj = new File(img);
        if (myObj.delete()) {
            System.out.println("Deleted the file: " + myObj.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }

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
        return tourDistance.get();
    }

    public StringProperty distanceProperty() {
        return tourDistance;
    }

    private void clearLogs(){
        this.tourLogs.clear();
    }

    public ObservableList<TourLogCellModel> getTours() {
        return tourLogs;
    }

    public void setTours(ObservableList<TourLogCellModel> tourLogs) {
        this.tourLogs = tourLogs;
    }
    public void setTourLogs(ObservableList<TourLogCellModel> tourLogs){
        clearLogs();
        System.out.println("pse asht bosh");
        System.out.println(tourLogs);

        Iterator<TourLogCellModel> it = tourLogs.iterator();
        while (it.hasNext()) {
            System.out.println("him itu wtf");
            TourLogCellModel value = it.next();
            this.tourLogs.add(value);
        }
    }

    public int getTourRating() {
        return this.tourRating.get();
    }

    public void setTourRating(int tourRating) {
        this.tourRating.set(tourRating);
    }

}
