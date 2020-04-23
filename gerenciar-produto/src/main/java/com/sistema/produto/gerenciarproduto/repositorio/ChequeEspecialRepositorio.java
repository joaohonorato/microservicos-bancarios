package com.sistema.produto.gerenciarproduto.repositorio;

import com.sistema.produto.gerenciarproduto.dominio.ChequeEspecial;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para informacoes do cheque especial
 */
public interface ChequeEspecialRepositorio extends JpaRepository<ChequeEspecial, Long> {
}
