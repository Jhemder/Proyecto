package com.example.msalmacen.controller;

import com.example.msalmacen.entity.ProductoTerminado;
import com.example.msalmacen.service.ProductoTerminadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos-terminados")
@RequiredArgsConstructor
public class ProductoTerminadoController {

    private final ProductoTerminadoService service;

    @GetMapping
    public List<ProductoTerminado> listar() {
        return service.listar();
    }

    @PostMapping
    public ProductoTerminado guardar(@RequestBody ProductoTerminado producto) {
        return service.guardar(producto);
    }

    @PutMapping("/{id}")
    public ProductoTerminado actualizar(@PathVariable Long id, @RequestBody ProductoTerminado producto) {
        return service.actualizar(id, producto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
