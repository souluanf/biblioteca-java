package dev.luanfernandes.biblioteca.domain.entity;

import dev.luanfernandes.biblioteca.domain.enums.UsuarioStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Usuario extends Pessoa {
    private String matricula;
    private String endereco;

    @Enumerated(EnumType.STRING)
    private UsuarioStatus status = UsuarioStatus.ATIVO;

    @OneToMany(mappedBy = "usuario")
    private List<Emprestimo> emprestimos;
}
