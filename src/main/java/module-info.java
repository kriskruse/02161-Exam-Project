module hellofx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires io.cucumber.java;
    requires junit;

    opens dtu.examproject.ui to javafx.fxml; // Gives access to fxml files
    //exports dtu.examproject.ui; // Exports the class inheriting from javafx.application.Application
    opens dtu.examproject.main to javafx.controls, javafx.fxml; // Exports the controller classes
    exports dtu.examproject.main;

}