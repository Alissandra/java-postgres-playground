package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AppBd {    

    private static final String PASSWORD = "";
    private static final String USERNAME = "gitpod";
    private static final String JDBC_URL = "jdbc:postgresql://localhost/postgres";
    
    //private static String uf;

    public static void main(String[] args) {
        new AppBd();            
    }

    public AppBd() {
        try(var conn = getConnection()){
            carregarDriverJDBC();
            listarEstados(conn);           
            localizarEstado(conn, "TO");
        } catch (SQLException e) {            
            System.err.println("Não foi possível conectar ao banco de dados: " + e.getMessage());    
        }
    }

    private void localizarEstado(Connection conn, String uf) {
        try {
            var statement = conn.createStatement();
        } catch (SQLException e) {            
            e.printStackTrace();
        }
    }

    private void listarEstados(Connection conn) {
        
        try{
            System.out.println("Conexão com banco de dados realizada com sucesso!");
        
            var statement = conn.createStatement();
            var result = statement.executeQuery("select * from estado");
        
            while(result.next()){
                System.out.printf("Id: %d Nome: %s UF: %s%n", result.getInt("id"), result.getString("nome"), result.getString("uf"));
            } 
        } catch (SQLException e) {           
            System.err.println("Não foi possível executar a consulta ao banco: " + e.getMessage());            
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }

    private void carregarDriverJDBC() {
        try{            
            Class.forName("org.postgresql.Driver");
        } catch(ClassNotFoundException e) {
            System.err.println("Não foi possível carregar a biblioteca para acesso ao banco de dados: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    
}
