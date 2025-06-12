package com.example.msalmacen.service.impl;

import com.example.msalmacen.dto.MaterialDTO;
import com.example.msalmacen.entity.Material;
import com.example.msalmacen.repository.MaterialRepository;
import com.example.msalmacen.service.MaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MaterialServiceImpl implements MaterialService {

    private final MaterialRepository materialRepository;

    @Override
    public Material crearOActualizarMaterial(MaterialDTO dto) {
        return materialRepository.findByNombreIgnoreCase(dto.getNombre())
                .map(materialExistente -> {
                    materialExistente.setCantidad(materialExistente.getCantidad() + dto.getCantidad());
                    return materialRepository.save(materialExistente);
                })
                .orElseGet(() -> {
                    Material nuevo = Material.builder()
                            .nombre(dto.getNombre())
                            .tipo(dto.getTipo())
                            .unidadMedida(dto.getUnidadMedida())
                            .cantidad(dto.getCantidad())
                            .build();
                    return materialRepository.save(nuevo);
                });
    }

    @Override
    public List<Material> listarMateriales() {
        return materialRepository.findAll();
    }
}
