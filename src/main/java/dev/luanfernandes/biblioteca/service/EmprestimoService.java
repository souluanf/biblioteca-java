package dev.luanfernandes.biblioteca.service;

import dev.luanfernandes.biblioteca.domain.entity.Emprestimo;

import java.util.List;

public interface EmprestimoService {
    List<Emprestimo> listar();
    Emprestimo cadastrar(Long livroId, Long usuarioId, Long funcionarioId);
    void devolver(Long emprestimoId);
}
