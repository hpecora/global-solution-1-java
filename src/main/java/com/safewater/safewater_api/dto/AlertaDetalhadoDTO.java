package com.safewater.safewater_api.dto;

import java.time.LocalDateTime;

public class AlertaDetalhadoDTO {
    private Long id;
    private String descricao;
    private String tipo;
    private String status;
    private Double nivelAgua;
    private LocalDateTime dataHora;
    private AreaDeRiscoDTO area;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Double getNivelAgua() { return nivelAgua; }
    public void setNivelAgua(Double nivelAgua) { this.nivelAgua = nivelAgua; }

    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }

    public AreaDeRiscoDTO getArea() { return area; }
    public void setArea(AreaDeRiscoDTO area) { this.area = area; }
}
