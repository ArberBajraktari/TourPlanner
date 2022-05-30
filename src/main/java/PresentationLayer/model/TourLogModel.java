package PresentationLayer.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TourLogModel {

    private StringProperty tourLog;
    private ObservableList<TourLogCellModel> tourLogs = FXCollections.observableArrayList();
    private TourModel tourModel;


    public TourLogModel(){
        tourLog = new SimpleStringProperty("Log view");
    }


    public String getTourLog() {
        return tourLog.get();
    }

    public StringProperty getTourLogProperty() {
        return tourLog;
    }

    public void setTourModel(TourModel tourModelList) {
        //clear listview
        clearLogs();
        //save tourLogs from Listview to LogListView
        setLogModel(tourModelList);

//        TourLogCellModel t = new TourLogCellModel();
//        t.setDistanceProperty("Test");
//        tourLogs.add(t);
//        tourLog.set(tourModelList.getTourName());

    }

    //set ListView to LogListView
    private void setLogModel(TourModel tourModel) {
        tourModel.getTours().forEach(tourLog -> {
            tourLogs.add(tourLog);
        });
        this.tourModel = tourModel;
    }

    private void clearLogs(){
        tourLogs.clear();
    }

    public ObservableList<TourLogCellModel> getTours() {
        return tourLogs;
    }

    public void removeTour(TourLogCellModel product) {
        this.tourLogs.remove(product);
    }

    //save ListView to be the Same as the modified LogListView
    public void saveTourModel() {
        if(this.tourModel != null){
            this.tourModel.setTourLogs(getTours());
        }
    }
}
