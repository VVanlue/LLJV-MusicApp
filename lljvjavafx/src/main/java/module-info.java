module com.lljvmusicapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;

    opens com.model to javafx.fxml;
    exports com.model;
}
