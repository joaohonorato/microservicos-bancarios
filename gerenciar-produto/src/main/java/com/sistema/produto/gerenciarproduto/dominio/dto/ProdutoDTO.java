package com.sistema.produto.gerenciarproduto.dominio.dto;

import com.sistema.produto.gerenciarproduto.dominio.CartaoCredito;
import com.sistema.produto.gerenciarproduto.dominio.ChequeEspecial;

public class ProdutoDTO {
    private CartaoCredito cartaoCredito;
    private ChequeEspecial chequeEspecial;

    public CartaoCredito getCartaoCredito() {
        return cartaoCredito;
    }

    public void setCartaoCredito(CartaoCredito cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }

    public ChequeEspecial getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(ChequeEspecial chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }
}
