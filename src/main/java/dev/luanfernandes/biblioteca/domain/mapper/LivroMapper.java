package dev.luanfernandes.biblioteca.domain.mapper;

import dev.luanfernandes.biblioteca.domain.entity.Livro;
import dev.luanfernandes.biblioteca.domain.request.LivroRequest;
import dev.luanfernandes.biblioteca.domain.response.LivroResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LivroMapper {

    LivroMapper INSTANCE = Mappers.getMapper(LivroMapper.class);

    Livro map(LivroRequest source);

    LivroResponse map(Livro source);
}
