package com.javaday.pedidoms.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class
ProdutoDto{
    private long id;
    private Double preco;
    private String descricao;
    private String nome;
}