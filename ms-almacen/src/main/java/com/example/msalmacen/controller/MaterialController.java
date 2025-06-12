package com.example.msalmacen.controller;

import com.example.msalmacen.dto.MaterialDTO;
import com.example.msalmacen.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materiales")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @GetMapping
    public List<MaterialDTO> listarTodos() {
        return materialService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public MaterialDTO obtenerPorId(@PathVariable Long id) {
        return materialService.obtenerPorId(id);
    }

    @PostMapping
    public MaterialDTO crear(@RequestBody MaterialDTO dto) {
        return materialService.crear(dto);
    }

    @PutMapping("/{id}")
    public MaterialDTO actualizar(@PathVariable Long id, @RequestBody MaterialDTO dto) {
        return materialService.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        materialService.eliminar(id);
    }
}
