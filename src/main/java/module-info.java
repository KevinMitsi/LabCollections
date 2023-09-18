module com.example.labcollections {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.labcollections to javafx.fxml;
    exports com.example.labcollections;
}