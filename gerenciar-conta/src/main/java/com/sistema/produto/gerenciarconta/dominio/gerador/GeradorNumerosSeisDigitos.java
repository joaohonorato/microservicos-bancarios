package com.sistema.produto.gerenciarconta.dominio.gerador;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Properties;

/**
 * Gerador de numeros de seis digitos utilizando o gerador de sequencias do hibernate
 */
@Component
public class GeradorNumerosSeisDigitos extends SequenceStyleGenerator {
    public static final String VALUE_PREFIX_PARAMETER = "prefixoDoValor";
    public static final String VALUE_PREFIX_DEFAULT = "";
    private String valuePrefix;
    public static final String NUMBER_FORMAT_PARAMETER = "formatoDoNumero";
    public static final String NUMBER_FORMAT_DEFAULT = "%06d";
    private String numberFormat;

    @Override
    public Serializable generate(SharedSessionContractImplementor session,
                                 Object object) throws HibernateException {
        Serializable generate = super.generate(session, object);
        return valuePrefix + String.format(numberFormat, generate);
    }

    @Override
    public void configure(Type type, Properties params,
                          ServiceRegistry serviceRegistry) throws MappingException {
        super.configure(LongType.INSTANCE, params, serviceRegistry);
        valuePrefix = ConfigurationHelper.getString(VALUE_PREFIX_PARAMETER,
                params, VALUE_PREFIX_DEFAULT);
        numberFormat = ConfigurationHelper.getString(NUMBER_FORMAT_PARAMETER,
                params, NUMBER_FORMAT_DEFAULT);
    }
}