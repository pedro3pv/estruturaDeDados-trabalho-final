module com.example.estruturadedadostrabalhofinal {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.estruturadedadostrabalhofinal to javafx.fxml;
    exports com.example.estruturadedadostrabalhofinal;
}