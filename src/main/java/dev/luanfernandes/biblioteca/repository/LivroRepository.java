package dev.luanfernandes.biblioteca.repository;

import dev.luanfernandes.biblioteca.domain.entity.Livro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    List<Livro> findByAutor(String autor);
}
