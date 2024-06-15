package dev.luanfernandes.biblioteca.service.impl;

import dev.luanfernandes.biblioteca.domain.dto.FuncionarioDTO;
import dev.luanfernandes.biblioteca.domain.entity.Funcionario;
import dev.luanfernandes.biblioteca.repository.FuncionarioRepository;
import dev.luanfernandes.biblioteca.service.FuncionarioService;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
public class FuncionarioServiceImpl implements FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    @Transactional
    @Override
    public Funcionario salvarFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @Transactional(readOnly = true)
    @Override
    public Funcionario obterFuncionarioPorId(Long id) {
        return funcionarioRepository.findById(id).orElseThrow(EntityExistsException::new);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Funcionario> obterTodosFuncionarios() {
        return funcionarioRepository.findAll();
    }

    @Transactional
    @Override
    public void excluirFuncionario(Long id) {
        funcionarioRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void atualizarFuncionario(Long id, FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = obterFuncionarioPorId(id);
        funcionario.setCargo(funcionarioDTO.cargo());
        funcionario.setDataInicio(funcionarioDTO.dataInicio());
        funcionarioRepository.save(funcionario);
    }
}
