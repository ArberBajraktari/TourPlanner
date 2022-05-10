package PresentationLayer.model;

import javafx.beans.property.*;

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



    public TourDetailsModel(){
        tourName = new SimpleStringProperty("");
        tourNameLabel = new SimpleStringProperty("Dummy");
        tourDesc = new SimpleStringProperty("");
        tourDescLabel = new SimpleStringProperty("Dummy");
        tourFrom = new SimpleStringProperty("");
        tourFromLabel = new SimpleStringProperty("Dummy");
        tourTo = new SimpleStringProperty("");
        tourToLabel = new SimpleStringProperty("Dummy");
        editButton = new SimpleStringProperty("Editing");
        editMode = new SimpleBooleanProperty(true);
        workingMode = new SimpleBooleanProperty(false);
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
}
