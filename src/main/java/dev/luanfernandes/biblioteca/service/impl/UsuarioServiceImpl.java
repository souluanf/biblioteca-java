package dev.luanfernandes.biblioteca.service.impl;

import dev.luanfernandes.biblioteca.domain.entity.Usuario;
import dev.luanfernandes.biblioteca.domain.mapper.UsuarioMapper;
import dev.luanfernandes.biblioteca.domain.request.UsuarioRequest;
import dev.luanfernandes.biblioteca.domain.response.UsuarioResponse;
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
    private final UsuarioMapper mapper = UsuarioMapper.INSTANCE;

    @Transactional
    @Override
    public UsuarioResponse salvarUsuario(UsuarioRequest usuario) {
        Usuario obj = mapper.map(usuario);
        return mapper.map(usuarioRepository.save(obj));
    }

    @Transactional(readOnly = true)
    @Override
    public UsuarioResponse obterUsuarioPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Usuario não encontrado com id: " + id)
        );
        return mapper.map(usuario);
    }

    @Transactional(readOnly = true)
    @Override
    public List<UsuarioResponse> obterTodosUsuarios() {
        return usuarioRepository.findAll().stream().map(mapper::map).toList();
    }

    @Transactional
    @Override
    public void excluirUsuario(Long id) {
        obterUsuarioPorId(id);
        usuarioRepository.deleteById(id);
    }
}
