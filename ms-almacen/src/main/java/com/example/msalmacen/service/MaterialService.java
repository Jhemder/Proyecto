package com.example.msalmacen.service;

import com.example.msalmacen.entity.Material;
import java.util.List;

public interface MaterialService {
    Material save(Material material);
    List<Material> findAll();
}
