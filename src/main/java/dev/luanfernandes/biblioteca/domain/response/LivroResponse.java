package dev.luanfernandes.biblioteca.domain.response;

import dev.luanfernandes.biblioteca.domain.enums.LivroStatus;
import java.time.LocalDateTime;
import lombok.Builder;

@Builder
public record LivroResponse(
        Long id,
        String titulo,
        String autor,
        int ano,
        LivroStatus status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {}
