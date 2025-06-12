package com.example.msdiseno.service;

import com.example.msdiseno.entity.Diseno;

import java.util.List;

public interface DisenoService {
    Diseno crearDiseno(Diseno diseno);
    List<Diseno> obtenerTodos();
    Diseno obtenerPorId(Long id);
}
