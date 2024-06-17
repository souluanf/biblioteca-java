package dev.luanfernandes.biblioteca.service;

import dev.luanfernandes.biblioteca.domain.request.LivroRequest;
import dev.luanfernandes.biblioteca.domain.response.LivroResponse;
import java.util.List;

public interface LivroService {
    LivroResponse salvarLivro(LivroRequest livro);

    LivroResponse obterLivroPorId(Long id);

    List<LivroResponse> obterTodosLivros();

    void excluirLivro(Long id);

    List<LivroResponse> buscarLivroAutor(String autor);
}
