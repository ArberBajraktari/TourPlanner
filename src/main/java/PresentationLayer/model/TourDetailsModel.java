package PresentationLayer.model;

import javafx.beans.property.*;
import javafx.scene.image.Image;

import java.io.File;

public class TourDetailsModel {

    private StringProperty tourName;
    private StringProperty tourDesc;
    private StringProperty tourFrom;
    private StringProperty tourTo;
    private StringProperty tourTransport;
    private StringProperty tourDistance;
    private StringProperty tourEstTime;
    private StringProperty tourInfo;

    private StringProperty tourNameLabel;
    private StringProperty tourDescLabel;
    private StringProperty tourFromLabel;
    private StringProperty tourToLabel;
    private StringProperty tourTransportLabel;
    private StringProperty tourDistanceLabel;
    private StringProperty tourEstTimeLabel;
    private StringProperty tourInfoLabel;

    private StringProperty editButton;

    private BooleanProperty editMode;
    private BooleanProperty workingMode;
    private ObjectProperty<javafx.scene.image.Image> imageProperty = new SimpleObjectProperty<>();

    private TourModel tourModel;


    public String getTourTransport() {
        return tourTransport.get();
    }

    public String getTourDistance() {
        return tourDistance.get();
    }

    public String getTourEstTime() {
        return tourEstTime.get();
    }

    public String getTourInfo() {
        return tourInfo.get();
    }

    public TourDetailsModel(){
        tourName = new SimpleStringProperty("");
        tourDesc = new SimpleStringProperty("");
        tourFrom = new SimpleStringProperty("");
        tourTo = new SimpleStringProperty("");
        tourTransport = new SimpleStringProperty("");
        tourDistance = new SimpleStringProperty("");
        tourEstTime = new SimpleStringProperty("");
        tourInfo = new SimpleStringProperty("");

        tourNameLabel = new SimpleStringProperty("Dummy");
        tourDescLabel = new SimpleStringProperty("Dummy");
        tourFromLabel = new SimpleStringProperty("Dummy");
        tourToLabel = new SimpleStringProperty("Dummy");
        tourTransportLabel = new SimpleStringProperty("Dummy");
        tourDistanceLabel = new SimpleStringProperty("Dummy");
        tourEstTimeLabel = new SimpleStringProperty("Dummy");
        tourInfoLabel = new SimpleStringProperty("Dummy");

        editButton = new SimpleStringProperty("Edit");
        editMode = new SimpleBooleanProperty(false);
        workingMode = new SimpleBooleanProperty(true);
    }

    public String getTourName(){
        return  tourName.get();
    }

    public StringProperty getTourNameProperty() {
        return tourName;
    }

    public String getTourNameLabel() {
        return tourNameLabel.get();
    }

    public StringProperty getTourNameLabelProperty() {
        return tourNameLabel;
    }

    public String getTourDesc() {
        return tourDesc.get();
    }

    public StringProperty getTourDescProperty() {
        return tourDesc;
    }

    public String getTourFrom() {
        return tourFrom.get();
    }

    public StringProperty getTourFromProperty() {
        return tourFrom;
    }


    public String getTourTo() {
        return tourTo.get();
    }

    public StringProperty getTourToProperty() {
        return tourTo;
    }

    public boolean getEditMode() {
        return editMode.get();
    }

    public BooleanProperty getEditModeProperty() {
        return editMode;
    }

    public void setEditMode(boolean editMode) {
        this.editMode.set(editMode);
    }

    public boolean getWorkingMode() {
        return workingMode.get();
    }

    public BooleanProperty getWorkingModeProperty() {
        return workingMode;
    }

    public void setWorkMode(boolean workMode) {
        this.workingMode.set(workMode);
    }

    public StringProperty getEditButtonProperty() {
        return editButton;
    }

    public void setEditButton(String editButton) {
        this.editButton.set(editButton);
    }



    public void setTourDetailName(String tourName) {
        this.tourName.set(tourName);
    }

    public void setTourDetailDesc(String tourDesc) {
        this.tourDesc.set(tourDesc);
    }

    public void setTourModel(TourModel currentTourModel) {
        setTourDetailName(currentTourModel.getTourName());
        setTourDetailDesc(currentTourModel.getTourDesc());
        setTourDetailFrom(currentTourModel.getTourFrom());
        setTourDetailTo(currentTourModel.getTourTo());
        setTourDetailTransport(currentTourModel.getTourTransport());
        setTourDetailDistance(currentTourModel.getTourDistance());
        setTourDetailEstTime(currentTourModel.getTourEstTime());
        setTourDetailInfo(currentTourModel.getTourInfo());
        File file = new File("src/main/resources/TourImages/" + getTourName() + ".jpg");
        Image image = new Image(file.toURI().toString());
        setTourDetailImg(image);
        this.tourModel = currentTourModel;
    }

    private void setTourDetailInfo(String tourInfo) {
        this.tourInfo.set(tourInfo);
    }

    private void setTourDetailEstTime(String tourEstTime) {
        this.tourEstTime.set(tourEstTime);
    }

    private void setTourDetailDistance(String tourDistance) {
        this.tourDistance.set(tourDistance);
    }

    private void setTourDetailTransport(String tourTransport) {
        this.tourTransport.set(tourTransport);
    }

    public void setTourDetailTo(String tourTo) {
        this.tourTo.set(tourTo);
    }
    public void setTourDetailFrom(String tourFrom) {
        this.tourFrom.set(tourFrom);
    }

    //butoni save
    public void saveTourModel() {
        if(tourModel != null){
            this.tourModel.setTourName(getTourName());
            this.tourModel.setTourDesc(getTourDesc());
            this.tourModel.setTourFrom(getTourFrom());
            this.tourModel.setTourTo(getTourTo());
            this.tourModel.setTourDistance(getTourDistance());
            this.tourModel.setTourInfo(getTourInfo());
            this.tourModel.setTourEstTime(getTourEstTime());
            this.tourModel.setTourTransport(getTourTransport());
        }
    }

    public void resetTourModel() {
        if(tourModel != null){
            setTourDetailName(tourModel.getTourName());
            setTourDetailDesc(tourModel.getTourDesc());
            setTourDetailFrom(tourModel.getTourFrom());
            setTourDetailTo(tourModel.getTourTo());
            setTourDetailDistance(tourModel.getTourDistance());
            setTourDetailInfo(tourModel.getTourInfo());
            setTourDetailEstTime(tourModel.getTourEstTime());
            setTourDetailTransport(tourModel.getTourTransport());
        }
    }

    public Property<Image> getImageProperty() {
        return imageProperty;
    }

    public void setTourDetailImg(Image image) {
        this.imageProperty.set(image);
    }

    public StringProperty getTourTransportProperty() {
        return tourTransport;
    }

    public StringProperty getTourDistanceProperty() {
        return tourDistance;
    }

    public StringProperty getTourEstTimeProperty() {
        return tourEstTime;
    }

    public StringProperty getTourInfoProperty() {
        return tourInfo;
    }
}
