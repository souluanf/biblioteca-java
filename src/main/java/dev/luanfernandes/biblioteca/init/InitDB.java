package dev.luanfernandes.biblioteca.init;

import dev.luanfernandes.biblioteca.domain.enums.FuncionarioCargo;
import dev.luanfernandes.biblioteca.domain.request.FuncionarioRequest;
import dev.luanfernandes.biblioteca.domain.request.FuncionarioUpdateRequest;
import dev.luanfernandes.biblioteca.domain.request.LivroRequest;
import dev.luanfernandes.biblioteca.domain.request.UsuarioRequest;
import dev.luanfernandes.biblioteca.domain.response.EmprestimoResponse;
import dev.luanfernandes.biblioteca.domain.response.FuncionarioResponse;
import dev.luanfernandes.biblioteca.domain.response.LivroResponse;
import dev.luanfernandes.biblioteca.domain.response.UsuarioResponse;
import dev.luanfernandes.biblioteca.service.EmprestimoService;
import dev.luanfernandes.biblioteca.service.FuncionarioService;
import dev.luanfernandes.biblioteca.service.LivroService;
import dev.luanfernandes.biblioteca.service.UsuarioService;
import java.time.LocalDate;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class InitDB implements CommandLineRunner {

    private final FuncionarioService funcionarioService;
    private final UsuarioService usuarioService;
    private final EmprestimoService emprestimoService;
    private final LivroService livroService;

    @Override
    public void run(String... args) {
        LivroRequest livroRequest1 = LivroRequest.builder()
                .titulo("Livro 1")
                .autor("Autor 1")
                .ano(1994)
                .build();
        LivroResponse livro1 = livroService.salvarLivro(livroRequest1);

        LivroRequest livroRequest2 = LivroRequest.builder()
                .titulo("Livro 2")
                .autor("Autor 2")
                .ano(1994)
                .build();
        LivroResponse livro2 = livroService.salvarLivro(livroRequest2);

        UsuarioRequest usuarioRequest1 = UsuarioRequest.builder()
                .nome("Usuario 1")
                .email("usuario1@gmail.com")
                .dataCadastro(LocalDate.now())
                .matricula(UUID.randomUUID().toString())
                .endereco("Endereco 1")
                .build();
        UsuarioResponse usuario1 = usuarioService.salvarUsuario(usuarioRequest1);

        FuncionarioRequest funcionarioRequest1 = FuncionarioRequest.builder()
                .nome("Funcionario 1")
                .email("funcionario1@gmail.com")
                .cargo(FuncionarioCargo.ATENDENTE)
                .dataInicio(LocalDate.now().minusDays(366))
                .build();
        FuncionarioResponse funcionario1 = funcionarioService.salvarFuncionario(funcionarioRequest1);

        FuncionarioUpdateRequest funcionarioUpdateRequest = FuncionarioUpdateRequest.builder()
                .cargo(FuncionarioCargo.GERENTE)
                .dataInicio(LocalDate.now().minusDays(3))
                .build();

        funcionarioService.atualizarFuncionario(funcionario1.id(), funcionarioUpdateRequest);

        EmprestimoResponse emprestimo = emprestimoService.cadastrar(livro1.id(), usuario1.id(), funcionario1.id());
        EmprestimoResponse emprestimo2 = emprestimoService.cadastrar(livro2.id(), usuario1.id(), funcionario1.id());

        emprestimoService.devolver(emprestimo.id());
    }
}
