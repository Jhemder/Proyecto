package com.example.msdiseno.service.impl;

import com.example.msdiseno.client.AlmacenClient;
import com.example.msdiseno.dto.DescuentoMaterialDTO;
import com.example.msdiseno.entity.Diseno;
import com.example.msdiseno.entity.MaterialUsado;
import com.example.msdiseno.repository.DisenoRepository;
import com.example.msdiseno.repository.MaterialUsadoRepository;
import com.example.msdiseno.service.DisenoService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DisenoServiceImpl implements DisenoService {

    private final DisenoRepository disenoRepository;
    private final MaterialUsadoRepository materialUsadoRepository;
    private final AlmacenClient almacenClient;

    public DisenoServiceImpl(DisenoRepository disenoRepository,
                             MaterialUsadoRepository materialUsadoRepository,
                             AlmacenClient almacenClient) {
        this.disenoRepository = disenoRepository;
        this.materialUsadoRepository = materialUsadoRepository;
        this.almacenClient = almacenClient;
    }

    @Override
    public Diseno crearDiseno(Diseno diseno) {
        // Guardamos primero el diseño sin los materiales
        Diseno disenoGuardado = disenoRepository.save(diseno);

        // Asociamos cada material al diseño y lo guardamos
        for (MaterialUsado material : diseno.getMaterialesUsados()) {
            material.setDiseno(disenoGuardado);
            materialUsadoRepository.save(material);
        }

        // Enviamos a ms-almacen la solicitud de descuento de stock
        List<DescuentoMaterialDTO> descuentos = diseno.getMaterialesUsados().stream()
                .map(m -> new DescuentoMaterialDTO(m.getIdMaterial(), m.getCantidadNecesaria()))
                .collect(Collectors.toList());

        almacenClient.descontarMateriales(descuentos);

        return disenoGuardado;
    }

    @Override
    public List<Diseno> obtenerTodos() {
        return disenoRepository.findAll();
    }

    @Override
    public Diseno obtenerPorId(Long id) {
        return disenoRepository.findById(id).orElse(null);
    }
}
