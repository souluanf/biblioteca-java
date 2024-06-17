package dev.luanfernandes.biblioteca.domain.request;

import lombok.Builder;

@Builder
public record EmprestimoRequest(Long livroId, Long usuarioId, Long funcionarioId) {}
