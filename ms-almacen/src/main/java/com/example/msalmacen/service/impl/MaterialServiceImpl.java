package com.example.msalmacen.service.impl;

import com.example.msalmacen.entity.Material;
import com.example.msalmacen.repository.MaterialRepository;
import com.example.msalmacen.service.MaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MaterialServiceImpl implements MaterialService {

    private final MaterialRepository repository;

    @Override
    public List<Material> findAll() {
        return repository.findAll();
    }

    @Override
    public Material findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Material no encontrado"));
    }

    @Override
    public Material save(Material material) {
        return repository.save(material);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void descontarMaterial(Long id, double cantidad) {
        Material material = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Material no encontrado"));

        if (material.getStockDisponible() == null) {
            material.setStockDisponible(0.0);
        }

        if (material.getStockDisponible() < cantidad) {
            throw new RuntimeException("Stock insuficiente para el material ID " + id);
        }

        material.setStockDisponible(material.getStockDisponible() - cantidad);
        repository.save(material);
    }
}
