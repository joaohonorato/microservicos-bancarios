package com.sistema.produto.gerenciarpessoa.servico;

import com.sistema.produto.gerenciarpessoa.dominio.PessoaPayload;
import com.sistema.produto.gerenciarpessoa.dominio.dtos.PessoaDTO;
import com.sistema.produto.gerenciarpessoa.excecoes.ContaNaoCadastradaExcecao;

public interface PessoaServico {
    PessoaDTO salvar(PessoaPayload payload) throws ContaNaoCadastradaExcecao;
    public Integer buscaScore(Long id);
}
