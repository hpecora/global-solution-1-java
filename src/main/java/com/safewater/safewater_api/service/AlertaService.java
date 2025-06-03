package com.safewater.safewater_api.service;

import com.safewater.safewater_api.dto.AlertaDTO;
import com.safewater.safewater_api.model.Alerta;
import com.safewater.safewater_api.model.AreaDeRisco;
import com.safewater.safewater_api.repository.AlertaRepository;
import com.safewater.safewater_api.repository.AreaDeRiscoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlertaService {

    @Autowired
    private AlertaRepository alertaRepository;

    @Autowired
    private AreaDeRiscoRepository areaRepository;

    public List<Alerta> buscarTodos() {
        return alertaRepository.findAll();
    }

    public Optional<Alerta> buscarPorId(Long id) {
        return alertaRepository.findById(id);
    }

    public Alerta salvar(AlertaDTO dto) {
        Alerta alerta = new Alerta();
        alerta.setDescricao(dto.getDescricao());
        alerta.setTipo(dto.getTipo());
        alerta.setStatus(dto.getStatus());
        alerta.setNivelAgua(dto.getNivelAgua());
        alerta.setDataHora(dto.getDataHora());

        AreaDeRisco area = areaRepository.findById(dto.getAreaId())
                .orElseThrow(() -> new RuntimeException("Área de risco não encontrada"));
        alerta.setArea(area);

        return alertaRepository.save(alerta);
    }

    public Alerta atualizar(Long id, AlertaDTO dto) {
        return alertaRepository.findById(id).map(alerta -> {
            alerta.setDescricao(dto.getDescricao());
            alerta.setTipo(dto.getTipo());
            alerta.setStatus(dto.getStatus());
            alerta.setNivelAgua(dto.getNivelAgua());
            alerta.setDataHora(dto.getDataHora());

            AreaDeRisco area = areaRepository.findById(dto.getAreaId())
                    .orElseThrow(() -> new RuntimeException("Área de risco não encontrada"));
            alerta.setArea(area);

            return alertaRepository.save(alerta);
        }).orElse(null);
    }

    public boolean deletar(Long id) {
        Optional<Alerta> alerta = alertaRepository.findById(id);
        if (alerta.isPresent()) {
            alertaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
