package com.example.tourplanner.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class TourListController {

    @FXML
    private ListView listView = new ListView();


    public ListView getListView() {
        return listView;
    }

    public void setListView(ListView listView) {
        this.listView = listView;
    }


}
