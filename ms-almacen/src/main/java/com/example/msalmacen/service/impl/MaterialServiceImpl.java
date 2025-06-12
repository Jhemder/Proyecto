package com.example.msalmacen.service.impl;

import com.example.msalmacen.entity.Material;
import com.example.msalmacen.repository.MaterialRepository;
import com.example.msalmacen.service.MaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MaterialServiceImpl implements MaterialService {
    private final MaterialRepository repo;

    @Override
    public Material save(Material m) {
        return repo.findByNombreAndTipoAndUnidad(m.getNombre(), m.getTipo(), m.getUnidad())
                .map(existing -> {
                    existing.setCantidad(existing.getCantidad() + m.getCantidad());
                    return repo.save(existing);
                }).orElse(repo.save(m));
    }

    @Override
    public List<Material> findAll() {
        return repo.findAll();
    }
}
