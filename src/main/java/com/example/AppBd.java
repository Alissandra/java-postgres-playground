package com.example;

import java.sql.SQLException;
import com.example.dao.ConnectionManager;
import com.example.dao.DAO;
import com.example.dao.EstadoDAO;
import com.example.dao.ProdutoDAO;
import com.example.model.Estado;
import com.example.model.Marca;
import com.example.model.Produto;

public class AppBd {    

    public static void main(String[] args) {
        new AppBd();            
    }

    public AppBd() {
        
        //carregarDriverJDBC(); // Esse código não é mais necessário, pois atualmente o driver é carregado de forma automática (caso ele seja encontrado)
        
        try(var conn = ConnectionManager.getConnection()){

            
            var estadoDAO = new EstadoDAO(conn);
            var produtoDAO = new ProdutoDAO(conn);
            var dao = new DAO(conn);
            var produto = new Produto();
            var marca = new Marca();
            
            marca.setId(1L); //adiciona o "L" ao lado do número pq ele não é um tipo primitivo long é e sim um Long(classe wrapper/objeto)
                   
            produto.setMarca(marca);
            produto.setNome("Produto teste A");
            produto.setValor(180);
            produto.setId(198L);//adiciona o "L" - long                      
            
            var listaEstados = estadoDAO.listar();
            
            // pode ser "var" ou "Estado"
            for(var e : listaEstados) {
                System.out.println(e);
                //System.out.printf("Id: %d | Nome: %s | UF: %s | Região: %s | Área(km): %d | População: %d", e.getId(), e.getNome(), e.getUf(), e.getRegiao(), e.getAreaKm(), e.getPopulacao());
            }
            
            /*estadoDAO.localizar("RN");
            
            dao.listarDadosTabela("produto"); 
            
            produtoDAO.inserir(produto);
            produtoDAO.excluir(201L);
            produtoDAO.alterar(produto, produto.getId());            
            
            dao.listarDadosTabela("produto");
             */          
            
        } catch (SQLException e) {            
            System.err.println("Não foi possível conectar ao banco de dados: " + e.getMessage());    
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
