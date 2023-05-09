package com.javaday.pedidoms.service;

import com.javaday.pedidoms.domain.Pedido;
import com.javaday.pedidoms.domain.PedidoRepository;
import com.javaday.pedidoms.domain.dto.ClienteDto;
import com.javaday.pedidoms.domain.dto.PedidoDto;
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

    public PedidoDto getById(Long id) {

        Pedido pedido = repository.findById(id).orElseThrow();
        ClienteDto clienteDto = clienteFeign.findById(pedido.getIdCliente());
        ProdutoDto produtoDto = produtoFeign.findByPedido(id);

        return new PedidoDto(clienteDto, produtoDto);
    }

    public Pedido save(Pedido pedido) {
        return repository.save(pedido);
    }

    public void save(PedidoDto pedidoDto) {
        produtoFeign.create(pedidoDto.getProdutoDto());
        clienteFeign.create(pedidoDto.getClienteDto());
        Pedido pedidoEntity = new Pedido();
        pedidoEntity.setIdCliente(pedidoDto.getClienteDto().getId());
        pedidoEntity.setIdProduto(pedidoDto.getProdutoDto().getId());
        repository.save(pedidoEntity);
    }
//
//    private PedidoDto tranlateToDto(Pedido pedido, ClienteDto clienteDto, ProdutoDto produtoDto){
//        PedidoDto pedidoDto = new PedidoDto();
//        pedidoDto.setClienteDto(clienteDto);
//
//        return pedidoDto;
//    }
}
