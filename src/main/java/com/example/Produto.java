package com.example;

public class Produto {
    private Long id;
    private String nome;
    private Marca marca_id;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Marca getMarca_id() {
        return marca_id;
    }
    public void setMarca_id(Marca marca_id) {
        this.marca_id = marca_id;
    }

    

}
