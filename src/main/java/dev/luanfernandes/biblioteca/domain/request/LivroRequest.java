package dev.luanfernandes.biblioteca.domain.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import org.springframework.validation.annotation.Validated;

@Validated
@Builder
public record LivroRequest(
        @NotBlank(message = "Titulo é obrigatorio") String titulo,
        @NotBlank(message = "Autor é obrigatorio") @Size(min = 3,message = "minimo 3 chars") String autor,
        @NotNull(message = "Ano é obrigatorio") @Min(value = 1900, message = "ANo deve ser superior a 1900") Integer ano
) {}
