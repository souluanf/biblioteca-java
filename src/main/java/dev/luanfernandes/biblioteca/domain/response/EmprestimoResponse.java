package dev.luanfernandes.biblioteca.domain.response;

import dev.luanfernandes.biblioteca.domain.enums.EmprestimoStatus;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record EmprestimoResponse(
        Long id,
        Long livroId,
        Long usuarioId,
        Long funcionarioId,
        EmprestimoStatus emprestimoStatus,
        LocalDate dataDevolucao,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {}
