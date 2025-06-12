package com.example.msalmacen.controller;

import com.example.msalmacen.dto.ProductoTerminadoDTO;
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

    private final ProductoTerminadoService productoTerminadoService;

    // POST - Fabricar un producto terminado
    @PostMapping
    public ResponseEntity<ProductoTerminado> fabricarProducto(@RequestBody ProductoTerminadoDTO dto) {
        return ResponseEntity.ok(productoTerminadoService.crearProductoTerminado(dto));
    }

    // GET - Listar productos terminados
    @GetMapping
    public ResponseEntity<List<ProductoTerminado>> listarProductos() {
        return ResponseEntity.ok(productoTerminadoService.listarProductosTerminados());
    }
}
