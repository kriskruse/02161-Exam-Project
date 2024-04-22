module hellofx {
    requires javafx.controls;
    requires javafx.fxml;

    //opens dtu.examproject.ui to javafx.fxml; // Gives access to fxml files
    //exports dtu.examproject.ui; // Exports the class inheriting from javafx.application.Application
    //opens dtu.examproject.main to javafx.fxml; // Gives access to fxml files
    exports dtu.examproject.main; // Exports the controller classes


}