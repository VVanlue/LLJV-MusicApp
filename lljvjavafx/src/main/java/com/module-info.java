module com.lljvmusicapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;
    requires jfugue;

    opens com.model to javafx.fxml;
}
