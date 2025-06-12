package com.example.msalmacen.service.impl;

import com.example.msalmacen.entity.Material;
import com.example.msalmacen.entity.MaterialUtilizado;
import com.example.msalmacen.entity.ProductoTerminado;
import com.example.msalmacen.repository.MaterialRepository;
import com.example.msalmacen.repository.ProductoTerminadoRepository;
import com.example.msalmacen.service.ProductoTerminadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoTerminadoServiceImpl implements ProductoTerminadoService {

    private final ProductoTerminadoRepository productoRepo;
    private final MaterialRepository materialRepo;

    @Override
    public List<ProductoTerminado> listar() {
        return productoRepo.findAll();
    }

    @Override
    public ProductoTerminado crear(ProductoTerminado producto) {
        // Verificar y descontar materiales
        for (MaterialUtilizado usado : producto.getMaterialesUtilizados()) {
            Material mat = materialRepo.findByNombreIgnoreCase(usado.getNombre())
                    .orElseThrow(() -> new RuntimeException("Material no encontrado: " + usado.getNombre()));

            double requerido = usado.getCantidad() * producto.getCantidadFabricada();
            if (mat.getCantidad() < requerido) {
                throw new RuntimeException("Stock insuficiente para: " + usado.getNombre());
            }

            mat.setCantidad(mat.getCantidad() - requerido);
            materialRepo.save(mat);
        }

        return productoRepo.save(producto);
    }

    @Override
    public void eliminar(Long id) {
        productoRepo.deleteById(id);
    }
}
