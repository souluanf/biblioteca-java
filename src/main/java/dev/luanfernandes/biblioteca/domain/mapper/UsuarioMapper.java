package dev.luanfernandes.biblioteca.domain.mapper;

import dev.luanfernandes.biblioteca.domain.entity.Usuario;
import dev.luanfernandes.biblioteca.domain.request.UsuarioRequest;
import dev.luanfernandes.biblioteca.domain.response.UsuarioResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    Usuario map(UsuarioRequest source);

    UsuarioResponse map(Usuario source);
}
