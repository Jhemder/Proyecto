package com.example.msalmacen.controller;

import com.example.msalmacen.entity.ProductoTerminado;
import com.example.msalmacen.service.ProductoTerminadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos-terminados")
@RequiredArgsConstructor
public class ProductoTerminadoController {

    private final ProductoTerminadoService service;

    @GetMapping
    public ResponseEntity<List<ProductoTerminado>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping
    public ResponseEntity<ProductoTerminado> crear(@RequestBody ProductoTerminado producto) {
        return ResponseEntity.ok(service.crear(producto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
