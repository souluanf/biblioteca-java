package dev.luanfernandes.biblioteca.domain.request;

import java.time.LocalDate;
import lombok.Builder;

@Builder
public record UsuarioRequest(String nome, String email, LocalDate dataCadastro, String matricula, String endereco) {}
