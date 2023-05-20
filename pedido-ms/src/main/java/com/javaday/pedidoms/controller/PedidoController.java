package com.javaday.pedidoms.controller;

import com.javaday.pedidoms.domain.Pedido;
import com.javaday.pedidoms.domain.dto.PedidoRequest;
import com.javaday.pedidoms.domain.dto.PedidoResponse;
import com.javaday.pedidoms.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PedidoResponse> create(@RequestBody PedidoRequest pedidoRequest){
        PedidoResponse response = pedidoService.save(pedidoRequest);
        return  ResponseEntity.ok(response);
    }
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PedidoResponse> findById(@PathVariable Long id) {
        PedidoResponse pedidoResponse = pedidoService.getById(id);
        return ResponseEntity.ok(pedidoResponse);
    }

    @GetMapping
    private List<Pedido> getAll(){
        return pedidoService.getAll();
    }
}