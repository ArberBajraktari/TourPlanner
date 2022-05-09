package BusinessLayer;

import PresentationLayer.model.TourEntryModel;
import PresentationLayer.model.TourModel;

public class AppManagerImp implements AppManager{

    //connection to DB layer

    @Override
    public void CreateTourItem(TourEntryModel tourItem){
        System.out.println("Creating");

    }

    @Override
    public void deleteTourItem(TourModel tourModel) {
        System.out.println("Deleting");
    }
}
