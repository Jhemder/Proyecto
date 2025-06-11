package com.example.msalmacen.service.impl;

import com.example.msalmacen.dto.MaterialRequestDTO;
import com.example.msalmacen.dto.MaterialResponseDTO;
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
    private MaterialRepository repository;

    private MaterialResponseDTO toDTO(Material material) {
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

    private Material toEntity(MaterialRequestDTO dto) {
        return Material.builder()
                .nombre(dto.getNombre())
                .tipo(dto.getTipo())
                .color(dto.getColor())
                .unidadMedida(dto.getUnidadMedida())
                .cantidad(dto.getCantidad())
                .costoUnitario(dto.getCostoUnitario())
                .proveedor(dto.getProveedor())
                .build();
    }

    @Override
    public MaterialResponseDTO agregar(MaterialRequestDTO dto) {
        return repository.findByNombreAndTipoAndColor(dto.getNombre(), dto.getTipo(), dto.getColor())
                .map(existente -> {
                    existente.setCantidad(existente.getCantidad() + dto.getCantidad());
                    return toDTO(repository.save(existente));
                })
                .orElseGet(() -> toDTO(repository.save(toEntity(dto))));
    }

    @Override
    public MaterialResponseDTO actualizar(Long id, MaterialRequestDTO dto) {
        Material material = toEntity(dto);
        material.setId(id);
        return toDTO(repository.save(material));
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<MaterialResponseDTO> listar() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public MaterialResponseDTO obtenerPorId(Long id) {
        return repository.findById(id).map(this::toDTO).orElse(null);
    }

    @Override
    public boolean descontarMaterial(String nombre, String tipo, String color, double cantidad) {
        return repository.findByNombreAndTipoAndColor(nombre, tipo, color).map(material -> {
            if (material.getCantidad() >= cantidad) {
                material.setCantidad(material.getCantidad() - cantidad);
                repository.save(material);
                return true;
            }
            return false;
        }).orElse(false);
    }
}
