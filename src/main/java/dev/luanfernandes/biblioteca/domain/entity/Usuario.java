package dev.luanfernandes.biblioteca.domain.entity;

import dev.luanfernandes.biblioteca.domain.enums.UsuarioStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class Usuario extends Pessoa{
    private LocalDate dataCadastro;
    private String matricula;
    private String endereco;

    @Enumerated(EnumType.STRING)
    private UsuarioStatus status = UsuarioStatus.ATIVO;

    @OneToMany(mappedBy = "usuario")
    private List<Emprestimo> emprestimos;

}
