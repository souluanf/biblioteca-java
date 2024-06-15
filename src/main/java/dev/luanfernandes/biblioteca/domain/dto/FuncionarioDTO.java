package dev.luanfernandes.biblioteca.domain.dto;

import dev.luanfernandes.biblioteca.domain.enums.FuncionarioCargo;

import java.time.LocalDate;

public record FuncionarioDTO(FuncionarioCargo cargo, LocalDate dataInicio) {
}
