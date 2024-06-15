package dev.luanfernandes.biblioteca.domain.entity;

import dev.luanfernandes.biblioteca.domain.enums.EmprestimoStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Emprestimo extends Auditavel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Livro livro;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Funcionario funcionario;

    private LocalDate dataDevolucao;

    @Enumerated(EnumType.STRING)
    private EmprestimoStatus emprestimoStatus = EmprestimoStatus.ATIVO;
}
