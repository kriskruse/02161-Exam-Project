module hellofx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens dtu.examproject.ui to javafx.fxml; // Gives access to fxml files
    exports dtu.examproject.main;

}