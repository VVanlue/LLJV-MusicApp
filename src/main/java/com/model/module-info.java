module com.model {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;
    requires jfugue;

    opens com.model to javafx.fxml;
    exports com.model;
}
