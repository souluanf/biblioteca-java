package dev.luanfernandes.biblioteca.domain.mapper;

import dev.luanfernandes.biblioteca.domain.entity.Emprestimo;
import dev.luanfernandes.biblioteca.domain.response.EmprestimoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EmprestimoMapper {
    EmprestimoMapper INSTANCE = Mappers.getMapper(EmprestimoMapper.class);

    @Mapping(target = "livroId", source = "livro.id")
    @Mapping(target = "funcionarioId", source = "funcionario.id")
    @Mapping(target = "usuarioId", source = "usuario.id")
    EmprestimoResponse map(Emprestimo source);
}
