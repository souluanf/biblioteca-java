package dev.luanfernandes.biblioteca.domain.entity;

import dev.luanfernandes.biblioteca.domain.enums.FuncionarioCargo;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Funcionario extends Pessoa {

    @Enumerated(EnumType.STRING)
    private FuncionarioCargo cargo;
    private LocalDate dataInicio;
}
