module com.lljvmusicapp {
    requires json.simple;
    requires org.json;
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;
    requires transitive jfugue;


    opens com.lljvmusicapp.model to javafx.fxml;
    exports com.lljvmusicapp.model;
}