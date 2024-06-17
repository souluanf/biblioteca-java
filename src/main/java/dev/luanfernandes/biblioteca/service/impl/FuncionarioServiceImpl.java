package dev.luanfernandes.biblioteca.service.impl;

import dev.luanfernandes.biblioteca.domain.entity.Funcionario;
import dev.luanfernandes.biblioteca.domain.mapper.FuncionarioMapper;
import dev.luanfernandes.biblioteca.domain.request.FuncionarioRequest;
import dev.luanfernandes.biblioteca.domain.request.FuncionarioUpdateRequest;
import dev.luanfernandes.biblioteca.domain.response.FuncionarioResponse;
import dev.luanfernandes.biblioteca.repository.FuncionarioRepository;
import dev.luanfernandes.biblioteca.service.FuncionarioService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuncionarioServiceImpl implements FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final FuncionarioMapper mapper = FuncionarioMapper.INSTANCE;

    @Transactional
    @Override
    public FuncionarioResponse salvarFuncionario(FuncionarioRequest funcionario) {
        Funcionario obj = mapper.map(funcionario);
        return mapper.map(funcionarioRepository.save(obj));
    }

    @Transactional(readOnly = true)
    @Override
    public FuncionarioResponse obterFuncionarioPorId(Long id) {
        return mapper.map(getFuncionarioById(id));
    }

    public Funcionario getFuncionarioById(Long id) {
        return funcionarioRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Funcionario não encontrado com id: " + id)
        );
    }

    @Transactional(readOnly = true)
    @Override
    public List<FuncionarioResponse> obterTodosFuncionarios() {
        return funcionarioRepository.findAll().stream().map(mapper::map).toList();
    }

    @Transactional
    @Override
    public void excluirFuncionario(Long id) {
        obterFuncionarioPorId(id);
        funcionarioRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void atualizarFuncionario(Long id, FuncionarioUpdateRequest funcionarioUpdateRequest) {
        Funcionario funcionario = getFuncionarioById(id);
        funcionario.setCargo(funcionarioUpdateRequest.cargo());
        funcionario.setDataInicio(funcionarioUpdateRequest.dataInicio());
        funcionarioRepository.save(funcionario);
    }
}
