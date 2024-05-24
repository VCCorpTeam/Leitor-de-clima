module com.example.leitorclima {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.sql;
    requires kernel;
    requires layout;
    requires java.desktop;

    opens com.example.leitorclima to javafx.fxml;
    opens com.example.leitorclima.Models to javafx.base;
    exports com.example.leitorclima;
    exports com.example.leitorclima.GUI;
    opens com.example.leitorclima.GUI to javafx.fxml;
}