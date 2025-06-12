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

    @PostMapping
    public ResponseEntity<ProductoTerminado> fabricar(@RequestBody ProductoTerminado p) {
        return ResponseEntity.ok(service.fabricar(p));
    }

    @GetMapping
    public ResponseEntity<List<ProductoTerminado>> all() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/mes/{year}/{month}")
    public ResponseEntity<List<ProductoTerminado>> mes(
            @PathVariable int year,
            @PathVariable int month) {
        return ResponseEntity.ok(service.listarPorMes(year, month));

    }
}
