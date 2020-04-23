package com.sistema.produto.gerenciarproduto.servico;

import com.sistema.produto.gerenciarproduto.dominio.dto.ProdutoDTO;
import com.sistema.produto.gerenciarproduto.dominio.payload.ProdutoPayload;

/**
 * Servico para criacao de produto
 */
public interface ProdutoServico {
    ProdutoDTO criarProdutos(ProdutoPayload payload);
}
