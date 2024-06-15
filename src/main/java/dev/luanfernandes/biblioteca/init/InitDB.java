package dev.luanfernandes.biblioteca.init;

import dev.luanfernandes.biblioteca.domain.dto.FuncionarioDTO;
import dev.luanfernandes.biblioteca.domain.entity.Emprestimo;
import dev.luanfernandes.biblioteca.domain.entity.Funcionario;
import dev.luanfernandes.biblioteca.domain.entity.Livro;
import dev.luanfernandes.biblioteca.domain.entity.Usuario;
import dev.luanfernandes.biblioteca.domain.enums.FuncionarioCargo;
import dev.luanfernandes.biblioteca.service.EmprestimoService;
import dev.luanfernandes.biblioteca.service.FuncionarioService;
import dev.luanfernandes.biblioteca.service.LivroService;
import dev.luanfernandes.biblioteca.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.UUID;

@Configuration
@RequiredArgsConstructor
public class InitDB implements CommandLineRunner {

    private final FuncionarioService funcionarioService;
    private final UsuarioService usuarioService;
    private final EmprestimoService emprestimoService;
    private final LivroService livroService;

    @Override
    public void run(String... args) throws Exception {
        // Livros
        Livro livro1 = new Livro();
        livro1.setTitulo("Livro 1");
        livro1.setAno(1994);
        livro1.setAutor("Autor 1");
        livro1 = livroService.salvarLivro(livro1);

        Livro livro2 = new Livro();
        livro2.setTitulo("Livro 2");
        livro2.setAno(1994);
        livro2.setAutor("Autor 2");
        livro2 = livroService.salvarLivro(livro2);

        Usuario usuario1 = new Usuario();
        usuario1.setNome("Usuario 1");
        usuario1.setEmail("usuario1@gmail.com");
        usuario1.setDataCadastro(LocalDate.now());
        usuario1.setMatricula(UUID.randomUUID().toString());
        usuario1.setEndereco("Endereco 1");
        usuario1 = usuarioService.salvarUsuario(usuario1);

        Funcionario funcionario1 = new Funcionario();
        funcionario1.setNome("Funcionario 1");
        funcionario1.setEmail("funcionario1@gmail.com");
        funcionario1.setCargo(FuncionarioCargo.ATENDENTE);
        funcionario1.setDataInicio(LocalDate.now().minusDays(366));
        funcionario1 = funcionarioService.salvarFuncionario(funcionario1);

        FuncionarioDTO funcionarioDTO = new FuncionarioDTO(FuncionarioCargo.GERENTE,LocalDate.now().minusDays(3));
        funcionarioService.atualizarFuncionario(funcionario1.getId(),funcionarioDTO);


        Emprestimo emprestimo = emprestimoService.cadastrar(livro1.getId(), usuario1.getId(), funcionario1.getId());
        Emprestimo emprestimo2 = emprestimoService.cadastrar(livro2.getId(), usuario1.getId(), funcionario1.getId());

        emprestimoService.devolver(emprestimo.getId());

    }
}
