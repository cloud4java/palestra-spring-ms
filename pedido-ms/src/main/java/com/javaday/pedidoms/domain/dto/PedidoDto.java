package com.javaday.pedidoms.domain.dto;

public class PedidoDto {

    private ClienteDto clienteDto;
    private ProdutoDto produtoDto;

    public PedidoDto(ClienteDto clienteDto, ProdutoDto produtoDto) {
        this.clienteDto = clienteDto;
        this.produtoDto = produtoDto;
    }

    public ClienteDto getClienteDto() {
        return clienteDto;
    }

    public void setClienteDto(ClienteDto clienteDto) {
        this.clienteDto = clienteDto;
    }

    public ProdutoDto getProdutoDto() {
        return produtoDto;
    }

    public void setProdutoDto(ProdutoDto produtoDto) {
        this.produtoDto = produtoDto;
    }
}