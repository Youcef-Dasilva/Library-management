module com.aldrin.salam {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.aldrin.salam to javafx.fxml;
    exports com.aldrin.salam;
}
