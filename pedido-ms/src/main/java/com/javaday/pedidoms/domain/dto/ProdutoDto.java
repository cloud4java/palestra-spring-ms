package com.javaday.pedidoms.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class
ProdutoDto{
    private long id;
    private Double preco;
    private String descricao;
}