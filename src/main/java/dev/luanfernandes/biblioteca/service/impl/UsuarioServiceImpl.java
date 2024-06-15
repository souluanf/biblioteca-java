package dev.luanfernandes.biblioteca.service.impl;

import dev.luanfernandes.biblioteca.domain.entity.Usuario;
import dev.luanfernandes.biblioteca.repository.UsuarioRepository;
import dev.luanfernandes.biblioteca.service.UsuarioService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Transactional
    @Override
    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Transactional(readOnly = true)
    @Override
    public Usuario obterUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Usuario> obterTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    @Transactional
    @Override
    public void excluirUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
