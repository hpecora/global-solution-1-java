package com.safewater.safewater_api.service;

import com.safewater.safewater_api.dto.AreaDeRiscoDTO;
import com.safewater.safewater_api.model.AreaDeRisco;
import com.safewater.safewater_api.repository.AreaDeRiscoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AreaDeRiscoService {

    @Autowired
    private AreaDeRiscoRepository repository;

    public List<AreaDeRiscoDTO> buscarTodas() {
        List<AreaDeRisco> areas = repository.findAll();
        return areas.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<AreaDeRisco> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public AreaDeRiscoDTO salvar(AreaDeRiscoDTO dto) {
        AreaDeRisco area = new AreaDeRisco();
        area.setNome(dto.getNome());
        area.setBairro(dto.getBairro());
        area.setNivelRisco(dto.getNivelRisco());
        area.setStatus(dto.getStatus());
        area.setLatitude(dto.getLatitude());
        area.setLongitude(dto.getLongitude());
        area = repository.save(area);
        return toDTO(area);
    }

    public AreaDeRiscoDTO atualizar(Long id, AreaDeRiscoDTO dto) {
        Optional<AreaDeRisco> optArea = repository.findById(id);
        if (optArea.isEmpty()) {
            return null;
        }
        AreaDeRisco area = optArea.get();
        area.setNome(dto.getNome());
        area.setBairro(dto.getBairro());
        area.setNivelRisco(dto.getNivelRisco());
        area.setStatus(dto.getStatus());
        area.setLatitude(dto.getLatitude());
        area.setLongitude(dto.getLongitude());
        area = repository.save(area);
        return toDTO(area);
    }

    public boolean deletar(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }

    public AreaDeRiscoDTO toDTO(AreaDeRisco area) {
        AreaDeRiscoDTO dto = new AreaDeRiscoDTO();
        dto.setId(area.getId());
        dto.setNome(area.getNome());
        dto.setBairro(area.getBairro());
        dto.setNivelRisco(area.getNivelRisco());
        dto.setStatus(area.getStatus());
        dto.setLatitude(area.getLatitude());
        dto.setLongitude(area.getLongitude());
        return dto;
    }
}
