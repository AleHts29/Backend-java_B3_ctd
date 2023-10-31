package com.dh.c32.service;

import com.dh.c32.entities.Producto;
import com.dh.c32.repoository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductoService {
    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public Producto saveProduct(Producto producto){
        return productoRepository.save(producto);
    }

    public Optional<Producto> getById(Long id){
        return productoRepository.findById(id);
    }

    public void deleteById(Long id){
        productoRepository.deleteById(id);
    }

}
