package com.sistema.produto.gerenciarconta.dominio.enums.validadores;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Implementacao da validacao do enum
 */
public class ValidadorEnumTipoImpl implements ConstraintValidator<ValidadorEnum, Enum<?>> {
    private List<String> acceptedValues;

    @Override
    public void initialize(ValidadorEnum constraint) {

        acceptedValues = Stream.of(constraint.enumClass().getEnumConstants())
                .map(Enum::name)
                .collect(Collectors.toList());
    }


    @Override
    public boolean isValid(Enum<?> value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return acceptedValues.contains(value.toString());
    }
}
