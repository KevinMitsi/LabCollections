module com.example.labcollections {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.labcollections to javafx.fxml;
    exports com.example.labcollections;

    opens com.example.labcollections.controller to javafx.fxml;
    exports com.example.labcollections.controller;

    exports com.example.labcollections.model;
    exports com.example.labcollections.exception;

}