package com.javaday.pedidoms.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto{
    private long id;
    private String nome;
    private String descricao;
    private int idade;
}