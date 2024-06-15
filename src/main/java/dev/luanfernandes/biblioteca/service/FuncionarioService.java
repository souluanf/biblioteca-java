package dev.luanfernandes.biblioteca.service;

import dev.luanfernandes.biblioteca.domain.dto.FuncionarioDTO;
import dev.luanfernandes.biblioteca.domain.entity.Funcionario;

import java.util.List;

public interface FuncionarioService {
    Funcionario salvarFuncionario(Funcionario funcionario);
    Funcionario obterFuncionarioPorId(Long id);
    List<Funcionario> obterTodosFuncionarios();
    void excluirFuncionario(Long id);
    void atualizarFuncionario(Long id, FuncionarioDTO funcionarioDTO);
}
