package dev.luanfernandes.biblioteca.service.impl;

import dev.luanfernandes.biblioteca.domain.entity.Emprestimo;
import dev.luanfernandes.biblioteca.domain.entity.Funcionario;
import dev.luanfernandes.biblioteca.domain.entity.Livro;
import dev.luanfernandes.biblioteca.domain.entity.Usuario;
import dev.luanfernandes.biblioteca.domain.enums.EmprestimoStatus;
import dev.luanfernandes.biblioteca.domain.enums.LivroStatus;
import dev.luanfernandes.biblioteca.repository.EmprestimoRepository;
import dev.luanfernandes.biblioteca.repository.FuncionarioRepository;
import dev.luanfernandes.biblioteca.repository.LivroRepository;
import dev.luanfernandes.biblioteca.repository.UsuarioRepository;
import dev.luanfernandes.biblioteca.service.EmprestimoService;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


@Service
@RequiredArgsConstructor
public class EmprestimoServiceImpl implements EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;
    private final LivroRepository livroRepository;
    private final UsuarioRepository usuarioRepository;
    private final FuncionarioRepository funcionarioRepository;

    @Override
    public List<Emprestimo> listar() {
        return emprestimoRepository.findAll();
    }

    @Transactional
    @Override
    public Emprestimo cadastrar(Long livroId, Long usuarioId, Long funcionarioId) {
        Livro livro = livroRepository.findById(livroId).orElseThrow(EntityExistsException::new);

        if (Objects.equals(livro.getStatus(), LivroStatus.ALUGADO)){
            throw new IllegalArgumentException(String.format("O livro '%s' está alugado", livro.getTitulo()));
        }

        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(EntityExistsException::new);
        Funcionario funcionario = funcionarioRepository.findById(funcionarioId).orElseThrow(EntityExistsException::new);

        livro.setStatus(LivroStatus.ALUGADO);
        livroRepository.save(livro);

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setLivro(livro);
        emprestimo.setUsuario(usuario);
        emprestimo.setFuncionario(funcionario);
        emprestimo.setDataDevolucao(LocalDate.now().plusWeeks(2));
        return emprestimoRepository.save(emprestimo);
    }

    @Transactional
    @Override
    public void devolver(Long emprestimoId) {
        Emprestimo emprestimo = emprestimoRepository.findById(emprestimoId).orElseThrow(EntityExistsException::new);

        Livro livro = emprestimo.getLivro();
        livro.setStatus(LivroStatus.DISPONIVEL);
        livroRepository.save(livro);

        emprestimo.setDataDevolucao(LocalDate.now());
        emprestimo.setEmprestimoStatus(EmprestimoStatus.FINALIZADO);
        emprestimoRepository.save(emprestimo);
    }
}
