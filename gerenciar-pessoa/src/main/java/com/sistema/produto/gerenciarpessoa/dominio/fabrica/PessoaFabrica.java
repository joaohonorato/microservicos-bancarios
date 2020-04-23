package com.sistema.produto.gerenciarpessoa.dominio.fabrica;

import com.sistema.produto.gerenciarpessoa.dominio.Pessoa;
import com.sistema.produto.gerenciarpessoa.dominio.dtos.PessoaDTO;
import org.springframework.stereotype.Component;

/**
 * Fabrica responsavel por fornecer entidades e dtos dos objetos
 */
@Component
public class PessoaFabrica {
    public PessoaDTO buscaDto(Pessoa pessoa) {
        PessoaDTO dto = new PessoaDTO();
        dto.setId(pessoa.getId());
        dto.setNome(pessoa.getNome());
        dto.setTipoPessoa(pessoa.getTipoPessoa());
        dto.setScore(pessoa.getScore());
        dto.setContaCadastrada(pessoa.getContaCadastrada());
        return dto;
    }

    public Pessoa buscaEntidade(PessoaDTO pessoaDTO) {
        Pessoa entidade = new Pessoa();
        entidade.setId(pessoaDTO.getId());
        entidade.setNome(pessoaDTO.getNome());
        entidade.setTipoPessoa(pessoaDTO.getTipoPessoa());
        entidade.setScore(pessoaDTO.getScore());
        entidade.setContaCadastrada(pessoaDTO.getContaCadastrada());
        return entidade;
    }

}
