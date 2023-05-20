package com.javaday.pedidoms.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PedidoRequest {
    private Long idClient;
    private Long idProduto;
    private Double precoProduto;
}