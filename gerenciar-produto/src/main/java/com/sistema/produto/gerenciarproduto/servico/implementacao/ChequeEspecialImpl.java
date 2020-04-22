package com.sistema.produto.gerenciarproduto.servico.implementacao;

import com.sistema.produto.gerenciarproduto.dominio.ChequeEspecial;
import com.sistema.produto.gerenciarproduto.servico.ChequeEspecialServico;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
public class ChequeEspecialImpl implements ChequeEspecialServico {
    @Override
    public ChequeEspecial criarChequeEspecial(int score, String numeroConta) {
        if(score==0 || score==1){
            return new ChequeEspecial(numeroConta, false);
        } else if(score>=2 && score<=5) {
            return new ChequeEspecial(new BigDecimal(1000),numeroConta,true);
        } else if(score>=6 && score<=8) {
            return new ChequeEspecial(new BigDecimal(2000),numeroConta,true);
        } else {
            return new ChequeEspecial(new BigDecimal(5000),numeroConta,true);
        }
    }
}
