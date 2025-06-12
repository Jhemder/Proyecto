package com.example.msalmacen.service.impl;

import com.example.msalmacen.entity.Material;
import com.example.msalmacen.entity.MaterialUtilizado;
import com.example.msalmacen.entity.ProductoTerminado;
import com.example.msalmacen.repository.MaterialRepository;
import com.example.msalmacen.repository.ProductoTerminadoRepository;
import com.example.msalmacen.service.ProductoTerminadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoTerminadoServiceImpl implements ProductoTerminadoService {
    private final ProductoTerminadoRepository prodRepo;
    private final MaterialRepository matRepo;

    @Override
    public ProductoTerminado fabricar(ProductoTerminado p) {
        LocalDate hoy = LocalDate.now();
        p.setFechaFabricacion(hoy);

        // Verificar/add existente
        ProductoTerminado almacenado = prodRepo.findByNombreAndFechaFabricacion(p.getNombre(), hoy)
                .map(existing -> {
                    // Verificar stock
                    for (MaterialUtilizado mu : p.getMaterialesUtilizados()) {
                        double req = mu.getCantidad() * p.getCantidadFabricada();
                        Material mat = matRepo.findByNombreAndTipoAndUnidad(mu.getNombre(), mu.getTipo(), mu.getUnidad())
                                .orElseThrow(() -> new RuntimeException("Material no existe"));
                        if (mat.getCantidad() < req) {
                            throw new RuntimeException("Stock insuficiente: " + mu.getNombre());
                        }
                    }
                    // descontar
                    for (MaterialUtilizado mu : p.getMaterialesUtilizados()) {
                        double req = mu.getCantidad() * p.getCantidadFabricada();
                        Material mat = matRepo.findByNombreAndTipoAndUnidad(mu.getNombre(), mu.getTipo(), mu.getUnidad()).get();
                        mat.setCantidad(mat.getCantidad() - req);
                        matRepo.save(mat);
                    }

                    existing.setCantidadFabricada(existing.getCantidadFabricada() + p.getCantidadFabricada());
                    return prodRepo.save(existing);
                }).orElseGet(() -> {
                    // nuevo
                    for (MaterialUtilizado mu : p.getMaterialesUtilizados()) {
                        double req = mu.getCantidad() * p.getCantidadFabricada();
                        Material mat = matRepo.findByNombreAndTipoAndUnidad(mu.getNombre(), mu.getTipo(), mu.getUnidad())
                                .orElseThrow(() -> new RuntimeException("Material no existe"));
                        if (mat.getCantidad() < req) {
                            throw new RuntimeException("Stock insuficiente: " + mu.getNombre());
                        }
                        mat.setCantidad(mat.getCantidad() - req);
                        matRepo.save(mat);
                    }
                    return prodRepo.save(p);
                });

        return almacenado;
    }

    @Override
    public List<ProductoTerminado> listarTodos() {
        return prodRepo.findAll();
    }

    @Override
    public List<ProductoTerminado> listarPorMes(int year, int month) {
        LocalDate start = LocalDate.of(year, month, 1);
        LocalDate end = start.withDayOfMonth(start.lengthOfMonth());
        return prodRepo.findByFechaFabricacionBetween(start, end);
    }
}
