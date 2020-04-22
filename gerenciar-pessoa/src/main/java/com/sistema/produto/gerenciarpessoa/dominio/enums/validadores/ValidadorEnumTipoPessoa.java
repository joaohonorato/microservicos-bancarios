package com.sistema.produto.gerenciarpessoa.dominio.enums.validadores;

import com.sistema.produto.gerenciarpessoa.dominio.enums.TipoPessoa;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.NotNull;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = ValidadorEnumTipoPessoaImpl.class)
@Target(ElementType.FIELD)
@NotNull(message = "Valor não pode ser nulo")
@ReportAsSingleViolation
public @interface ValidadorEnumTipoPessoa {
    TipoPessoa[] anyOf();

    String message() default "must be any of {anyOf}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}