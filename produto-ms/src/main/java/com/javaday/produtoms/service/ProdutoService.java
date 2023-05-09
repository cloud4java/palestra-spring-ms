package com.javaday.produtoms.service;

import com.javaday.produtoms.domain.Produto;
import com.javaday.produtoms.domain.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public List<Produto> getAll(){
      return (List<Produto>) repository.findAll();
    }
    public Optional<Produto> getById(Long id){
        return repository.findById(id);
    }
    public Produto save(Produto produto){
        return repository.save(produto);
    }
}