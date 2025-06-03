package com.safewater.safewater_api.service;

import com.safewater.safewater_api.dto.AreaDeRiscoDTO;
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
        List<RotaSegura> rotas = repository.findAll();
        return rotas.stream()
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

        if (dto.getArea() != null && dto.getArea().getId() != null) {
            Optional<AreaDeRisco> area = areaRepository.findById(dto.getArea().getId());
            area.ifPresent(rota::setArea);
        } else {
            rota.setArea(null);
        }

        rota = repository.save(rota);
        return toDTO(rota);
    }

    public RotaSeguraDTO atualizar(Long id, RotaSeguraDTO dto) {
        Optional<RotaSegura> optRota = repository.findById(id);
        if (optRota.isEmpty()) {
            return null;
        }
        RotaSegura rota = optRota.get();
        rota.setOrigem(dto.getOrigem());
        rota.setDestino(dto.getDestino());
        rota.setInstrucoes(dto.getInstrucoes());

        if (dto.getArea() != null && dto.getArea().getId() != null) {
            Optional<AreaDeRisco> area = areaRepository.findById(dto.getArea().getId());
            area.ifPresent(rota::setArea);
        } else {
            rota.setArea(null);
        }

        rota = repository.save(rota);
        return toDTO(rota);
    }

    public boolean deletar(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
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
            AreaDeRisco area = rota.getArea();
            AreaDeRiscoDTO areaDTO = new AreaDeRiscoDTO();
            areaDTO.setId(area.getId());
            areaDTO.setNome(area.getNome());
            areaDTO.setBairro(area.getBairro());
            areaDTO.setNivelRisco(area.getNivelRisco());
            areaDTO.setStatus(area.getStatus());
            dto.setArea(areaDTO);
        } else {
            dto.setArea(null);
        }
        return dto;
    }
}
