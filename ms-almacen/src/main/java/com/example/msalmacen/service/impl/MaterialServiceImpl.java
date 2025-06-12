package com.example.msalmacen.service.impl;

import com.example.msalmacen.dto.MaterialDTO;
import com.example.msalmacen.entity.Material;
import com.example.msalmacen.repository.MaterialRepository;
import com.example.msalmacen.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    @Override
    public List<MaterialDTO> listarMateriales() {
        return materialRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MaterialDTO obtenerMaterialPorId(Long id) {
        return materialRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    @Override
    public MaterialDTO registrarMaterial(MaterialDTO materialDTO) {
        Material material = new Material();
        material.setNombre(materialDTO.getNombre());
        material.setDescripcion(materialDTO.getDescripcion());
        return convertToDTO(materialRepository.save(material));
    }

    private MaterialDTO convertToDTO(Material material) {
        MaterialDTO dto = new MaterialDTO();
        dto.setId(material.getId());
        dto.setNombre(material.getNombre());
        dto.setDescripcion(material.getDescripcion());
        return dto;
    }
}
