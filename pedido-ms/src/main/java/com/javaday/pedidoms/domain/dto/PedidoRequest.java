package com.javaday.pedidoms.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PedidoRequest {
    private Long idCliente;
    private Long idProduto;
    private Double precoProduto;
}