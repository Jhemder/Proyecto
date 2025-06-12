package com.example.msalmacen.service;

import com.example.msalmacen.dto.MaterialRequestDTO;
import com.example.msalmacen.dto.MaterialResponseDTO;

import java.util.List;

public interface MaterialService {
    MaterialResponseDTO agregar(MaterialRequestDTO dto);
    MaterialResponseDTO actualizar(Long id, MaterialRequestDTO dto);
    void eliminar(Long id);
    List<MaterialResponseDTO> listar();
    MaterialResponseDTO obtenerPorId(Long id);

    // Método para descontar material
    boolean descontarMaterial(String nombre, String tipo, String color, double cantidad);
    boolean descontarMateriales(List<MaterialRequestDTO> materiales); // nuevo método



}
