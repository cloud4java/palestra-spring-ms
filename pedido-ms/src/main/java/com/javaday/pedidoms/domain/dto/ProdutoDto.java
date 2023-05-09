package com.javaday.pedidoms.domain.dto;

public class ProdutoDto{
    private long id;
    private Double preco;
    private String descricao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}