package com.example.tourplanner.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import model.TourListModel;

public class TourListController {


    private final TourListModel tourListModel;
    @FXML
    private ListView listView = new ListView();

    public TourListController(TourListModel tourListModel) {
        this.tourListModel = tourListModel;
    }


    public ListView getListView() {
        return listView;
    }

    public void setListView(ListView listView) {
        this.listView = listView;
    }


}
