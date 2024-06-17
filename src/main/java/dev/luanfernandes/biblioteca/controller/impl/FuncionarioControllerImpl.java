package dev.luanfernandes.biblioteca.controller.impl;

import dev.luanfernandes.biblioteca.controller.FuncionarioController;
import dev.luanfernandes.biblioteca.domain.request.FuncionarioRequest;
import dev.luanfernandes.biblioteca.domain.request.FuncionarioUpdateRequest;
import dev.luanfernandes.biblioteca.domain.response.FuncionarioResponse;
import dev.luanfernandes.biblioteca.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequiredArgsConstructor
public class FuncionarioControllerImpl implements FuncionarioController {

    private final FuncionarioService funcionarioService;

    @Override
    public ResponseEntity<FuncionarioResponse> salvarFuncionario(FuncionarioRequest request) {
        return status(CREATED).body(funcionarioService.salvarFuncionario(request));
    }

    @Override
    public ResponseEntity<FuncionarioResponse> obterFuncionarioPorId(Long id) {
        return ok(funcionarioService.obterFuncionarioPorId(id));
    }

    @Override
    public ResponseEntity<List<FuncionarioResponse>> obterTodosFuncionarios() {
        return ok(funcionarioService.obterTodosFuncionarios());
    }

    @Override
    public ResponseEntity<Void> excluirFuncionario(Long id) {
        funcionarioService.excluirFuncionario(id);
        return noContent().build();
    }

    @Override
    public ResponseEntity<Void> atualizarFuncionario(Long id, FuncionarioUpdateRequest request) {
        funcionarioService.atualizarFuncionario(id, request);
        return noContent().build();
    }
}
