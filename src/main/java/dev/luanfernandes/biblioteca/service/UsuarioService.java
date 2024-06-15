package dev.luanfernandes.biblioteca.service;

import dev.luanfernandes.biblioteca.domain.entity.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario salvarUsuario(Usuario usuario);
    Usuario obterUsuarioPorId(Long id);
    List<Usuario> obterTodosUsuarios();
    void excluirUsuario(Long id);
}
