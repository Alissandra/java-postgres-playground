package com.example.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.example.model.Estado;

public class EstadoDAO extends DAO {
    //private Connection conn; // fazendo a extenção da classe DAO, não precisamos mais dessa variável aqui q se repetia tbm em EstadoDAO

    public EstadoDAO(Connection conn) {
        super(conn);
    }


    public void localizar(String uf) {
        try {
            //var sql = "select * from estado where uf = '" + uf + "'"; //sucetível a SQL Injection (PERIGOSO)
            var sql = "select * from estado where uf = ?";
            var statement = conn.prepareStatement(sql);
            System.out.println();
            System.out.println(sql);
            statement.setString(1, uf);
            var result = statement.executeQuery();
            if(result.next()) {
                System.out.printf("Id: %d Nome: %s UF: %s%n", result.getInt("id"), result.getString("nome"), result.getString("uf"));
            }
        } catch (SQLException e) {            
            System.err.println("Erro ao executar consulta SQL: " + e.getMessage());
        }
    }

    public List<Estado> listar() throws SQLException {
        
        var lista = new LinkedList<Estado>(); //Cria lista para adicionar os registros/linhas de estado        
        var statement = conn.createStatement(); //Cria uma declaração SQL para ser enviada
        var result = statement.executeQuery("select * from estado"); //Executa a declaração e salva o retorno em result
        
        //faz um for nas linhas, verificando se tem uma próxima linha e vai adicionando cada valor nos campos indicados e ao final vai adicionando na lista para poder ser visualizada a tabela completa
        while(result.next()){
            var estado = new Estado();            
            estado.setId(result.getLong("id"));
            estado.setNome(result.getString("nome"));
            estado.setUf(result.getString("uf"));
            lista.add(estado); //adiciona cada linha na lista criada mais acima
            
        } 
        
        return lista;
    }
    
}
