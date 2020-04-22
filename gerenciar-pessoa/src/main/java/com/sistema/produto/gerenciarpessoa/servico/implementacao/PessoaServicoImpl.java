package com.sistema.produto.gerenciarpessoa.servico.implementacao;

import com.sistema.produto.gerenciarpessoa.dominio.ApiResposta;
import com.sistema.produto.gerenciarpessoa.dominio.Pessoa;
import com.sistema.produto.gerenciarpessoa.dominio.PessoaPayload;
import com.sistema.produto.gerenciarpessoa.dominio.dtos.PessoaDTO;
import com.sistema.produto.gerenciarpessoa.dominio.fabrica.PessoaFabrica;
import com.sistema.produto.gerenciarpessoa.dominio.payload.ContaPayload;
import com.sistema.produto.gerenciarpessoa.excecoes.ContaNaoCadastradaExcecao;
import com.sistema.produto.gerenciarpessoa.repositorio.PessoaRespositorio;
import com.sistema.produto.gerenciarpessoa.servico.PessoaServico;
import com.sistema.produto.gerenciarpessoa.servico.rest.ContaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PessoaServicoImpl implements PessoaServico {

    @Autowired
    private PessoaRespositorio pessoaRespositorio;

    @Autowired
    private ContaServico contaServico;

    @Autowired
    private PessoaFabrica pessoaFabrica;

    @Override
    public PessoaDTO salvar(PessoaPayload payload) throws ContaNaoCadastradaExcecao {
        PessoaDTO pessoaDTO = new PessoaDTO(payload.getNome(),payload.getPessoa());
        Pessoa pessoa = pessoaFabrica.buscaEntidade(pessoaDTO);
        pessoa.setScore(new Random().nextInt(10));
        pessoa.setContaCadastrada(false);
        pessoaRespositorio.save(pessoa);
        pessoaDTO.setId(pessoa.getId());
        pessoaDTO.setScore(pessoa.getScore());
        ApiResposta resposta = contaServico
                .cadastrarConta(new ContaPayload(pessoa.getId(), pessoa.getTipoPessoa()));
        Boolean contaCadastrada = resposta.getSucesso();
        pessoa.setContaCadastrada(contaCadastrada);
        pessoaRespositorio.save(pessoa);
        if (!contaCadastrada) {
            throw new ContaNaoCadastradaExcecao(resposta.getMensagem());
        }
        pessoaDTO.setContaCadastrada(contaCadastrada);
        return pessoaDTO;
    }

    @Override
    public Integer buscaScore(Long id) {
        return pessoaRespositorio.buscaScore(id);
    }
}
