package com.example.msalmacen.service;

import com.example.msalmacen.entity.ProductoTerminado;

import java.util.List;

public interface ProductoTerminadoService {
    List<ProductoTerminado> listar();
    ProductoTerminado guardar(ProductoTerminado producto);
    ProductoTerminado actualizar(Long id, ProductoTerminado producto);
    void eliminar(Long id);
}
