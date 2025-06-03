package com.safewater.safewater_api.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "ALERTA")
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DATA_HORA")
    private LocalDateTime dataHora;

    @Column(name = "NIVEL_AGUA")
    private Double nivelAgua;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "TIPO")
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "AREA_ID")
    private AreaDeRisco area;
}
