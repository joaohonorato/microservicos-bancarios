package com.sistema.produto.gerenciarconta.dominio.fabrica;

import com.sistema.produto.gerenciarconta.dominio.Conta;
import com.sistema.produto.gerenciarconta.dominio.dtos.ContaDTO;
import org.springframework.stereotype.Component;

/**
 * Fabrica responsavel por fornecer entidades e dtos dos objetos
 */
@Component
public class ContaFabrica {
     public ContaDTO buscaDto(Conta conta) {
        ContaDTO dto = new ContaDTO();
        dto.setAgencia(conta.getAgencia());
        dto.setNumero(conta.getNumero());
        dto.setPessoaId(conta.getPessoaId());
        dto.setTipoConta(conta.getTipoConta());
        dto.setProdutoCadastrados(conta.getProdutoCadastrado());
		return dto;
     }
     public Conta buscaEntidade(ContaDTO contaDTO) {
        Conta entidade = new Conta();
        entidade.setAgencia(contaDTO.getAgencia());
        entidade.setNumero(contaDTO.getNumero());
        entidade.setPessoaId(contaDTO.getPessoaId());
        entidade.setTipoConta(contaDTO.getTipoConta());
        entidade.setProdutoCadastrado(contaDTO.getProdutoCadastrados());
        return entidade;
     }
}