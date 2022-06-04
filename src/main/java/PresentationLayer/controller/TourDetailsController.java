package PresentationLayer.controller;

import BusinessLayer.BusinessLayerFactory;
import BusinessLayer.ConfigurationManager;
import BusinessLayer.IBusinessLayer;
import PresentationLayer.model.TourDetailsModel;
import PresentationLayer.model.TourModel;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;
import org.json.JSONException;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;

public class TourDetailsController implements Initializable {

    private final TourDetailsModel tourDetailsModel;

    @FXML
    private ImageView imageView;
    @FXML
    private Button editButton;
    @FXML
    private Button saveButton;



    @FXML
    private TextField tourName;
    @FXML
    private TextField tourDesc;
    @FXML
    private TextField tourFrom;
    @FXML
    private TextField tourTo;
    @FXML
    private TextField tourTransport;
    @FXML
    private TextField tourEstTime;
    @FXML
    private TextField tourInfo;
    @FXML
    private Label tourNameLabel;
    @FXML
    private Label tourDescLabel;
    @FXML
    private Label tourFromLabel;
    @FXML
    private Label tourToLabel;
    @FXML
    private Label tourTransportLabel;
    @FXML
    private Label tourDistanceLabel;
    @FXML
    private Label tourEstTimeLabel;
    @FXML
    private Label tourInfoLabel;
    @FXML
    private Rating tourRating;

    private IBusinessLayer manager = BusinessLayerFactory.GetManager();

    public TourDetailsController(TourDetailsModel tourDetailsModel) {
        this.tourDetailsModel = tourDetailsModel;
    }

    public void editMode(ActionEvent actionEvent) {
        if(this.tourDetailsModel.getEditMode() == true){
            this.tourDetailsModel.setEditMode(false);
            this.tourDetailsModel.setEditButton("Edit");
            this.tourDetailsModel.setWorkMode(true);
            this.tourDetailsModel.resetTourModel();
        }else{
            this.tourDetailsModel.setEditMode(true);
            this.tourDetailsModel.setEditButton("Cancel");
            this.tourDetailsModel.setWorkMode(false);
        }

    }

