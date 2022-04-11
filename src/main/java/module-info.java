module com.example.tourplanner {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.sql;
    requires org.apache.logging.log4j;

    opens com.example.tourplanner to javafx.fxml;
    exports com.example.tourplanner;
    exports com.example.tourplanner.controller;
    opens com.example.tourplanner.controller to javafx.fxml;
}