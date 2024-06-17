package dev.luanfernandes.biblioteca.service.impl;

import dev.luanfernandes.biblioteca.domain.entity.Livro;
import dev.luanfernandes.biblioteca.domain.mapper.LivroMapper;
import dev.luanfernandes.biblioteca.domain.request.LivroRequest;
import dev.luanfernandes.biblioteca.domain.response.LivroResponse;
import dev.luanfernandes.biblioteca.repository.LivroRepository;
import dev.luanfernandes.biblioteca.service.LivroService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LivroServiceImpl implements LivroService {

    private final LivroRepository livroRepository;
    private final LivroMapper mapper = LivroMapper.INSTANCE;

    public LivroServiceImpl(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @Transactional
    @Override
    public LivroResponse salvarLivro(LivroRequest livro) {
        Livro obj = mapper.map(livro);
        return mapper.map(livroRepository.save(obj));
    }

    @Transactional(readOnly = true)
    @Override
    public LivroResponse obterLivroPorId(Long id) {
        Livro obj = livroRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Livro não encontrado com id: "+id)
        );
        return mapper.map(obj);
    }

    @Transactional(readOnly = true)
    @Override
    public List<LivroResponse> obterTodosLivros() {
        return livroRepository.findAll().stream().map(mapper::map).toList();
    }

    @Transactional
    @Override
    public void excluirLivro(Long id) {
        obterLivroPorId(id);
        livroRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<LivroResponse> buscarLivroAutor(String autor) {
        return livroRepository.findByAutor(autor).stream().map(mapper::map).toList();
    }
}
