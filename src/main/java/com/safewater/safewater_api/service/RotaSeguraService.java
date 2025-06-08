package com.safewater.safewater_api.service;

import com.safewater.safewater_api.dto.RotaSeguraDTO;
import com.safewater.safewater_api.model.AreaDeRisco;
import com.safewater.safewater_api.model.RotaSegura;
import com.safewater.safewater_api.repository.AreaDeRiscoRepository;
import com.safewater.safewater_api.repository.RotaSeguraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RotaSeguraService {

    @Autowired
    private RotaSeguraRepository repository;

    @Autowired
    private AreaDeRiscoRepository areaRepository;

    public List<RotaSeguraDTO> buscarTodas() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<RotaSegura> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public RotaSeguraDTO salvar(RotaSeguraDTO dto) {
        RotaSegura rota = new RotaSegura();
        rota.setOrigem(dto.getOrigem());
        rota.setDestino(dto.getDestino());
        rota.setInstrucoes(dto.getInstrucoes());

        if (dto.getAreaId() != null) {
            areaRepository.findById(dto.getAreaId()).ifPresent(rota::setArea);
        }

        return toDTO(repository.save(rota));
    }

    public RotaSeguraDTO atualizar(Long id, RotaSeguraDTO dto) {
        Optional<RotaSegura> optRota = repository.findById(id);
        if (optRota.isEmpty()) return null;

        RotaSegura rota = optRota.get();
        rota.setOrigem(dto.getOrigem());
        rota.setDestino(dto.getDestino());
        rota.setInstrucoes(dto.getInstrucoes());

        if (dto.getAreaId() != null) {
            areaRepository.findById(dto.getAreaId()).ifPresent(rota::setArea);
        } else {
            rota.setArea(null);
        }

        return toDTO(repository.save(rota));
    }

    public boolean deletar(Long id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }

    public RotaSeguraDTO toDTO(RotaSegura rota) {
        RotaSeguraDTO dto = new RotaSeguraDTO();
        dto.setId(rota.getId());
        dto.setOrigem(rota.getOrigem());
        dto.setDestino(rota.getDestino());
        dto.setInstrucoes(rota.getInstrucoes());

        if (rota.getArea() != null) {
            dto.setAreaId(rota.getArea().getId());
        }

        return dto;
    }
}
