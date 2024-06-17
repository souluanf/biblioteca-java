package dev.luanfernandes.biblioteca.domain.response;

import dev.luanfernandes.biblioteca.domain.enums.UsuarioStatus;
import java.time.LocalDateTime;

public record UsuarioResponse(
        Long id,
        String nome,
        String email,
        String matricula,
        String endereco,
        UsuarioStatus status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {}
