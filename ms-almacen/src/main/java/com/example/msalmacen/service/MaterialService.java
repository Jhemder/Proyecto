package com.example.msalmacen.service;

import com.example.msalmacen.entity.Material;

import java.util.List;

public interface MaterialService {

    List<Material> findAll();

    Material findById(Long id);

    Material save(Material material);

    void delete(Long id);

    void descontarMaterial(Long id, double cantidad);
}
