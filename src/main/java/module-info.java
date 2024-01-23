module com.example.czyzdaszto {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.czyzdaszto to javafx.fxml;
    exports com.example.czyzdaszto;
}