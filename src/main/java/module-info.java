module com.demo.bank {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.google.gson;
    requires java.sql;
    requires java.desktop;
    requires mysql.connector.j;

    opens com.demo.bank to javafx.fxml;
    exports com.demo.bank;
    exports com.demo.bank.Controllers;
    exports com.demo.bank.Classes;
    /*exports com.demo.bank.Models;*/
    opens com.demo.bank.Controllers to javafx.fxml;

}