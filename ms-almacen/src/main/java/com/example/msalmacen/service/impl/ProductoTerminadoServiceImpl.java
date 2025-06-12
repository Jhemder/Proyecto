package com.example.msalmacen.service.impl;

import com.example.msalmacen.dto.MaterialUsoDTO;
import com.example.msalmacen.dto.ProductoTerminadoDTO;
import com.example.msalmacen.entity.Material;
import com.example.msalmacen.entity.MaterialUso;
import com.example.msalmacen.entity.ProductoTerminado;
import com.example.msalmacen.repository.MaterialRepository;
import com.example.msalmacen.repository.MaterialUsoRepository;
import com.example.msalmacen.repository.ProductoTerminadoRepository;
import com.example.msalmacen.service.ProductoTerminadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoTerminadoServiceImpl implements ProductoTerminadoService {

    private final ProductoTerminadoRepository productoRepo;
    private final MaterialRepository materialRepo;
    private final MaterialUsoRepository materialUsoRepo;

    @Override
    public ProductoTerminado crearProductoTerminado(ProductoTerminadoDTO dto) {
        List<MaterialUso> materialesUsados = new ArrayList<>();

        for (MaterialUsoDTO usoDTO : dto.getMaterialesUsados()) {
            Material material = materialRepo.findById(usoDTO.getMaterialId())
                    .orElseThrow(() -> new RuntimeException("Material no encontrado con ID: " + usoDTO.getMaterialId()));

            if (material.getCantidad() < usoDTO.getCantidadUsada()) {
                throw new RuntimeException("Stock insuficiente para el material: " + material.getNombre());
            }

            // Descontamos el stock
            material.setCantidad(material.getCantidad() - usoDTO.getCantidadUsada());
            materialRepo.save(material);

            MaterialUso uso = MaterialUso.builder()
                    .material(material)
                    .cantidadUsada(usoDTO.getCantidadUsada())
                    .build();

            materialesUsados.add(uso);
        }

        ProductoTerminado producto = ProductoTerminado.builder()
                .nombre(dto.getNombre())
                .descripcion(dto.getDescripcion())
                .materialesUsados(new ArrayList<>())
                .build();

        ProductoTerminado productoGuardado = productoRepo.save(producto);

        for (MaterialUso uso : materialesUsados) {
            uso.setProducto(productoGuardado);
            materialUsoRepo.save(uso);
        }

        productoGuardado.setMaterialesUsados(materialUsoRepo.findByProductoId(productoGuardado.getId()));
        return productoGuardado;
    }

    @Override
    public List<ProductoTerminado> listarProductosTerminados() {
        return productoRepo.findAll();
    }
}
