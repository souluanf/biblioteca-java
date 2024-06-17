package dev.luanfernandes.biblioteca.service;

import dev.luanfernandes.biblioteca.domain.request.FuncionarioRequest;
import dev.luanfernandes.biblioteca.domain.request.FuncionarioUpdateRequest;
import dev.luanfernandes.biblioteca.domain.response.FuncionarioResponse;
import java.util.List;

public interface FuncionarioService {
    FuncionarioResponse salvarFuncionario(FuncionarioRequest funcionario);

    FuncionarioResponse obterFuncionarioPorId(Long id);

    List<FuncionarioResponse> obterTodosFuncionarios();

    void excluirFuncionario(Long id);

    void atualizarFuncionario(Long id, FuncionarioUpdateRequest funcionarioUpdateRequest);
}
