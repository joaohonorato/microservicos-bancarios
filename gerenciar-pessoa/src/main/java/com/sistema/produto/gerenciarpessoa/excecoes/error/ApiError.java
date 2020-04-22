package com.sistema.produto.gerenciarpessoa.excecoes.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.HttpStatus;

import javax.validation.ConstraintViolation;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ApiError {

   private HttpStatus status;
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
   private LocalDateTime timestamp;
   private String message;
   private String debugMessage;
   @JsonInclude(JsonInclude.Include.NON_NULL)
   private List<ApiSubError> subErrors;

   private ApiError() {
       timestamp = LocalDateTime.now();
   }

   public ApiError(HttpStatus status) {
      super();
      this.status = status;
   }

   public ApiError(HttpStatus status, Throwable ex) {
      super();
      this.status = status;
      this.message = "Erro inesperado";
      this.debugMessage = ex.getLocalizedMessage();
   }

   public ApiError(HttpStatus status, String message, Throwable ex) {
      super();
      this.status = status;
      this.message = message;
      this.debugMessage = ex.getLocalizedMessage();
   }

   private void addSubError(ApiSubError subError) {
       if (subErrors == null) {
           subErrors = new ArrayList<>();
       }
       subErrors.add(subError);
   }

   private void addValidationError(String object, String field, Object rejectedValue, String message) {
       addSubError(new ApiValidationError(object, field, rejectedValue, message));
   }

   private void addValidationError(ConstraintViolation<?> cv) {
       this.addValidationError(
               cv.getRootBeanClass().getSimpleName(),
               ((PathImpl) cv.getPropertyPath()).getLeafNode().asString(),
               cv.getInvalidValue(),
               cv.getMessage());
   }

   public void addValidationErrors(Set<ConstraintViolation<?>> constraintViolations) {
       constraintViolations.forEach(this::addValidationError);
   }

   public HttpStatus getStatus() {
       return this.status;
   }

   public void setStatus(HttpStatus status) {
       this.status = status;
   }

   public LocalDateTime getTimestamp() {
       return this.timestamp;
   }

   public void setTimestamp(LocalDateTime timestamp) {
       this.timestamp = timestamp;
   }

   public String getMessage() {
       return this.message;
   }

   public void setMessage(String message) {
       this.message = message;
   }

   public String getDebugMessage() {
       return this.debugMessage;
   }

   public void setDebugMessage(String debugMessage) {
       this.debugMessage = debugMessage;
   }

   public List<ApiSubError> getSubErrors() {
       return this.subErrors;
   }

   public void setSubErrors(List<ApiSubError> subErrors) {
       this.subErrors = subErrors;
   }

   public ApiError status(HttpStatus status) {
       this.status = status;
       return this;
   }

   public ApiError timestamp(LocalDateTime timestamp) {
       this.timestamp = timestamp;
       return this;
   }

   public ApiError message(String message) {
       this.message = message;
       return this;
   }

   public ApiError debugMessage(String debugMessage) {
       this.debugMessage = debugMessage;
       return this;
   }

   public ApiError subErrors(List<ApiSubError> subErrors) {
       this.subErrors = subErrors;
       return this;
   }

   @Override
   public String toString() {
       return "{" +
           " status='" + getStatus() + "'" +
           ", timestamp='" + getTimestamp() + "'" +
           ", message='" + getMessage() + "'" +
           ", debugMessage='" + getDebugMessage() + "'" +
           ", subErrors='" + getSubErrors() + "'" +
           "}";
   }

}