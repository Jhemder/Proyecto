package com.example.msalmacen.service;

import com.example.msalmacen.dto.MaterialDTO;
import com.example.msalmacen.entity.Material;

import java.util.List;

public interface MaterialService {
    Material crearOActualizarMaterial(MaterialDTO dto);
    List<Material> listarMateriales();
}
