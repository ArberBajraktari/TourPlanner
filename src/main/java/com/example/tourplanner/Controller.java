package com.example.tourplanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private final MainViewModel viewModel = new MainViewModel();

    public TableView tableView;
    public TableColumn tourColumn;
    public TableColumn distanceColumn;
    public TextField tourTextField;
    public TextField distanceTextField;
    @FXML
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        viewModel.addListener(new FocusChangedListener(){
        @Override
                public void requestFocusChange(String name){
                tourTextField.requestFocus();
        }
    });

        tourColumn.setCellValueFactory(new PropertyValueFactory<>("tour"));
        distanceColumn.setCellValueFactory(new PropertyValueFactory<>("distance"));

        tableView.setItems(viewModel.getData());

        tourTextField.textProperty().bindBidirectional(viewModel.getCurrentTour());
        distanceTextField.textProperty().bindBidirectional(viewModel.getCurrentDistance());
    }
    @FXML
    public void saveAction(ActionEvent actionEvent) {
        viewModel.saveDataToList();
        // don't put "requestFocus" logic in here!
        // you would split up the logic of your view on different places
    }
}