package dev.luanfernandes.biblioteca.controller.impl;

import dev.luanfernandes.biblioteca.controller.UsuarioController;
import dev.luanfernandes.biblioteca.domain.request.UsuarioRequest;
import dev.luanfernandes.biblioteca.domain.response.UsuarioResponse;
import dev.luanfernandes.biblioteca.service.UsuarioService;
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
public class UsuarioControllerImpl implements UsuarioController {

    private final UsuarioService usuarioService;

    @Override
    public ResponseEntity<UsuarioResponse> salvarUsuario(UsuarioRequest request) {
        return status(CREATED).body(usuarioService.salvarUsuario(request));
    }

    @Override
    public ResponseEntity<UsuarioResponse> obterUsuarioPorId(Long id) {
        return ok(usuarioService.obterUsuarioPorId(id));
    }

    @Override
    public ResponseEntity<List<UsuarioResponse>> obterTodosUsuarios() {
        return ok(usuarioService.obterTodosUsuarios());
    }

    @Override
    public ResponseEntity<Void> excluirUsuario(Long id) {
        usuarioService.excluirUsuario(id);
        return noContent().build();
    }
}
