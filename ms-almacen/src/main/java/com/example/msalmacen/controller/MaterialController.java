package com.example.msalmacen.controller;

import com.example.msalmacen.entity.Material;
import com.example.msalmacen.service.MaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materiales")
@RequiredArgsConstructor
public class MaterialController {

    private final MaterialService service;

    // ✅ Obtener todos los materiales
    @GetMapping
    public ResponseEntity<List<Material>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    // ✅ Guardar un nuevo material o sumar cantidad si ya existe con el mismo nombre
    @PostMapping
    public ResponseEntity<Material> guardar(@RequestBody Material material) {
        return ResponseEntity.ok(service.guardar(material));
    }

    // ✅ Actualizar un material por ID
    @PutMapping("/{id}")
    public ResponseEntity<Material> actualizar(@PathVariable Long id, @RequestBody Material material) {
        return ResponseEntity.ok(service.actualizar(id, material));
    }

    // ✅ Eliminar un material por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
