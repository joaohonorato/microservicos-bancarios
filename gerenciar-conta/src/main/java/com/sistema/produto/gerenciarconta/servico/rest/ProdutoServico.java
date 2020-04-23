package com.sistema.produto.gerenciarconta.servico.rest;

import com.sistema.produto.gerenciarconta.dominio.ApiResposta;
import com.sistema.produto.gerenciarconta.dominio.payload.ProdutoPayload;

/**
 * Servico externo para criar produtos
 */
public interface ProdutoServico {
    ApiResposta criarProdutos(ProdutoPayload payload);
}