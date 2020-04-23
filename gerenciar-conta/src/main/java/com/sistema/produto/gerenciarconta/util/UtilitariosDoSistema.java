package com.sistema.produto.gerenciarconta.util;

import com.sistema.produto.gerenciarconta.dominio.enums.TipoConta;
import com.sistema.produto.gerenciarconta.dominio.enums.TipoPessoa;
import com.sistema.produto.gerenciarconta.repositorio.ContaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Contem funcionalidades de utilidade para o sitema
 */
@Component
public class UtilitariosDoSistema {

    private static final int LIMITE_CONTA = 999999;

    @Autowired
    private ContaRepositorio contaRepositorio;

    public boolean podeCriarConta() {
        Integer numero_conta = contaRepositorio.buscaNumeroDaProximaConta();
        if(  numero_conta > LIMITE_CONTA) {
            return false;
        }
        return true;
    }

    public TipoConta mapTipoPessoParaTipoConta(TipoPessoa tipoPessoa) {
        return tipoPessoa.equals(TipoPessoa.PESSOA_FISICA) ? TipoConta.CONTA_CORRENTE  : TipoConta.CONTA_EMPRESARIAL;
    }
}
