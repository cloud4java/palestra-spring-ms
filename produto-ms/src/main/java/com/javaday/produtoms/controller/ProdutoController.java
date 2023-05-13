    package com.javaday.produtoms.controller;

import com.javaday.produtoms.domain.Produto;
import com.javaday.produtoms.service.ProdutoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
@Slf4j
public class ProdutoController {
    @Autowired
    private ProdutoService service;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Produto> findById(@PathVariable Long id){
        log.info("Searching product by id: {} ", id);
        Optional<Produto> prod = service.getById(id);
        if (prod.isPresent()) {
            return new ResponseEntity(prod, HttpStatus.OK);
        }else{
            log.warn("Product not found by id {} ", id);
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Produto> findAll(){
        return service.getAll();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Produto save(@RequestBody Produto produto){
        log.info("Creating product");
        return service.save(produto);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody Produto produto){
        log.info("Updating product by id {} ", id);
        Optional<Produto> prod = service.getById(id);
        if (prod.isPresent()) {
            Produto p = prod.get();
            p.setNome(produto.getNome());
            p.setNome(produto.getNome());
            Produto saved = service.save(p);
            return new ResponseEntity(saved,HttpStatus.OK);
        }else{
            log.warn("Product not found by id {} ", id );
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}