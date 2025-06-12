package com.example.msalmacen.service.impl;

import com.example.msalmacen.dto.MaterialDTO;
import com.example.msalmacen.dto.ProductoTerminadoDTO;
import com.example.msalmacen.entity.Material;
import com.example.msalmacen.entity.ProductoTerminado;
import com.example.msalmacen.repository.MaterialRepository;
import com.example.msalmacen.repository.ProductoTerminadoRepository;
import com.example.msalmacen.service.ProductoTerminadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductoTerminadoServiceImpl implements ProductoTerminadoService {

    private final ProductoTerminadoRepository productoRepository;
    private final MaterialRepository materialRepository;

    @Override
    public List<ProductoTerminadoDTO> listarProductos() {
        return productoRepository.findAll().stream().map(producto -> {
            ProductoTerminadoDTO dto = new ProductoTerminadoDTO();
            dto.setId(producto.getId());
            dto.setNombre(producto.getNombre());
            dto.setDescripcion(producto.getDescripcion());
            dto.setMaterialesUsados(
                    producto.getMaterialesUsados().stream()
                            .map(mat -> new MaterialDTO(mat.getId(), mat.getNombre(), mat.getTipo()))
                            .collect(Collectors.toList())
            );
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public ProductoTerminadoDTO guardarProducto(ProductoTerminadoDTO dto) {
        ProductoTerminado producto = new ProductoTerminado();
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());

        // Extraer IDs
        List<Long> materialIds = dto.getMaterialesUsados().stream()
                .map(MaterialDTO::getId)
                .collect(Collectors.toList());

        // Buscar entidades por ID
        List<Material> materiales = materialRepository.findAllById(materialIds);
        producto.setMaterialesUsados(materiales);

        // Guardar producto
        ProductoTerminado saved = productoRepository.save(producto);

        // Retornar DTO actualizado
        dto.setId(saved.getId());
        return dto;
    }

    @Override
    public Optional<ProductoTerminadoDTO> obtenerProductoPorId(Long id) {
        return productoRepository.findById(id).map(producto -> {
            ProductoTerminadoDTO dto = new ProductoTerminadoDTO();
            dto.setId(producto.getId());
            dto.setNombre(producto.getNombre());
            dto.setDescripcion(producto.getDescripcion());
            dto.setMaterialesUsados(
                    producto.getMaterialesUsados().stream()
                            .map(mat -> new MaterialDTO(mat.getId(), mat.getNombre(), mat.getTipo()))
                            .collect(Collectors.toList())
            );
            return dto;
        });
    }

    @Override
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
}
