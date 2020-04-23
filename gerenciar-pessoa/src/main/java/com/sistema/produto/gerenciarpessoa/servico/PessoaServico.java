package com.sistema.produto.gerenciarpessoa.servico;

import com.sistema.produto.gerenciarpessoa.dominio.payload.PessoaPayload;
import com.sistema.produto.gerenciarpessoa.dominio.dtos.PessoaDTO;
import com.sistema.produto.gerenciarpessoa.excecoes.ContaNaoCadastradaExcecao;

/**
 * Servico externo para criar pessoa
 */
public interface PessoaServico {
    PessoaDTO salvar(PessoaPayload payload) throws ContaNaoCadastradaExcecao;
    public Integer buscaScore(Long id);
}
