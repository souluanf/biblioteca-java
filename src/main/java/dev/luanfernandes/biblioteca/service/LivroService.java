package dev.luanfernandes.biblioteca.service;

import dev.luanfernandes.biblioteca.domain.entity.Livro;

import java.util.List;

public interface LivroService {
    Livro salvarLivro(Livro livro);
    Livro obterLivroPorId(Long id);
    List<Livro> obterTodosLivros();
    void excluirLivro(Long id);
    List<Livro> buscarLivroAutor(String autor);
}
