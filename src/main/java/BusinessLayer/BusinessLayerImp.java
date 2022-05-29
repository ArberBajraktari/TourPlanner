package BusinessLayer;

import DatabaseAccessLayer.DataAccessLayerFactory;
import DatabaseAccessLayer.IDatabaseLayer;
import PresentationLayer.model.TourEntryModel;
import PresentationLayer.model.TourModel;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.sql.SQLException;


public class BusinessLayerImp implements IBusinessLayer {

    //connection to DB layer
    private IDatabaseLayer dataLayer;

    public BusinessLayerImp(){
        dataLayer = DataAccessLayerFactory.getDatabase();
    }

    @Override
    public void createTourItem(TourEntryModel tourItem) throws SQLException, FileNotFoundException {
        System.out.println("Creating");
        dataLayer.createConnection();
        dataLayer.addTour(tourItem.getTourName());
        //TourEntryModel tourEntryModel = touritemDAO.AddnewItem(tourItem);
        //fileAccess.saveImage(MapQuestManager.requestRouteImage(tourItem.getStart(), tourItem.getEnd()), tourEntryModel.getId());
        BufferedImage test = MapQuestManager.requestRouteImage("Vienna", "Berlin");
        System.out.println(test);
    }


    @Override
    public void deleteTourItem(TourModel tourModel) throws SQLException, FileNotFoundException {
        dataLayer.createConnection();
        dataLayer.removeTour(tourModel);
    }
}
