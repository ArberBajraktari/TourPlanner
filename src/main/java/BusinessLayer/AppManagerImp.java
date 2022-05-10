package BusinessLayer;

import DatabaseAccessLayer.DataAccessLayerFactory;
import DatabaseAccessLayer.IDatabaseLayer;
import PresentationLayer.model.TourEntryModel;
import PresentationLayer.model.TourModel;

import java.io.FileNotFoundException;
import java.sql.SQLException;


public class AppManagerImp implements AppManager{

    //connection to DB layer
    private IDatabaseLayer dataLayer;

    public AppManagerImp(){
        dataLayer = DataAccessLayerFactory.getDatabase();
    }

    @Override
    public void CreateTourItem(TourEntryModel tourItem) throws SQLException, FileNotFoundException {
        System.out.println("Creating");
        dataLayer.createConnection();
        dataLayer.addTour(tourItem.getTourName());

    }

    @Override
    public void deleteTourItem(TourModel tourModel) {
        System.out.println("Deleting");
    }
}
