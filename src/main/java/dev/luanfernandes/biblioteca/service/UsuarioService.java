package dev.luanfernandes.biblioteca.service;

import dev.luanfernandes.biblioteca.domain.request.UsuarioRequest;
import dev.luanfernandes.biblioteca.domain.response.UsuarioResponse;
import java.util.List;

public interface UsuarioService {
    UsuarioResponse salvarUsuario(UsuarioRequest usuario);

    UsuarioResponse obterUsuarioPorId(Long id);

    List<UsuarioResponse> obterTodosUsuarios();

    void excluirUsuario(Long id);
}
