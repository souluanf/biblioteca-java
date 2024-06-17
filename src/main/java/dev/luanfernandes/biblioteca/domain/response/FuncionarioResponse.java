package dev.luanfernandes.biblioteca.domain.response;

import dev.luanfernandes.biblioteca.domain.enums.FuncionarioCargo;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record FuncionarioResponse(
        Long id,
        String nome,
        String email,
        FuncionarioCargo cargo,
        LocalDate dataInicio,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {}
