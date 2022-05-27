module com.example.tourplanner {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.sql;
    requires org.apache.logging.log4j;
    requires java.desktop;
    requires org.json;

    opens PresentationLayer to javafx.fxml;
    exports PresentationLayer;
    exports PresentationLayer.controller;
    opens PresentationLayer.controller to javafx.fxml;
    exports PresentationLayer.model;
    opens PresentationLayer.model to javafx.fxml;
}