package com.example.msalmacen.controller;

import com.example.msalmacen.entity.Material;
import com.example.msalmacen.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materiales")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @PostMapping
    public Material agregar(@RequestBody Material material) {
        return materialService.agregarMaterial(material);
    }

    @GetMapping
    public List<Material> listar() {
        return materialService.listarMateriales();
    }

    @GetMapping("/{id}")
    public Material obtener(@PathVariable Long id) {
        return materialService.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public Material actualizar(@PathVariable Long id, @RequestBody Material material) {
        return materialService.actualizarMaterial(id, material);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        materialService.eliminarMaterial(id);
    }

    @PostMapping("/descontar")
    public boolean descontarMaterial(
            @RequestParam String nombre,
            @RequestParam String tipo,
            @RequestParam String color,
            @RequestParam double cantidad
    ) {
        return materialService.descontarMaterial(nombre, tipo, color, cantidad);
    }
}
