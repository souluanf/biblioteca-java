package dev.luanfernandes.biblioteca.domain.entity;

import dev.luanfernandes.biblioteca.domain.enums.LivroStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Livro extends Auditavel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titulo;
    private String autor;
    private int ano;

    @Enumerated(EnumType.STRING)
    LivroStatus status = LivroStatus.DISPONIVEL;
}
