package com.sistema.produto.gerenciarconta.repositorio;

import com.sistema.produto.gerenciarconta.dominio.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Repositorio para informacoes da conta
 */
public interface ContaRepositorio extends JpaRepository<Conta,Long> {

    @Query(value = "SELECT next_val FROM conta_seq", nativeQuery = true)
    Integer buscaNumeroDaProximaConta();

    Conta save(Conta conta);

}