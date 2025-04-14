module com.lljvmusicapp {
    requires json.simple;
    requires org.json;
    requires transitive javafx.controls;
    requires transitive javafx.fxml;
    requires junit;
    requires jfugue;


    opens com.lljvmusicapp.model to javafx.fxml;
    opens com.lljvmusicapp.controller to javafx.fxml;
    exports com.lljvmusicapp;
    exports com.lljvmusicapp.controller;
    exports com.lljvmusicapp.model;
}