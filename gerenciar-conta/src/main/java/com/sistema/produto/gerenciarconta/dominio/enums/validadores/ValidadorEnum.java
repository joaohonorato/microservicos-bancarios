package com.sistema.produto.gerenciarconta.dominio.enums.validadores;


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
@Constraint(validatedBy = ValidadorEnumTipoImpl.class)
@Target(ElementType.FIELD)
@NotNull
@ReportAsSingleViolation
public @interface ValidadorEnum {
    Class<? extends Enum> enumClass();

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}