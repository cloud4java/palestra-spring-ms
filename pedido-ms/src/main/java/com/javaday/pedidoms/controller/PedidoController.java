package com.javaday.pedidoms.controller;

import com.javaday.pedidoms.domain.Pedido;
import com.javaday.pedidoms.domain.dto.PedidoDto;
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

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody PedidoDto pedidoDto){
         pedidoService.save(pedidoDto);
         return  ResponseEntity.ok().build();
    }
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PedidoDto> findById(@PathVariable Long id) {
        PedidoDto pedidoDto = pedidoService.getById(id);
        return ResponseEntity.ok(pedidoDto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Pedido> findAll() {
        List<Pedido> pedidos = pedidoService.getAll();
        //TODO: buscar o pedido por id no MS de pedido usando RestTemplate
        //Criar dto com os dados que mostraria na tela (nome de produto e cliente)

        return pedidos;
    }

    //TODO: Implementar POST pedido
/*
//passar um post ao api-gateway
            Map<String, Object> result =
                    restTemplate.getForObject("http://localhost:8200/inventory/check/{itemId}/", Map.class, params);
                if (result.containsKey("errorId")) {
                    if ("SVR_URI_010".equals(result.get("errorId"))) {
                        throw new ItemNotFoundException();
                    }
                }

                if (Integer.parseInt(result.get("unit").toString()) < orderedItem.getUnit()) {
                    throw new ItemUnitLackingException();
                }
                orderedItem.setVersionno(Long.parseLong(result.get("versionno").toString()));
 */
}