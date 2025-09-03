module com.demo.bank {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.google.gson;

    opens com.demo.bank to javafx.fxml;
    exports com.demo.bank;
    exports com.demo.bank.Controllers;
    opens com.demo.bank.Controllers to javafx.fxml;
}