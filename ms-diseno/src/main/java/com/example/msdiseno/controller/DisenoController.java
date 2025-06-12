package com.example.msdiseno.controller;

import com.example.msdiseno.entity.Diseno;
import com.example.msdiseno.service.DisenoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disenos")
public class DisenoController {

    private final DisenoService disenoService;

    public DisenoController(DisenoService disenoService) {
        this.disenoService = disenoService;
    }

    @PostMapping
    public Diseno crearDiseno(@RequestBody Diseno diseno) {
        return disenoService.crearDiseno(diseno);
    }

    @GetMapping
    public List<Diseno> obtenerTodos() {
        return disenoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Diseno obtenerPorId(@PathVariable Long id) {
        return disenoService.obtenerPorId(id);
    }
}
