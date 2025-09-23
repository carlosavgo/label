module com.example.label {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.label to javafx.fxml;
    exports com.example.label;
}