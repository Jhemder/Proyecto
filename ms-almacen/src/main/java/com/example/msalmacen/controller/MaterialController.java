package com.example.msalmacen.controller;

import com.example.msalmacen.dto.MaterialDTO;
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

    private final MaterialService materialService;

    // POST - Agregar o sumar material existente
    @PostMapping
    public ResponseEntity<Material> agregarMaterial(@RequestBody MaterialDTO dto) {
        return ResponseEntity.ok(materialService.crearOActualizarMaterial(dto));
    }

    // GET - Listar materiales disponibles
    @GetMapping
    public ResponseEntity<List<Material>> listar() {
        return ResponseEntity.ok(materialService.listarMateriales());
    }
}
