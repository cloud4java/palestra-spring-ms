package com.javaday.pedidoms.service;

import com.javaday.pedidoms.domain.Pedido;
import com.javaday.pedidoms.domain.PedidoRepository;
import com.javaday.pedidoms.domain.dto.ClienteDto;
import com.javaday.pedidoms.domain.dto.PedidoRequest;
import com.javaday.pedidoms.domain.dto.PedidoResponse;
import com.javaday.pedidoms.domain.dto.ProdutoDto;
import com.javaday.pedidoms.client.ClienteClient;
import com.javaday.pedidoms.client.ProdutoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository repository;

    @Autowired
    private ProdutoClient produtoClient;

    public List<Pedido> getAll() {
        return (List<Pedido>) repository.findAll();
    }

    @Autowired
    private ClienteClient clienteClient;
    public PedidoResponse getById(Long id) {

        Pedido pedido = repository.findById(id).orElseThrow();
        ClienteDto clienteDto = clienteClient.getClienteById(pedido.getIdCliente());
        ProdutoDto produtoDto = produtoClient.getProductById(id);

        return new PedidoResponse(id, clienteDto.getNome(), produtoDto.getNome(), produtoDto.getPreco());
    }

    public PedidoResponse save(PedidoRequest pedidoRequest) {
        Pedido pedidoEntity = new Pedido();
        pedidoEntity.setIdCliente(pedidoRequest.getIdCliente());
        pedidoEntity.setIdProduto(pedidoRequest.getIdProduto());
        Pedido pedido = repository.save(pedidoEntity);
        return getById(pedido.getId());
    }
}
