package com.dh.c32.controller;

import com.dh.c32.entities.Producto;
import com.dh.c32.service.ProductoService;
import jakarta.persistence.AttributeOverride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto){
        return ResponseEntity.ok(productoService.saveProduct(producto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarProducto(@PathVariable Long id){
        if(productoService.getById(id).isPresent()){
            productoService.deleteById(id);
            return ResponseEntity.ok("Se elimina el producto");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se pudo eliminar el producto con el ID: "+id);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarProducto(@PathVariable Long id){
        Optional<Producto> producto = productoService.getById(id);
        if(producto.isPresent()){
            return ResponseEntity.ok(producto.get());
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
