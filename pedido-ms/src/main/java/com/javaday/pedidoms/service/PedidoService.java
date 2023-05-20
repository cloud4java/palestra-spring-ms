package com.javaday.pedidoms.service;

import com.javaday.pedidoms.domain.Pedido;
import com.javaday.pedidoms.domain.PedidoRepository;
import com.javaday.pedidoms.domain.dto.ClienteDto;
import com.javaday.pedidoms.domain.dto.PedidoRequest;
import com.javaday.pedidoms.domain.dto.PedidoResponse;
import com.javaday.pedidoms.domain.dto.ProdutoDto;
import com.javaday.pedidoms.feign.ClienteFeign;
import com.javaday.pedidoms.feign.ProdutoFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository repository;

    @Autowired
    private ClienteFeign clienteFeign;

    @Autowired
    private ProdutoFeign produtoFeign;

    public List<Pedido> getAll() {
        return (List<Pedido>) repository.findAll();
    }

    public PedidoResponse getById(Long id) {

        Pedido pedido = repository.findById(id).orElseThrow();
        ClienteDto clienteDto = clienteFeign.findById(pedido.getIdCliente());
        ProdutoDto produtoDto = produtoFeign.findByPedido(id);

        return new PedidoResponse(id, clienteDto.getNome(), produtoDto.getDescricao(), produtoDto.getPreco());
    }

    public PedidoResponse save(PedidoRequest pedidoRequest) {
        Pedido pedidoEntity = new Pedido();
        pedidoEntity.setIdCliente(pedidoRequest.getIdClient());
        pedidoEntity.setIdProduto(pedidoRequest.getIdProduto());
        Pedido pedido = repository.save(pedidoEntity);
        return getById(pedido.getId());
    }
}
