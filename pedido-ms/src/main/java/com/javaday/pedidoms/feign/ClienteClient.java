package com.javaday.pedidoms.feign;

import com.javaday.pedidoms.domain.dto.ClienteDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ClienteClient {

    @Value("${app.cliente.url:http://localhost:8081/cliente/}")
    private String url;

    private final RestTemplate restTemplate;

    public ClienteClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ClienteDto getClienteById(Long id) {
        return restTemplate.getForEntity(url + id, ClienteDto.class).getBody();
    }
}
