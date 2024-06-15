package dev.luanfernandes.biblioteca.repository;

import dev.luanfernandes.biblioteca.domain.entity.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
}