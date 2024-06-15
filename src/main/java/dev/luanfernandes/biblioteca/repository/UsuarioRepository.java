package dev.luanfernandes.biblioteca.repository;

import dev.luanfernandes.biblioteca.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}