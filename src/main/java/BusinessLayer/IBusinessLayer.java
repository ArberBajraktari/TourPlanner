package BusinessLayer;

import PresentationLayer.model.TourEntryModel;
import PresentationLayer.model.TourModel;
import javafx.collections.ObservableList;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IBusinessLayer {

    void createTourItem(TourEntryModel tourItem) throws SQLException, IOException;
    void deleteTourItem(TourModel tourModel) throws SQLException, FileNotFoundException;
    boolean getMap(String tourName, String start, String finish) throws IOException;

    void updateTourDetails(String tourDesc, String tourFrom, String tourTo, String tourTransport, String tourDistance, String tourEstTime, String tourInfo, String tourName, int tourRating) throws SQLException, FileNotFoundException;
    ObservableList<TourModel> getAllTour() throws SQLException, FileNotFoundException;

    List<String> getAllTourNames() throws SQLException, FileNotFoundException;
}
