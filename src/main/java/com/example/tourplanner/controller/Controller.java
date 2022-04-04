package com.example.tourplanner.controller;

import com.example.tourplanner.FocusChangedListener;
import com.example.tourplanner.TourEntryViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private final TourEntryViewModel viewModel = new TourEntryViewModel();
    @FXML
    private ListView listView = new ListView<>();

//    public TableView tableView;
//    public TableColumn tourColumn = new TableColumn();
//    public TableColumn distanceColumn = new TableColumn();
//    public TextField tourTextField;
//    public TextField distanceTextField;


    @FXML
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        viewModel.addListener(new FocusChangedListener(){
        @Override
        public void requestFocusChange(String name){
//                tourTextField.requestFocus();
        }
    });


//        tourColumn.setCellValueFactory(new PropertyValueFactory<>("tour"));
//        distanceColumn.setCellValueFactory(new PropertyValueFactory<>("distance"));

//        tableView.setItems(viewModel.getData());

//        tourTextField.textProperty().bindBidirectional(viewModel.getCurrentTour());
//        distanceTextField.textProperty().bindBidirectional(viewModel.getCurrentDistance());
    }
    @FXML
    public void saveAction(ActionEvent actionEvent) {
        listView.getItems().add("petter");
        viewModel.saveDataToList();
        // don't put "requestFocus" logic in here!
        // you would split up the logic of your view on different places
    }
}