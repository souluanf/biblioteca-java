package dev.luanfernandes.biblioteca.domain.request;

import dev.luanfernandes.biblioteca.domain.enums.FuncionarioCargo;
import java.time.LocalDate;
import lombok.Builder;

@Builder
public record FuncionarioUpdateRequest(FuncionarioCargo cargo, LocalDate dataInicio) {}
