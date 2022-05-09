package PresentationLayer.controller;

import PresentationLayer.model.*;

public class ControllerFactory {
    private final TourEntryModel tourEntryModel;
    private final TourLogModel tourLogModel;
    private final TourListModel tourListModel;
    private final TourDetailsModel tourDetailsModel;
    private final TourFormModel tourFormModel;


    public ControllerFactory(){
        this.tourEntryModel = new TourEntryModel();
        this.tourLogModel = new TourLogModel();
        this.tourListModel = new TourListModel();
        this.tourDetailsModel = new TourDetailsModel();
        this.tourFormModel = new TourFormModel();
    }

    public Object create(Class controllerClass) throws Exception {
        if (controllerClass == TourEntryController.class) {
            return new TourEntryController(this.tourEntryModel);
        }else if(controllerClass == TourListController.class){
            return new TourListController(this.tourListModel);
        }else if(controllerClass == TourLogController.class){
            return new TourLogController(this.tourLogModel);
        }else if(controllerClass == TourDetailsController.class){
            return new TourDetailsController(this.tourDetailsModel);
        }else if(controllerClass == MainController.class){
            return new MainController(this.tourListModel);
        }else {
            throw new Exception("Controller not supported " + controllerClass.getName());
        }
    }


}
