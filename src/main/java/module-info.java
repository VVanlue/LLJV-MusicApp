module com.lljvmusicapp {
    requires json.simple;
    requires org.json;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires junit;
    requires jfugue;


    opens com.lljvmusicapp.model to javafx.fxml;
    opens com.lljvmusicapp.controller to javafx.fxml;
    exports com.lljvmusicapp;
    exports com.lljvmusicapp.controller;
    exports com.lljvmusicapp.model;
}