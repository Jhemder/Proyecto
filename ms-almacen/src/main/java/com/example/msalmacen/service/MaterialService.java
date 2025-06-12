package com.example.msalmacen.service;

import com.example.msalmacen.dto.MaterialDTO;

import java.util.List;

public interface MaterialService {
    List<MaterialDTO> listarMateriales();
    MaterialDTO obtenerMaterialPorId(Long id);
    MaterialDTO registrarMaterial(MaterialDTO materialDTO);
}
