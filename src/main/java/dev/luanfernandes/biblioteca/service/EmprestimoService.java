package dev.luanfernandes.biblioteca.service;

import dev.luanfernandes.biblioteca.domain.enums.EmprestimoStatus;
import dev.luanfernandes.biblioteca.domain.response.EmprestimoResponse;
import java.util.List;

public interface EmprestimoService {
    List<EmprestimoResponse> listar(EmprestimoStatus status);

    EmprestimoResponse cadastrar(Long livroId, Long usuarioId, Long funcionarioId);

    void devolver(Long emprestimoId);
}
