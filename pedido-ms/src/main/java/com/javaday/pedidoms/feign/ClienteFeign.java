package com.javaday.pedidoms.feign;

import com.javaday.pedidoms.domain.dto.ClienteDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(name = "produto-feign",url = "http://localhost:8081")
public interface ClienteFeign {
    @RequestMapping("/cliente")
    ClienteDto findById(Long idCliente);

    @PostMapping
    ClienteDto create(ClienteDto clienteDto);
}
