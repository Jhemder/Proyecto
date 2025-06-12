package com.example.msalmacenservice.service;

import com.example.msalmacenservice.entity.Material;

import java.util.List;
import java.util.Optional;

public interface MaterialService {

    List<Material> listarTodos();
    Optional<Material> obtenerPorId(Long id);
    Material guardar(Material material);
    Material actualizar(Long id, Material material);
    void eliminar(Long id);
}
