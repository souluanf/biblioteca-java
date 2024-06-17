package dev.luanfernandes.biblioteca.controller.impl;

import dev.luanfernandes.biblioteca.controller.LivroController;
import dev.luanfernandes.biblioteca.domain.request.LivroRequest;
import dev.luanfernandes.biblioteca.domain.response.LivroResponse;
import dev.luanfernandes.biblioteca.service.LivroService;
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
public class LivroControllerImpl implements LivroController {

    private final LivroService livroService;

    @Override
    public ResponseEntity<LivroResponse> salvarLivro(LivroRequest livro) {
        return status(CREATED).body(livroService.salvarLivro(livro));
    }

    @Override
    public ResponseEntity<LivroResponse> obterLivroPorId(Long id) {
        return ok(livroService.obterLivroPorId(id));
    }

    @Override
    public ResponseEntity<List<LivroResponse>> obterTodosLivros() {
        return ok(livroService.obterTodosLivros());
    }

    @Override
    public ResponseEntity<Void> excluirLivro(Long id) {
        livroService.excluirLivro(id);
        return noContent().build();
    }

    @Override
    public ResponseEntity<List<LivroResponse>> buscarLivroAutor(String autor) {
        return ok(livroService.buscarLivroAutor(autor));
    }
}
