package PresentationLayer.model;

import javafx.beans.property.*;
import javafx.scene.image.Image;

public class TourDetailsModel {

    private StringProperty tourName;
    private StringProperty tourNameLabel;
    private StringProperty tourDesc;
    private StringProperty tourDescLabel;
    private StringProperty tourFrom;
    private StringProperty tourFromLabel;
    private StringProperty tourTo;
    private StringProperty tourToLabel;
    private StringProperty editButton;

    private BooleanProperty editMode;
    private BooleanProperty workingMode;
    private ObjectProperty<javafx.scene.image.Image> imageProperty = new SimpleObjectProperty<>();

    private TourModel tourModel;



    public TourDetailsModel(){
        tourName = new SimpleStringProperty("");
        tourNameLabel = new SimpleStringProperty("Dummy");
        tourDesc = new SimpleStringProperty("");
        tourDescLabel = new SimpleStringProperty("Dummy");
        tourFrom = new SimpleStringProperty("");
        tourFromLabel = new SimpleStringProperty("Dummy");
        tourTo = new SimpleStringProperty("");
        tourToLabel = new SimpleStringProperty("Dummy");
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
        this.tourModel = currentTourModel;
    }

    public void setTourDetailTo(String tourTo) {
        this.tourTo.set(tourTo);
    }
    public void setTourDetailFrom(String tourFrom) {
        this.tourFrom.set(tourFrom);
    }

    //butoni save
    public void saveTourModel() {
        this.tourModel.setTourName(getTourName());
        this.tourModel.setTourDesc(getTourDesc());
        this.tourModel.setTourFrom(getTourFrom());
        this.tourModel.setTourTo(getTourTo());
    }

    public void resetTourModel() {
        setTourDetailName(tourModel.getTourName());
        setTourDetailDesc(tourModel.getTourDesc());
        setTourDetailFrom(tourModel.getTourFrom());
        setTourDetailTo(tourModel.getTourTo());
    }

    public Property<Image> getImageProperty() {
        return imageProperty;
    }

    public void setTourDetailImg(Image image) {
        this.imageProperty.set(image);
    }
}
