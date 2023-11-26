module View {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.desktop;

    opens Controller to javafx.fxml;
    exports Controller;
}

