package com.example.msalmacen.service;

import com.example.msalmacen.dto.ProductoTerminadoDTO;

import java.util.List;

public interface ProductoTerminadoService {
    List<ProductoTerminadoDTO> listarProductosTerminados();
    ProductoTerminadoDTO obtenerProductoTerminadoPorId(Long id);
    ProductoTerminadoDTO registrarProductoTerminado(ProductoTerminadoDTO productoDTO);
}
