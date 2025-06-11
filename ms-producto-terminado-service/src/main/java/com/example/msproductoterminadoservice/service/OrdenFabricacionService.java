package com.example.msproductoterminadoservice.service;

import com.example.msproductoterminadoservice.dto.OrdenFabricacionRequest;
import com.example.msproductoterminadoservice.entity.OrdenFabricacion;

public interface OrdenFabricacionService {
    OrdenFabricacion crearOrdenFabricacion(OrdenFabricacionRequest request);
}
