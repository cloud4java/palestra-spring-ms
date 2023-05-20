package com.javaday.pedidoms.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PedidoResponse {
    private Long idPedido;
    private String nomeCliente;
    private String nomeProduto;
   private Double precoProduto;
}