    public void saveTour(ActionEvent actionEvent) throws IOException, SQLException {
        if(!inputAreValid()){
            System.out.println("itu: " + inputAreValid());
            inputNotValidBox(true);
        }else{
            if(tourDetailsModel.getTourName() != null && !tourDetailsModel.getTourName().equals("") ){
                if (this.tourDetailsModel.getWorkingMode()) {

                    System.out.println("Saving tour to DB");
                } else {
                    System.out.println("Pop up window");
                }
                this.tourDetailsModel.saveTourModel();

                //Revert to Working mode

                if(this.tourDetailsModel.getTourTo() == null || this.tourDetailsModel.getTourFrom() == null) {
                    manager.updateTourDetails(this.tourDetailsModel.getTourDesc(), this.tourDetailsModel.getTourFrom(), this.tourDetailsModel.getTourTo(), this.tourDetailsModel.getTourTransport(), this.tourDetailsModel.getTourDistance(), this.tourDetailsModel.getTourEstTime(), this.tourDetailsModel.getTourInfo(), this.tourDetailsModel.getTourName(), this.tourDetailsModel.getTourRating());
                    this.tourDetailsModel.setEditMode(false);
                    this.tourDetailsModel.setEditButton("Edit");
                    this.tourDetailsModel.setWorkMode(true);
                }else{
                    if(manager.getMap(this.tourDetailsModel.getTourName(), this.tourDetailsModel.getTourFrom(), this.tourDetailsModel.getTourTo())){
                        String path = ConfigurationManager.GetConfigProperty("FileAccessStoragePath");
                        File file = new File(path + this.tourDetailsModel.getTourName() + ".jpg");
                        Image image = new Image(file.toURI().toString());
                        String distance = manager.getRouteDistance(this.tourDetailsModel.getTourFrom(), this.tourDetailsModel.getTourTo());
                        this.tourDetailsModel.setTourDistance(distance + " km");
                        this.tourDetailsModel.setTourDetailImg(image);
                        this.tourDetailsModel.setEditMode(false);
                        this.tourDetailsModel.setEditButton("Edit");
                        this.tourDetailsModel.setWorkMode(true);
                        manager.updateTourDetails(this.tourDetailsModel.getTourDesc(), this.tourDetailsModel.getTourFrom(), this.tourDetailsModel.getTourTo(), this.tourDetailsModel.getTourTransport(), this.tourDetailsModel.getTourDistance(), this.tourDetailsModel.getTourEstTime(), this.tourDetailsModel.getTourInfo(), this.tourDetailsModel.getTourName(), this.tourDetailsModel.getTourRating());
                    }else{
                        TourDetailsController.inputNotValidBox(false);
                    }
                }
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.tourName.textProperty().bindBidirectional(this.tourDetailsModel.getTourNameProperty());
        this.tourDesc.textProperty().bindBidirectional(this.tourDetailsModel.getTourDescProperty());
        this.tourFrom.textProperty().bindBidirectional(this.tourDetailsModel.getTourFromProperty());
        this.tourTo.textProperty().bindBidirectional(this.tourDetailsModel.getTourToProperty());
        this.tourTransport.textProperty().bindBidirectional(this.tourDetailsModel.getTourTransportProperty());
        this.tourEstTime.textProperty().bindBidirectional(this.tourDetailsModel.getTourEstTimeProperty());
        this.tourInfo.textProperty().bindBidirectional(this.tourDetailsModel.getTourInfoProperty());
        this.tourRating.ratingProperty().bindBidirectional(this.tourDetailsModel.getTourRatingProperty());

        this.tourName.visibleProperty().bind(this.tourDetailsModel.getEditModeProperty());
        this.tourDesc.visibleProperty().bind(this.tourDetailsModel.getEditModeProperty());
        this.tourFrom.visibleProperty().bind(this.tourDetailsModel.getEditModeProperty());
        this.tourTo.visibleProperty().bind(this.tourDetailsModel.getEditModeProperty());
        this.tourTransport.visibleProperty().bind(this.tourDetailsModel.getEditModeProperty());
        this.tourEstTime.visibleProperty().bind(this.tourDetailsModel.getEditModeProperty());
        this.tourInfo.visibleProperty().bind(this.tourDetailsModel.getEditModeProperty());


        this.tourNameLabel.textProperty().bind(this.tourDetailsModel.getTourNameProperty());
        this.tourDescLabel.textProperty().bind(this.tourDetailsModel.getTourDescProperty());
        this.tourFromLabel.textProperty().bind(this.tourDetailsModel.getTourFromProperty());
        this.tourToLabel.textProperty().bind(this.tourDetailsModel.getTourToProperty());
        this.tourTransportLabel.textProperty().bindBidirectional(this.tourDetailsModel.getTourTransportProperty());
        this.tourDistanceLabel.textProperty().bindBidirectional(this.tourDetailsModel.getTourDistanceProperty());
        this.tourEstTimeLabel.textProperty().bindBidirectional(this.tourDetailsModel.getTourEstTimeProperty());
        this.tourInfoLabel.textProperty().bindBidirectional(this.tourDetailsModel.getTourInfoProperty());

        this.tourNameLabel.visibleProperty().bind(this.tourDetailsModel.getWorkingModeProperty());
        this.tourDescLabel.visibleProperty().bind(this.tourDetailsModel.getWorkingModeProperty());
        this.tourFromLabel.visibleProperty().bind(this.tourDetailsModel.getWorkingModeProperty());
        this.tourToLabel.visibleProperty().bind(this.tourDetailsModel.getWorkingModeProperty());
        this.tourTransportLabel.visibleProperty().bind(this.tourDetailsModel.getWorkingModeProperty());
        this.tourEstTimeLabel.visibleProperty().bind(this.tourDetailsModel.getWorkingModeProperty());
        this.tourInfoLabel.visibleProperty().bind(this.tourDetailsModel.getWorkingModeProperty());



        this.editButton.textProperty().bindBidirectional(this.tourDetailsModel.getEditButtonProperty());
        this.imageView.imageProperty().bindBidirectional(this.tourDetailsModel.getImageProperty());

    }


    public void test(Event event) {

    }

    public static void inputNotValidBox(boolean type){
        Stage newWindow = new Stage();
        newWindow.setTitle("New Scene");
        Label title;
        if(type){
            title = new Label("Please make sure the inputed value are the required format!");
        }else{
            title = new Label("Please make sure the inputed locations exist!");
        }

        VBox container = new VBox(title);
        container.setSpacing(15);
        container.setPadding(new Insets(25));
        container.setAlignment(Pos.CENTER);
        newWindow.setScene(new Scene(container));
        newWindow.show();
    }

    public boolean inputAreValid(){
        String time = this.tourDetailsModel.getTourEstTime();
        try{
            if(this.tourDetailsModel.getTourEstTime() != null){
                LocalTime.parse(time);
            }
            return true;
        }
        catch (NumberFormatException | DateTimeParseException | NullPointerException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
