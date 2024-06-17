package dev.luanfernandes.biblioteca.domain.entity;

import dev.luanfernandes.biblioteca.domain.enums.FuncionarioCargo;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Funcionario extends Pessoa {

    @Enumerated(EnumType.STRING)
    private FuncionarioCargo cargo;

    private LocalDate dataInicio;
}
