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
    public List<Material> listar() {
        return repository.findAll();
    }

    @Override
    public Material guardar(Material material) {
        return repository.findByNombreIgnoreCase(material.getNombre())
                .map(existing -> {
                    existing.setCantidad(existing.getCantidad() + material.getCantidad());
                    return repository.save(existing);
                })
                .orElse(repository.save(material));
    }

    @Override
    public Material actualizar(Long id, Material material) {
        Material mat = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Material no encontrado"));
        mat.setNombre(material.getNombre());
        mat.setTipo(material.getTipo());
        mat.setUnidad(material.getUnidad());
        mat.setCantidad(material.getCantidad());
        return repository.save(mat);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
