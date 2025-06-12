package com.example.msalmacen.controller;

import com.example.msalmacen.dto.MaterialRequestDTO;
import com.example.msalmacen.dto.MaterialResponseDTO;
import com.example.msalmacen.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materiales")
public class MaterialController {

    @Autowired
    private MaterialService service;

    @PostMapping
    public MaterialResponseDTO agregar(@RequestBody MaterialRequestDTO dto) {
        return service.agregar(dto);
    }

    @PutMapping("/{id}")
    public MaterialResponseDTO actualizar(@PathVariable Long id, @RequestBody MaterialRequestDTO dto) {
        return service.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

    @GetMapping
    public List<MaterialResponseDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public MaterialResponseDTO obtener(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    // ✅ Refactor aquí: usamos @RequestBody en lugar de @RequestParam
    @PostMapping("/descontar")
    public boolean descontar(@RequestBody MaterialRequestDTO dto) {
        return service.descontarMaterial(dto.getNombre(), dto.getTipo(), dto.getColor(), dto.getCantidad());
    }
}
