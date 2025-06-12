package com.example.msalmacen.service;

import com.example.msalmacen.entity.ProductoTerminado;
import java.util.List;

public interface ProductoTerminadoService {
    ProductoTerminado fabricar(ProductoTerminado producto);
    List<ProductoTerminado> listarTodos();
    List<ProductoTerminado> listarPorMes(int year, int month);
}
