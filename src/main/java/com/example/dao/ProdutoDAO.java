package com.example.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.example.model.Produto;

public class ProdutoDAO extends DAO{
    //private Connection conn; // fazendo a extenção da classe DAO, não precisamos mais dessa variável aqui q se repetia tbm em EstadoDAO

    public ProdutoDAO(Connection conn) {
        super(conn); //com a extenção da classe DAO, não é preciso repetir a atribuição da variável conn aqui, basta chamar o super(coonn);
    }

    public void excluir(long id) {
        var sql = "delete from produto where id = ?";
        System.out.println();     

        try (var statement = conn.prepareStatement(sql)) {
            statement.setLong(1, id);

            //executeUpdate() - retorna quantas linhas foram afetadas no bd
            if(statement.executeUpdate() == 1) {
                System.out.printf("Produto %d excluído com sucesso!", id);
                System.out.println();
            } else {
                System.out.printf("O produto %d nao foi excluído!", id);
                System.out.println();
            }
        } catch (SQLException e) {            
            System.out.println("Erro ao exluir o produto: " + e.getMessage());
        }       

    }

    public void inserir(Produto produto) {
        var sql = "insert into produto (nome, marca_id, valor) values (?, ?, ?)";
        System.out.println();

        try (var statement = conn.prepareStatement(sql)){

            statement.setString(1, produto.getNome());
            statement.setLong(2, produto.getMarca().getId());
            statement.setDouble(3, produto.getValor());
            statement.executeUpdate();

        } catch (SQLException e) {            
            System.out.println("Erro na execução da consulta: " + e.getMessage());
        }        
    }

    public void alterar(Produto produto, long id) {
        var sql = "update produto set nome = ?, marca_id = ?, valor = ? where id = ?";
        System.out.println();

        try (var statement = conn.prepareStatement(sql)){

            statement.setString(1, produto.getNome());
            statement.setLong(2, produto.getMarca().getId());         
            statement.setDouble(3, produto.getValor());
            statement.setLong(4, produto.getId());
            statement.executeUpdate();

        } catch (SQLException e) {            
            System.out.println("Erro na alteração do produto: " + e.getMessage());
        }        
    }
    
}
