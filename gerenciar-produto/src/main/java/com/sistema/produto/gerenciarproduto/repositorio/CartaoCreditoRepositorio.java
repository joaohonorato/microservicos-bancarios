package com.sistema.produto.gerenciarproduto.repositorio;

import com.sistema.produto.gerenciarproduto.dominio.CartaoCredito;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para informacoes da cartao de credito
 */
public interface CartaoCreditoRepositorio extends JpaRepository<CartaoCredito, Long> {
}
