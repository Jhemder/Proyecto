package com.example.msproductoterminadoservice.service.impl;

import com.example.msproductoterminadoservice.dto.OrdenFabricacionRequest;
import com.example.msproductoterminadoservice.dto.MaterialDTO;
import com.example.msproductoterminadoservice.entity.DetalleOrden;
import com.example.msproductoterminadoservice.entity.OrdenFabricacion;
import com.example.msproductoterminadoservice.feign.AlmacenFeignClient;
import com.example.msproductoterminadoservice.repository.OrdenFabricacionRepository;
import com.example.msproductoterminadoservice.service.OrdenFabricacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrdenFabricacionServiceImpl implements OrdenFabricacionService {

    private final OrdenFabricacionRepository ordenRepo;
    private final AlmacenFeignClient almacenFeign;

    @Override
    public OrdenFabricacion crearOrdenFabricacion(OrdenFabricacionRequest request) {
        OrdenFabricacion orden = OrdenFabricacion.builder()
                .tipoPrenda(request.getTipoPrenda())
                .cantidad(request.getCantidad())
                .fechaFabricacion(LocalDate.now())
                .build();

        List<DetalleOrden> detalles = request.getMateriales().stream().map(m -> DetalleOrden.builder()
                .nombreMaterial(m.getNombreMaterial())
                .unidad(m.getUnidad())
                .cantidadUtilizada(m.getCantidadUtilizada())
                .ordenFabricacion(orden)
                .build()
        ).collect(Collectors.toList());

        orden.setDetalles(detalles);

        // Descontar del almacén vía Feign
        almacenFeign.descontarMateriales(request.getMateriales());

        return ordenRepo.save(orden);
    }
}
