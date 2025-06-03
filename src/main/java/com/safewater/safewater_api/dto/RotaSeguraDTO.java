package com.safewater.safewater_api.dto;

public class RotaSeguraDTO {
    private Long id;
    private String origem;
    private String destino;
    private String instrucoes;
    private AreaDeRiscoDTO area;  // Alteração importante aqui

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getOrigem() { return origem; }
    public void setOrigem(String origem) { this.origem = origem; }

    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }

    public String getInstrucoes() { return instrucoes; }
    public void setInstrucoes(String instrucoes) { this.instrucoes = instrucoes; }

    public AreaDeRiscoDTO getArea() { return area; }
    public void setArea(AreaDeRiscoDTO area) { this.area = area; }
}
