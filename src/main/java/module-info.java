module com.example.hotel_manager {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.hotel_manager to javafx.fxml;
    exports com.example.hotel_manager;
}