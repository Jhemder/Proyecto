package com.example.msalmacen.service;

import com.example.msalmacen.dto.ProductoTerminadoDTO;
import com.example.msalmacen.entity.ProductoTerminado;

import java.util.List;

public interface ProductoTerminadoService {
    ProductoTerminado crearProductoTerminado(ProductoTerminadoDTO dto);
    List<ProductoTerminado> listarProductosTerminados();
}
