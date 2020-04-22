package com.sistema.produto.gerenciarproduto.servico.implementacao;

import com.sistema.produto.gerenciarproduto.dominio.CartaoCredito;
import com.sistema.produto.gerenciarproduto.servico.CartaoCreditoServico;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
public class CartaoCreditoImpl implements CartaoCreditoServico {
    @Override
    public CartaoCredito criarCartaoCredito(Integer score, String numeroConta) {
        if(score==0 || score==1){
            return null;
        } else if(score>=2 && score<=5) {
            return new CartaoCredito(new BigDecimal(200),numeroConta);
        } else if(score>=6 && score<=8) {
            return new CartaoCredito(new BigDecimal(2000),numeroConta);
        } else {
            return new CartaoCredito(new BigDecimal(15000),numeroConta);
        }
    }
}
