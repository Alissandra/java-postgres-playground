package com.example.dao;

import java.sql.Connection;
import java.sql.SQLException;
    

public class DAO {
    protected Connection conn;

    public DAO(Connection conn) {
        this.conn = conn;
    }
    
    public void listarDadosTabela(String tabela) {
        var sql = "select * from " + tabela;
        System.out.println(sql);
        try {
            var statement = conn.createStatement();
            var result = statement.executeQuery(sql);

            var metadata = result.getMetaData(); /*para trazer o cabeçalho da tabela*/
            int cols = metadata.getColumnCount();/*para trazer o cabeçalho da tabela*/

            for (int i = 1; i <= cols; i++) {
                System.out.printf("%-25s | ", metadata.getColumnName(i));
            }
            System.out.println();

            while(result.next()) {                
                for (int i = 1; i <= cols; i++) {
                    System.out.printf("%-25s | ", result.getString(i));
                }
                System.out.println();
            }

        } catch (SQLException e) {            
            System.out.println("Erro na execução da consulta: " + e.getMessage());
        }
    }
   
    
}
