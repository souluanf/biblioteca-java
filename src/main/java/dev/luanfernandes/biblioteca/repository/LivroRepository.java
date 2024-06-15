package dev.luanfernandes.biblioteca.repository;

import dev.luanfernandes.biblioteca.domain.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    List<Livro> findByAutor(String autor);
}