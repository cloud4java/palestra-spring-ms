package com.javaday.pedidoms.client;

import com.javaday.pedidoms.domain.dto.ProdutoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "cliente-feign",url = "localhost:8082/produto")
public interface ProdutoFeign {

    @GetMapping
    ProdutoDto findByPedido(Long id);


    @GetMapping
    ProdutoDto getProduto();

    @PostMapping
    ProdutoDto create(ProdutoDto produtoDto);
}
