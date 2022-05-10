package DatabaseAccessLayer;

import PresentationLayer.model.TourModel;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;

public interface IDatabaseLayer {
    Connection createConnection() throws FileNotFoundException, SQLException;
    void addTour(String tour);
    int getMaxId();
    void removeTour(TourModel tourModel);
}
