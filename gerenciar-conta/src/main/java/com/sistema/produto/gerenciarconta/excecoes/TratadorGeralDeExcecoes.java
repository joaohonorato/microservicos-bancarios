package com.sistema.produto.gerenciarconta.excecoes;

import com.sistema.produto.gerenciarconta.excecoes.error.ApiError;
import com.sistema.produto.gerenciarconta.util.i18n.Mensagens;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
@Component
public class TratadorGeralDeExcecoes extends ResponseEntityExceptionHandler {

    private Mensagens mensagens;

    private static final Logger LOG = LoggerFactory.getLogger(TratadorGeralDeExcecoes.class);

    public TratadorGeralDeExcecoes(Mensagens mensagens) {
        this.mensagens = mensagens;
    }

    @ExceptionHandler(NumeroDeContasChegouAoLimiteExcecao.class)
    public ResponseEntity<Object> handleNumeroDeContasChegouAoLimite(Exception exception) {
        return buildResponseEntity(new ApiError(HttpStatus.BAD_GATEWAY,exception.getCause().getMessage(), exception));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<Object> handleConstraintViolation(
            javax.validation.ConstraintViolationException ex) {
        ApiError apiError = new ApiError(BAD_REQUEST);
        apiError.setMessage(mensagens.obterMensagem("excecao.violacao.restricao"));
        apiError.addValidationErrors(ex.getConstraintViolations());
        return buildResponseEntity(apiError);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        ServletWebRequest servletWebRequest = (ServletWebRequest) request;
        LOG.error("{} to {}", servletWebRequest.getHttpMethod(), servletWebRequest.getRequest().getServletPath());
        String error = mensagens.obterMensagem("excecao.mensagem.ilegivel");
        return buildResponseEntity(new ApiError(BAD_REQUEST, error, ex));
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ServletWebRequest servletWebRequest = (ServletWebRequest) request;
        LOG.error("{} to {}", servletWebRequest.getHttpMethod(), servletWebRequest.getRequest().getServletPath());
        String error = mensagens.obterMensagem("excecao.argumentos.invalidos");
        return buildResponseEntity(new ApiError(BAD_REQUEST, error, ex));
    }


    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
