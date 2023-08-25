package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static final String PASSWORD = "";
    private static final String USERNAME = "gitpod";
    private static final String JDBC_URL = "jdbc:postgresql://localhost/postgres";
    
     /* Como essa classe não tem atributos, apenas constantes, 
     esse método pode ser static, sendo static ele pode ser 
     chamado em outra classe através do nome dessa sua classe, 
     não precisando instanciar a classe */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }
}
