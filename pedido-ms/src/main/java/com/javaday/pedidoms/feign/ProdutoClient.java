package com.javaday.pedidoms.feign;

import com.javaday.pedidoms.domain.dto.ProdutoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProdutoClient {

    @Value("${app.produto.url:http://localhost:8082/produto/}")
    String url;
    @Autowired
    private RestTemplate restTemplate;

    public ProdutoDto getProductById(Long id) {
        return restTemplate.getForObject(url + id, ProdutoDto.class);
    }
}
