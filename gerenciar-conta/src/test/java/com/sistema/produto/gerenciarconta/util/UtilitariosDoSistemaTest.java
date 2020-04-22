package com.sistema.produto.gerenciarconta.util;

import com.sistema.produto.gerenciarconta.dominio.enums.TipoConta;
import com.sistema.produto.gerenciarconta.dominio.enums.TipoPessoa;
import com.sistema.produto.gerenciarconta.repositorio.ContaRepositorio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith({SpringExtension.class, MockitoExtension.class})
class UtilitariosDoSistemaTest {

    @Mock
    private ContaRepositorio contaRepositorio;

    @InjectMocks
    private UtilitariosDoSistema utilitariosDoSistema;

    @Test
    public void podeCriarContaRetornaVerdadeiro() {
        given(contaRepositorio.buscaNumeroDaProximaConta()).willReturn(1);
        Boolean resultado = utilitariosDoSistema.podeCriarConta();
        assertThat(resultado).isTrue();
    }

    @Test
    public void numeroMaximoDeContasAtingido_podeCriarContaRetornaFalso() {
        given(contaRepositorio.buscaNumeroDaProximaConta()).willReturn(999999 + 1);
        Boolean resultado = utilitariosDoSistema.podeCriarConta();
        assertThat(resultado).isFalse();
    }

    @Test
    public void mapeamentoPessoaFiscaParaContaCorrente() {
        TipoConta resultado = utilitariosDoSistema.mapTipoPessoParaTipoConta(TipoPessoa.PESSOA_FISICA);
        assertThat(resultado).isEqualTo(TipoConta.CONTA_CORRENTE);
    }

    @Test
    public void mapeamentoPessoaJuridicaParaContaEmpresaria() {
        TipoConta resultado = utilitariosDoSistema.mapTipoPessoParaTipoConta(TipoPessoa.PESSOA_JURIDICA);
        assertThat(resultado).isEqualTo(TipoConta.CONTA_EMPRESARIAL);
    }
}