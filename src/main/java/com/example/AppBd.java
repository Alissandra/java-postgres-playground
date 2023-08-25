package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.sql.Statement;

import com.example.dao.ConnectionManager;
import com.example.model.Marca;
import com.example.model.Produto;

public class AppBd {    

    public static void main(String[] args) {
        new AppBd();            
    }

    public AppBd() {
        
            //carregarDriverJDBC(); // Esse código não é mais necessário, pois atualmente o driver é carregado de forma automática (caso ele seja encontrado)
        
        try(var conn = ConnectionManager.getConnection()){                       

            var marca = new Marca();
            marca.setId(1L); //adiciona o "L" ao lado do número pq ele não é um tipo primitivo long é e sim um Long(classe wrapper/objeto)
                        
            var produto = new Produto();
            produto.setMarca(marca);
            produto.setNome("Produto teste A");
            produto.setValor(180);
            produto.setId(198L);//adiciona o "L" - long

            listarDadosTabela(conn, "produto");           
            //localizarEstado(conn, "PR");
            //inserirProduto(conn, produto);
            //listarDadosTabela(conn, "produto");
            //System.err.println();
            //excluirProduto(conn, 201L);
            //System.err.println();
            alterarProduto(conn, produto, produto.getId());
            System.err.println("--------------------");
            listarDadosTabela(conn, "produto");
                         
            
        } catch (SQLException e) {            
            System.err.println("Não foi possível conectar ao banco de dados: " + e.getMessage());    
        }
    }

    private void excluirProduto(Connection conn, long id) {
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

    private void inserirProduto(Connection conn, Produto produto) {
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

    private void alterarProduto(Connection conn, Produto produto, long id) {
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

    private void listarDadosTabela(Connection conn, String tabela) {
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

    private void localizarEstado(Connection conn, String uf) {
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

    

    /* // Com os framewors modernos, como spring, essa configuração não é mais realizada
    private void carregarDriverJDBC() {
        try{            
            Class.forName("org.postgresql.Driver");
        } catch(ClassNotFoundException e) {
            System.err.println("Não foi possível carregar a biblioteca para acesso ao banco de dados: " + e.getMessage());
            e.printStackTrace();
        }
    }
    */
    
    
}
