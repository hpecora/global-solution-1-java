package com.safewater.safewater_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class RotaSegura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String origem;
    private String destino;
    private String instrucoes;

    @ManyToOne
    @JoinColumn(name = "area_id")
    private AreaDeRisco area;
}
