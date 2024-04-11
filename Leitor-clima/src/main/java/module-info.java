module com.example.leitorclima {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.leitorclima to javafx.fxml;
    exports com.example.leitorclima;
    exports com.example.leitorclima.GUI;
    opens com.example.leitorclima.GUI to javafx.fxml;
}