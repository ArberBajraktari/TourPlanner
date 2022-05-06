package PresentationLayer;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


public class StringConcatenationController {

    private StringConcatenationModel model = new StringConcatenationModel();


    @FXML
    public void initialize() {
        this.leftStringTextField.textProperty().bindBidirectional(model.leftValueProperty());
        this.rightStringTextField.textProperty().bindBidirectional(model.rightValueProperty());
        this.stringConcatenationResultLabel.textProperty().bind(model.resultProperty());

    }

    @FXML
    public TextField leftStringTextField;
    @FXML
    public Label stringConcatenationResultLabel;
    @FXML
    public TextField rightStringTextField;


    @FXML
    public void concatenateStrings(MouseEvent mouseEvent) {
        this.model.concat();
    }
}