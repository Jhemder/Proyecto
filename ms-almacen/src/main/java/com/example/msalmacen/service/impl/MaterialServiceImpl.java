package com.example.msalmacen.service.impl;

import com.example.msalmacen.dto.MaterialRequestDTO;
import com.example.msalmacen.dto.MaterialResponseDTO;
import com.example.msalmacen.entity.Material;
import com.example.msalmacen.repository.MaterialRepository;
import com.example.msalmacen.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private MaterialRepository repository;

    @Override
    public MaterialResponseDTO agregar(MaterialRequestDTO dto) {
        Material material = Material.builder()
                .nombre(dto.getNombre())
                .tipo(dto.getTipo())
                .color(dto.getColor())
                .unidadMedida(dto.getUnidadMedida())
                .cantidad(dto.getCantidad())
                .costoUnitario(dto.getCostoUnitario())
                .proveedor(dto.getProveedor())
                .build();
        return toDto(repository.save(material));
    }

    @Override
    public MaterialResponseDTO actualizar(Long id, MaterialRequestDTO dto) {
        Material material = repository.findById(id).orElseThrow();
        material.setNombre(dto.getNombre());
        material.setTipo(dto.getTipo());
        material.setColor(dto.getColor());
        material.setUnidadMedida(dto.getUnidadMedida());
        material.setCantidad(dto.getCantidad());
        material.setCostoUnitario(dto.getCostoUnitario());
        material.setProveedor(dto.getProveedor());
        return toDto(repository.save(material));
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<MaterialResponseDTO> listar() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public MaterialResponseDTO obtenerPorId(Long id) {
        return toDto(repository.findById(id).orElseThrow());
    }

    @Override
    public boolean descontarMaterial(String nombre, String tipo, String color, double cantidad) {
        Optional<Material> optional = repository.findByNombreAndTipoAndColor(nombre, tipo, color);
        if (optional.isPresent()) {
            Material material = optional.get();
            if (material.getCantidad() >= cantidad) {
                material.setCantidad(material.getCantidad() - cantidad);
                repository.save(material);
                return true;
            }
        }
        return false;
    }

    private MaterialResponseDTO toDto(Material material) {
        return MaterialResponseDTO.builder()
                .id(material.getId())
                .nombre(material.getNombre())
                .tipo(material.getTipo())
                .color(material.getColor())
                .unidadMedida(material.getUnidadMedida())
                .cantidad(material.getCantidad())
                .costoUnitario(material.getCostoUnitario())
                .proveedor(material.getProveedor())
                .build();
    }
}
