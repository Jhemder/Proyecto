package com.example.msalmacenservice.service.impl;

import com.example.msalmacenservice.entity.Material;
import com.example.msalmacenservice.repository.MaterialRepository;
import com.example.msalmacenservice.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    @Override
    public List<Material> listarTodos() {
        return materialRepository.findAll();
    }

    @Override
    public Optional<Material> obtenerPorId(Long id) {
        return materialRepository.findById(id);
    }

    @Override
    public Material guardar(Material material) {
        return materialRepository.save(material);
    }

    @Override
    public Material actualizar(Long id, Material material) {
        return materialRepository.findById(id).map(existing -> {
            existing.setNombreMaterial(material.getNombreMaterial());
            existing.setTipoMaterial(material.getTipoMaterial());
            existing.setComposicion(material.getComposicion());
            existing.setPropiedadesClave(material.getPropiedadesClave());
            existing.setUsosComunes(material.getUsosComunes());
            existing.setRequiereMezcla(material.getRequiereMezcla());
            existing.setProveedoresSugeridos(material.getProveedoresSugeridos());
            existing.setCostoUnitarioAprox(material.getCostoUnitarioAprox());
            existing.setUnidadMedida(material.getUnidadMedida());
            existing.setNotasAdicionales(material.getNotasAdicionales());
            return materialRepository.save(existing);
        }).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        materialRepository.deleteById(id);
    }
}
