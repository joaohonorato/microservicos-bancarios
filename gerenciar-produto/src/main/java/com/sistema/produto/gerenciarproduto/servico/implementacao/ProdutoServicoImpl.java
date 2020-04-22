package com.sistema.produto.gerenciarproduto.servico.implementacao;

import com.sistema.produto.gerenciarproduto.dominio.ApiResposta;
import com.sistema.produto.gerenciarproduto.dominio.CartaoCredito;
import com.sistema.produto.gerenciarproduto.dominio.ChequeEspecial;
import com.sistema.produto.gerenciarproduto.dominio.dto.ProdutoDTO;
import com.sistema.produto.gerenciarproduto.dominio.payload.ProdutoPayload;
import com.sistema.produto.gerenciarproduto.repositorio.CartaoCreditoRepositorio;
import com.sistema.produto.gerenciarproduto.repositorio.ChequeEspecialRepositorio;
import com.sistema.produto.gerenciarproduto.servico.CartaoCreditoServico;
import com.sistema.produto.gerenciarproduto.servico.ChequeEspecialServico;
import com.sistema.produto.gerenciarproduto.servico.ProdutoServico;
import com.sistema.produto.gerenciarproduto.servico.rest.PessoaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class ProdutoServicoImpl implements ProdutoServico {

    private ChequeEspecialRepositorio chequeEspecialRepositorio;
    private CartaoCreditoRepositorio cartaoCreditoRepositorio;
    private CartaoCreditoServico cartaoCreditoServico;
    private ChequeEspecialServico chequeEspecialServico;
    private PessoaServico pessoaServico;

    public ProdutoServicoImpl(ChequeEspecialRepositorio chequeEspecialRepositorio, CartaoCreditoRepositorio cartaoCreditoRepositorio, CartaoCreditoServico cartaoCreditoServico, ChequeEspecialServico chequeEspecialServico, PessoaServico pessoaServico) {
        this.chequeEspecialRepositorio = chequeEspecialRepositorio;
        this.cartaoCreditoRepositorio = cartaoCreditoRepositorio;
        this.cartaoCreditoServico = cartaoCreditoServico;
        this.chequeEspecialServico = chequeEspecialServico;
        this.pessoaServico = pessoaServico;
    }

    public ProdutoDTO criarProdutos(ProdutoPayload payload) {
        ProdutoDTO produtoDTO = new ProdutoDTO();
        final ApiResposta<Integer> resposta = pessoaServico.buscaScore(payload.getPessoaId());
        final Integer score = resposta.getResultado();
        CartaoCredito cartaoCredito = cartaoCreditoServico.criarCartaoCredito(payload.getPessoaId().intValue(), payload.getNumeroConta());
        if (cartaoCredito.getLimite() != null) {
            cartaoCredito = cartaoCreditoRepositorio.save(cartaoCredito);
            produtoDTO.setCartaoCredito(cartaoCredito);
        }
        ChequeEspecial chequeEspecial = chequeEspecialRepositorio.save(chequeEspecialServico.criarChequeEspecial(payload.getPessoaId().intValue(), payload.getNumeroConta()));
        produtoDTO.setChequeEspecial(chequeEspecial);
        return produtoDTO;
    }
}