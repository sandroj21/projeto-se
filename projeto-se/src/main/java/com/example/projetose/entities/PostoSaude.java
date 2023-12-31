package com.example.projetose.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class PostoSaude {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String endereco;
  
    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "posto_medico",
            joinColumns = @JoinColumn(name = "posto_id"),
            inverseJoinColumns = @JoinColumn(name = "medico_id")
    )
    private List<Medico> medicos;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "posto_especialidades",
            joinColumns = @JoinColumn(name = "posto_id"),
            inverseJoinColumns = @JoinColumn(name = "especialidade_id")
    )
    private List<Especialidade> especialidades;


}
