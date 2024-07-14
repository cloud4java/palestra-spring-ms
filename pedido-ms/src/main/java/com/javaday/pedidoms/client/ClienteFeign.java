package com.javaday.pedidoms.client;

import com.javaday.pedidoms.domain.dto.ClienteDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "produto-feign",url = "http://localhost:8081")
public interface ClienteFeign {
    @RequestMapping("/cliente")
    ClienteDto findById(Long idCliente);

    @PostMapping
    ClienteDto create(ClienteDto clienteDto);
}
