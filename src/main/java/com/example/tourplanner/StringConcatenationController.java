package com.example.tourplanner;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class StringConcatenationController {

    @FXML
    public TextField LeftStringTextField;
    @FXML
    public Label StringConcatenationResultLabel;
    @FXML
    public TextField RightStringTextField;

    @FXML
    public void concatenateStrings(MouseEvent mouseEvent) {
        String LeftString = LeftStringTextField.getText();
        String RightString = RightStringTextField.getText();
        String ResultString = LeftString + " " + RightString;
        StringConcatenationResultLabel.setText(ResultString);
        System.out.println(ResultString);

    }
}