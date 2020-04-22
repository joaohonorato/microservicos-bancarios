package com.sistema.produto.gerenciarpessoa.dominio.enums.validadores;

import com.sistema.produto.gerenciarpessoa.dominio.enums.TipoPessoa;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class ValidadorEnumTipoPessoaImpl implements ConstraintValidator<ValidadorEnumTipoPessoa, TipoPessoa> {
    private TipoPessoa[] subset;

    @Override
    public void initialize(ValidadorEnumTipoPessoa constraint) {
        this.subset = constraint.anyOf();
    }


    @Override
    public boolean isValid(TipoPessoa value, ConstraintValidatorContext context) {
        return value == null || Arrays.asList(subset).contains(value);
    }
}
