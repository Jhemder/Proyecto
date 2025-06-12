package com.example.msalmacen.service;

import com.example.msalmacen.entity.Material;
import java.util.List;

public interface MaterialService {
    List<Material> listar();
    Material guardar(Material material);
    Material actualizar(Long id, Material material);
    void eliminar(Long id);
}
