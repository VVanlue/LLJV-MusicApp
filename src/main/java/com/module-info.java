module java.com {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;
    requires json.simple;
    requires jfugue;

    opens com.model to javafx.fxml;
    exports com.model;

    requires json.simple;
    requires com.google.gson;
}
