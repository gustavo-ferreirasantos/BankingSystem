package com.demo.bank;


import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class mysqlConnect {
    Connection conn = null;

    public static Connection ConnectDb() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database-bankingsystem","root","root");
            JOptionPane.showMessageDialog(null, "Conectado com sucesso");
            System.out.println("Conectado com sucesso");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
