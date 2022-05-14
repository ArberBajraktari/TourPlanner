package BusinessLayer;

import PresentationLayer.model.TourEntryModel;
import PresentationLayer.model.TourModel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public interface IBusinessLayer {

    void createTourItem(TourEntryModel tourItem) throws SQLException, IOException;
    void deleteTourItem(TourModel tourModel) throws SQLException, FileNotFoundException;
}