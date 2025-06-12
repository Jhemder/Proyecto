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

    @PostMapping
    public ResponseEntity<Material> save(@RequestBody Material m) {
        return ResponseEntity.ok(service.save(m));
    }

    @GetMapping
    public ResponseEntity<List<Material>> all() {
        return ResponseEntity.ok(service.findAll());
    }
}
