package com.example.msalmacen.controller;

import com.example.msalmacen.dto.DescuentoMaterialDTO;
import com.example.msalmacen.entity.Material;
import com.example.msalmacen.service.MaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materiales")
@RequiredArgsConstructor
public class MaterialController {

    private final MaterialService service;

    @GetMapping
    public List<Material> listarTodos() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Material obtenerPorId(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Material guardar(@RequestBody Material material) {
        return service.save(material);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.delete(id);
    }

    @PostMapping("/descontar")
    public void descontarMaterial(@RequestBody DescuentoMaterialDTO dto) {
        service.descontarMaterial(dto.getIdMaterial(), dto.getCantidadUsada());
    }

    @PostMapping("/descontar-multiple")
    public void descontarVarios(@RequestBody List<DescuentoMaterialDTO> lista) {
        for (DescuentoMaterialDTO dto : lista) {
            service.descontarMaterial(dto.getIdMaterial(), dto.getCantidadUsada());
        }
    }
}
