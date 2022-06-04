package PresentationLayer.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TourSearchModel {

    private StringProperty search;

    public TourSearchModel(){
        this.search = new SimpleStringProperty("");
    }

    public String getSearch() {
        return search.get();
    }

    public StringProperty getSearchProperty() {
        return search;
    }





}
