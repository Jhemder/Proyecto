package com.example.msalmacen.service.impl;

import com.example.msalmacen.entity.ProductoTerminado;
import com.example.msalmacen.repository.ProductoTerminadoRepository;
import com.example.msalmacen.service.ProductoTerminadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoTerminadoServiceImpl implements ProductoTerminadoService {

    private final ProductoTerminadoRepository repository;

    @Override
    public List<ProductoTerminado> listar() {
        return repository.findAll();
    }

    @Override
    public ProductoTerminado guardar(ProductoTerminado producto) {
        return repository
                .findByNombreIgnoreCaseAndCategoriaIgnoreCaseAndUnidadIgnoreCase(
                        producto.getNombre(), producto.getCategoria(), producto.getUnidad()
                )
                .map(existing -> {
                    existing.setCantidad(existing.getCantidad() + producto.getCantidad());
                    return repository.save(existing);
                })
                .orElseGet(() -> {
                    producto.setFechaRegistro(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
                    return repository.save(producto);
                });
    }

    @Override
    public ProductoTerminado actualizar(Long id, ProductoTerminado producto) {
        ProductoTerminado prod = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto terminado no encontrado"));
        prod.setNombre(producto.getNombre());
        prod.setCategoria(producto.getCategoria());
        prod.setUnidad(producto.getUnidad());
        prod.setCantidad(producto.getCantidad());
        return repository.save(prod);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
