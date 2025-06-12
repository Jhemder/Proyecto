package com.example.msalmacen.controller;

import com.example.msalmacen.dto.ProductoTerminadoDTO;
import com.example.msalmacen.service.ProductoTerminadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos-terminados")
public class ProductoTerminadoController {

    @Autowired
    private ProductoTerminadoService productoService;

    @GetMapping
    public List<ProductoTerminadoDTO> listarTodos() {
        return productoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ProductoTerminadoDTO obtenerPorId(@PathVariable Long id) {
        return productoService.obtenerPorId(id);
    }

    @PostMapping
    public ProductoTerminadoDTO crear(@RequestBody ProductoTerminadoDTO dto) {
        return productoService.crear(dto);
    }

    @PutMapping("/{id}")
    public ProductoTerminadoDTO actualizar(@PathVariable Long id, @RequestBody ProductoTerminadoDTO dto) {
        return productoService.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        productoService.eliminar(id);
    }
}
