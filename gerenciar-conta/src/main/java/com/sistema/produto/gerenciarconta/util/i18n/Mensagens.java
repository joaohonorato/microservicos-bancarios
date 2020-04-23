package com.sistema.produto.gerenciarconta.util.i18n;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * Responsavel por obter mensagens do bundle
 */
@Component
public class Mensagens {

    private ResourceBundleMessageSource messageSource;

    public String obterMensagem(String chave, Object... args) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(chave, args, locale);
    }
}
