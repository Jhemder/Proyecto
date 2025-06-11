package com.example.msalmacen.service;

import com.example.msalmacen.entity.Material;
import com.example.msalmacen.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    public Material agregarMaterial(Material nuevo) {
        return materialRepository.findByNombreAndTipoAndColor(
                nuevo.getNombre(), nuevo.getTipo(), nuevo.getColor()
        ).map(existente -> {
            existente.setCantidad(existente.getCantidad() + nuevo.getCantidad());
            return materialRepository.save(existente);
        }).orElseGet(() -> materialRepository.save(nuevo));
    }

    public List<Material> listarMateriales() {
        return materialRepository.findAll();
    }

    public void eliminarMaterial(Long id) {
        materialRepository.deleteById(id);
    }

    public Material actualizarMaterial(Long id, Material material) {
        material.setId(id);
        return materialRepository.save(material);
    }

    public Material obtenerPorId(Long id) {
        return materialRepository.findById(id).orElse(null);
    }

    public boolean descontarMaterial(String nombre, String tipo, String color, double cantidadUsada) {
        return materialRepository.findByNombreAndTipoAndColor(nombre, tipo, color).map(material -> {
            if (material.getCantidad() >= cantidadUsada) {
                material.setCantidad(material.getCantidad() - cantidadUsada);
                materialRepository.save(material);
                return true;
            } else {
                return false;
            }
        }).orElse(false);
    }
}
