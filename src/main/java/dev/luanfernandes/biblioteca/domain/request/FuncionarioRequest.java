package dev.luanfernandes.biblioteca.domain.request;

import dev.luanfernandes.biblioteca.domain.enums.FuncionarioCargo;
import java.time.LocalDate;
import lombok.Builder;

@Builder
public record FuncionarioRequest(String nome, String email, FuncionarioCargo cargo, LocalDate dataInicio) {}
