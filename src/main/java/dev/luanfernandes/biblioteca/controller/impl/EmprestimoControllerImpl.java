package dev.luanfernandes.biblioteca.controller.impl;

import dev.luanfernandes.biblioteca.controller.EmprestimoController;
import dev.luanfernandes.biblioteca.domain.enums.EmprestimoStatus;
import dev.luanfernandes.biblioteca.domain.response.EmprestimoResponse;
import dev.luanfernandes.biblioteca.service.EmprestimoService;
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
public class EmprestimoControllerImpl implements EmprestimoController {

    private final EmprestimoService emprestimoService;

    @Override
    public ResponseEntity<List<EmprestimoResponse>> listar(EmprestimoStatus status) {
        return ok(emprestimoService.listar(status));
    }

    @Override
    public ResponseEntity<EmprestimoResponse> cadastrar(Long livroId, Long usuarioId, Long funcionarioId) {
        return status(CREATED).body(emprestimoService.cadastrar(livroId, usuarioId, funcionarioId));
    }

    @Override
    public ResponseEntity<Void> devolver(Long id) {
        emprestimoService.devolver(id);
        return noContent().build();
    }
}
