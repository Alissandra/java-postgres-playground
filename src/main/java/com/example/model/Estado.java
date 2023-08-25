package com.example.model;

public class Estado {
    private Long id;
    private String nome;
    private String uf;
    private RegiaoGeografica regiao;
    private int areaKm;
    private int populacao;

    

    @Override
    public String toString() {
        return "Id: " + id + ", Nome:" + nome + ", UF:" + uf + "]";
    }

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
    public String getUf() {
        return uf;
    }
    public void setUf(String uf) {
        this.uf = uf;
    }
    public RegiaoGeografica getRegiao() {
        return regiao;
    }
    public void setRegiao(RegiaoGeografica regiao) {
        this.regiao = regiao;
    }
    public int getAreaKm() {
        return areaKm;
    }
    public void setAreaKm(int areaKm) {
        this.areaKm = areaKm;
    }
    public int getPopulacao() {
        return populacao;
    }
    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }
   
    
    
}
