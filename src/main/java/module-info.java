module com.demo.bank {
    // JavaFX
    requires javafx.controls;
    requires javafx.fxml;

    // HTTP (nativo do Java 11+)
    requires java.net.http;

    // Gson (JSON)
    requires com.google.gson;

    // JDBC + MySQL
    requires java.sql;
    requires mysql.connector.j;

    // Desktop (caso esteja usando AWT ou Swing em algum ponto)
    requires java.desktop;

    // HttpServer nativo (caso realmente use)
    requires jdk.httpserver;

    // Apache HttpClient (dependência externa)
    requires org.apache.httpcomponents.httpclient.fluent;

    // Abre pacotes para reflexão do JavaFX
    opens com.demo.bank to javafx.fxml;
    opens com.demo.bank.Controllers to javafx.fxml;
    opens com.demo.bank.Model to com.google.gson; // Necessário para Gson mapear os atributos

    // Exporta pacotes
    exports com.demo.bank;
    exports com.demo.bank.Controllers;
    exports com.demo.bank.Model;
}
