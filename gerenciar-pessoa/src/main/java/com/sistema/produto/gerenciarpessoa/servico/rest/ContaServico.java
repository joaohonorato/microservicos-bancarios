package com.sistema.produto.gerenciarpessoa.servico.rest;

import com.sistema.produto.gerenciarpessoa.dominio.ApiResposta;
import com.sistema.produto.gerenciarpessoa.dominio.payload.ContaPayload;

/**
 * Servico externo para criar conta
 */
public interface ContaServico {
    ApiResposta cadastrarConta(ContaPayload payload);
}
