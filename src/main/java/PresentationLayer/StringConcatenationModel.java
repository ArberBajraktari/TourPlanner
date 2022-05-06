package PresentationLayer;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StringConcatenationModel {
    private StringProperty leftValue = new SimpleStringProperty();
    private StringProperty rightValue = new SimpleStringProperty();
    private StringProperty result = new SimpleStringProperty();

    public void concat(){
        System.out.println(this.getLeftValue() + this.getRightValue());
        this.result.setValue(this.getLeftValue() + this.getRightValue());
    }

    public String getLeftValue() {
        return leftValue.get();
    }

    public StringProperty leftValueProperty() {
        return leftValue;
    }

    public String getRightValue() {
        return rightValue.get();
    }

    public StringProperty rightValueProperty() {
        return rightValue;
    }

    public String getResult() {
        return result.get();
    }

    public StringProperty resultProperty() {
        return result;
    }


}
