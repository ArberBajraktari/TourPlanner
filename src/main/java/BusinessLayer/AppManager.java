package BusinessLayer;

import PresentationLayer.model.TourEntryModel;
import PresentationLayer.model.TourItemModel;
import PresentationLayer.model.TourModel;

import java.io.IOException;
import java.sql.SQLException;

public interface AppManager {

    void CreateTourItem(TourEntryModel tourItem) throws SQLException, IOException;
    void deleteTourItem(TourModel tourModel);
}
