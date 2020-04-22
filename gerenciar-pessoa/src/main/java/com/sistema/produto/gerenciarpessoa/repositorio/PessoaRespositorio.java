package com.sistema.produto.gerenciarpessoa.repositorio;

import com.sistema.produto.gerenciarpessoa.dominio.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PessoaRespositorio extends JpaRepository<Pessoa, Long> {
    @Query("SELECT p.score FROM Pessoa p WHERE p.id = :id")
    Integer buscaScore(Long id);
}
